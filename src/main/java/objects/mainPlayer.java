package objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.abstractEnemy;
import inf112.skeleton.app.abstractPlayer;
import screens.Play;

import java.util.ArrayList;
import java.util.List;

public class mainPlayer extends abstractPlayer implements IMainPlayer {

    //Constants
    private final int MAXHEALTH = 120;

    private Play game;
    private final int damage;
    private int health = 100;
    private int killStreak = 0;
    private boolean hasKey = false;

    private int currentLevel = 0;
    private boolean playerWon = false;
    
    public Sound jump;

    private List<IItem> inventory;

    private abstractEnemy currentEnemy;

    public mainPlayer(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer);
        game = play;
        this.damage = 50;
        this.inventory = new ArrayList<>();
        jump = Gdx.audio.newSound(Gdx.files.internal("assets/sounds/jump.wav"));
    }


    @Override
    public void update(){
        isAttacted();
        attack();
        playerWon();

        if (!inBounds()){
            setMessage("You died from falling");
            loseHealth(100);
        }
        else if (this.getHealth() == 0){
            setMessage("You were defeated by the enemy");
        }
    }

    public abstractPlayer getPlayer(){
        return this;
    }

    public Play getGame(){
        return game;
    }

    /**
     * loops through all enemies to see if the player collides with any of them
     * if true, the player is affected, with whatever attack specified in getAttack
     * @return boolean
     */
    private boolean isAttacted() {
        for (abstractEnemy enemy : game.getEnemies()){
            double thisY = Math.floor(this.getY());
            double enemyY = Math.floor(enemy.getY());

            if (collidesWithActorFromSide(this, enemy) && thisY == enemyY && enemy.isAlive()){
                enemy.getAttack(this);
                return true;
            }
        }
        return false;
    }

    /**
     * displays "game over" if player has picked up the key, and the player is on the finish pad
     * displays instructions if the player is on the finish pad, but does not have the key
     * @return boolean
     */
    private boolean playerWon(){

        if (hasKey() && getGameStatus() && currentLevel() > 0){
            setMessage("Player won!");
            playerWon = true;
        }
        else if (hasKey() && getGameStatus() && currentLevel() == 0){
            setMessage("You have reached level 1");
            nextLevel();
            setPosition(514  * getCollisionLayer().getTileWidth(), (getCollisionLayer().getHeight() - 8) * getCollisionLayer().getTileHeight());
            return true;
        }
        else if (!hasKey() && getGameStatus()){
            setMessage("You need to find the key before you can finish!");
            setPosition(288  * getCollisionLayer().getTileWidth(), (getCollisionLayer().getHeight() - 43) * getCollisionLayer().getTileHeight());
        }
        return false;
    }

    public boolean getPlayerWon(){
        return playerWon;
    }

    public void setPlayerWon(boolean arg){
        playerWon = arg;
    }


    private void nextLevel() {
        currentLevel++;
    }

    /**
     *
     * @return the level player is on
     */
    public int currentLevel(){
        return currentLevel;
    }

    /**
     * kills the enemy if the player jumps on the enemy
     */
    public void attack(){
        for (abstractEnemy enemy : game.getEnemies()) {
            if (collidesWithActorFromTop(this, enemy) && collidesWithActorFromSide(this, enemy) && getVelocity().y < 0) {
                enemy.loseHealth(this.damage);
                getVelocity().y = getSpeed()+250 / 1.8f;

                if (!enemy.isAlive()) {
                    killStreak++;
                    setMessage("You have killed " + killStreak + " enemies!");
                }
            }
        }
    }

    public int getKillStreak(){
        return killStreak;
    }


    /**
     *
     * @return damage
     */
    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public String getName() {
        return "player";
    }

    /**
     * adds an item to the inventory list
     * @param item
     */
    @Override
    public void addItem(IItem item) {
        inventory.add(item);
    }

    /**
     *
     * @return current health
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * health is boosted by the given amount
     * @param amount
     */
    public void setHealth(int amount){
        health += amount;
        if (health > MAXHEALTH)
            health = MAXHEALTH;
    }


    /**
     * health reduced by enemy's damage
     * if health is 0 or less, player dies
     * @param damage
     */
    @Override
    public void loseHealth(int damage) {
        if (health > 0) {
            int newHealth = health - damage;
            health = newHealth;
        }
        if (health < 1){
            setAliveToFalse();
        }
    }

    /**
     * adds an item to the player inventory, if the player is close enough
     */
    public void pickUpItem(){
        for (Item item : game.getItems()) {
            double thisY = Math.floor(this.getY());
            double itemY = Math.floor(item.getY());
            if (collidesWithActorFromSide(this, item) && thisY == itemY) {
                if (item.getName() == "key" && game.getVampire().isAlive()){
                    continue;
                }
                else {
                    addItem(item);
                }
            }
        }
        checkInventory();
    }

    /**
     * gets the other player if there are two players
     * @return the other mainPlayer
     */
    public mainPlayer getOtherPlayer(){
        List<mainPlayer> players = game.getPlayers();
        if (players.size() < 2){
            return null;
        }
        mainPlayer otherPlayer = this;
        for (mainPlayer player : players){
            if (!player.equals(this)){
                otherPlayer = player;
            }
        }
        return otherPlayer;

    }

    /**
     * checks the inventory of the player and initiates interaction with the items
     */
    private void checkInventory() {
        List<IItem> usedItems = new ArrayList<>();
        for (IItem item : inventory){
            if (item.getName() == "MedKit" && item.isAlive()){
                item.setAliveToFalse();
                setHealth(item.getAmount());
                usedItems.add(item);
            }
            else if (item.getName() == "key"){
                this.setKey(true);
                if (getOtherPlayer() != null)
                    getOtherPlayer().setKey(true);
                item.setAliveToFalse();
                setMessage("You found the key, get to the finish zone!");
            }
        }
    }

    /**
     * set key to true or false
     * @param bool
     */
    public void setKey(boolean bool) {
        hasKey = bool;
    }

    /**
     *
     * @return true or false
     */
    public boolean hasKey(){
        return hasKey;
    }

}
