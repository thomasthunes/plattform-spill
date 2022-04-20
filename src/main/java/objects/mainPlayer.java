package objects;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;
import org.lwjgl.system.CallbackI;
import screens.Play;

import java.util.ArrayList;
import java.util.List;

public class mainPlayer extends Player implements IMainPlayer, InputProcessor {

    private String message = "";
    private Play game;
    private final int damage;
    private int health = 100;
    private int killStreak = 0;
    private boolean hasKey = false;
    private List<mainPlayer> players;
    private int jump;
    private int left;
    private int right;

    private List<IItem> inventory;

    private Enemy currentEnemy;

    public mainPlayer(Sprite sprite, TiledMapTileLayer collisionLayer, Play play, List<mainPlayer> players) {
        super(sprite, collisionLayer);
        game = play;
        this.damage = 50;
        this.inventory = new ArrayList<>();
        this.players = players;
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

    /**
     * loops through all enemies to see if the player collides with any of them
     * if true, the player is affected, with whatever attack specified in getAttack
     * @return boolean
     */
    private boolean isAttacted() {
        for (Enemy enemy : game.getEnemies()){
            double thisY = Math.floor(this.getY());
            double enemyY = Math.floor(enemy.getY());

            if (collidesWithActorFromSide(this, enemy) && thisY == enemyY && enemy.isAlive()){
                enemy.getAttack();
                return true;
            }
        }
        return false;
    }

    public void nextLevel(){
        this.setX(509 * this.getCollisionLayer().getTileWidth());
    }

    /**
     * displays "game over" if player has picked up the key, and the player is on the finish pad
     * displays instructions if the player is on the finish pad, but does not have the key
     * @return boolean
     */
    public boolean playerWon(){
        if (hasKey() && getGameStatus()){
            setMessage("Player won!");
            return true;
        }
        else if (!hasKey() && getGameStatus()){
            nextLevel();
            setMessage("You need to find the key before you can finish!");
        }
        return false;
    }

    /**
     * kills the enemy if the player jumps on the enemy
     */
    public void attack(){
        for (Enemy enemy : game.getEnemies()) {
            if (collidesWithActorFromTop(this, enemy) && collidesWithActorFromSide(this, enemy) && getVelocity().y < 0) {
                enemy.loseHealth(this.damage);
                killStreak++;
                getVelocity().y = getSpeed()+250 / 1.8f;
                setMessage("You have killed " + killStreak + " enemies!");
            }
        }
    }



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
        if (item.getName() != "key"){
            inventory.add(item);
        }
        else if (!game.getVampire().isAlive() && item.getName() == "key"){
            inventory.add(item);
        }
    }

    @Override
    public List<IItem> getInventory() {
        return inventory;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setHealth(int amount){
        health += amount;
    }

    @Override
    public void loseHealth(int damage) {
        if (health > 0) {
            int newHealth = health - damage;
            health = newHealth;
        }
        /*else {
            setAliveToFalse();
        }*/
    }

    /**
     *
     */
    public void pickUpItem(){
        for (Item item : game.getItems()) {
            double thisY = Math.floor(this.getY());
            double itemY = Math.floor(item.getY());
            if (collidesWithActorFromSide(this, item) && thisY == itemY) {
                addItem(item);
            }
        }
        checkInventory();
    }

    private void checkInventory() {
        List<IItem> usedItems = new ArrayList<>();
        for (IItem item : inventory){
            if (item.getName() == "MedKit" && item.isAlive()){
                item.setAliveToFalse();
                setHealth(item.getAmount());
                usedItems.add(item);
            }
            else if (item.getName() == "key"){
                hasKey = true;
                item.setAliveToFalse();
                setMessage("You found the key, get to the finish zone!");
            }
        }
    }

    public boolean hasKey(){
        return hasKey;
    }

    private void removeUsedItem(List<IItem> items){
        inventory.remove(items);
    }


    @Override
    public boolean keyDown(int keycode) {
        for (Enemy enemy : game.getEnemies()) {
            if (enemy.getName() != "bat") {
                enemy.moveRandom();
            }
        }
        if (players.get(0).equals(this)) {
            System.out.println("first case");
            switch (keycode) {
                case Input.Keys.SPACE:
                    if (GetCanJump())
                        getVelocity().y = getSpeed();
                    SetCanJump(false);
                    break;

                case Input.Keys.A:
                    //case Input.Keys.LEFT:
                    getVelocity().x = -getSpeed();
                    break;
                case Input.Keys.D:
                    //case Input.Keys.RIGHT:
                    getVelocity().x = getSpeed();
                    break;

                case Input.Keys.P:
                    pickUpItem();
                    break;
            }
        } else if (players.get(1).equals(this)){
            System.out.println("second case");
            switch (keycode) {
                case Input.Keys.UP:
                    if (GetCanJump())
                        getVelocity().y = getSpeed()/*+250 / 1.8f*/;
                    SetCanJump(false);
                    break;

                //case Input.Keys.A:
                case Input.Keys.LEFT:
                    getVelocity().x = -getSpeed();
                    break;

                //case Input.Keys.D:
                case Input.Keys.RIGHT:
                    getVelocity().x = getSpeed();
                    break;

                case Input.Keys.F:
                    pickUpItem();
                    break;
            }
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch(keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:

            case Input.Keys.D:
            case Input.Keys.RIGHT:
                getVelocity().x = 0;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
