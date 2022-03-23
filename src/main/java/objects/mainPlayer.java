package objects;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;
import screens.Play;

import java.util.ArrayList;
import java.util.List;

public class mainPlayer extends Player implements IMainPlayer, InputProcessor {

    private String message = "";
    private Play game;
    private final int damage;
    private int health = 100;
    private int killStreak = 0;

    private List<IItem> inventory;

    private Enemy currentEnemy;

    public mainPlayer(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer);
        game = play;
        this.damage = 50;
        this.inventory = new ArrayList<>();
    }


    @Override
    public void update(){
        isAttacted();
        attack();

        if (!inBounds()){
            setMessage("You died from falling");
            loseHealth(100);
        }
        else if (this.getHealth() == 0){
            setMessage("You were defeated by the enemy");
        }
    }

    private boolean isAttacted() {
        for (Enemy enemy : game.getEnemies()){
            double thisY = Math.floor(this.getY());
            double enemyY = Math.floor(enemy.getY());

            if (collidesWithActorFromSide(this, enemy) && thisY == enemyY && enemy.isAlive()){
                loseHealth(enemy.getDamage());
                return true;
            }
        }
        return false;
    }

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

    /*public boolean collidesWithActorFromSide(Enemy enemy) {
        if (this.getX() < enemy.getX() + 30 && this.getX() > enemy.getX() - 30){
            return true;
        }
        return false;
    }

    public boolean collidesWithActorFromTop(Enemy enemy){
        double thisY = Math.floor(this.getY());
        double enemyY = Math.floor(enemy.getY());

        if (thisY == enemyY + 30){
            return true;
        }
        return false;
    }*/


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
        return null;
    }

    @Override
    public void addItem(IItem item) {
        inventory.add(item);
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
    }

    /*@Override
    public void setMessage(String newMessage){
        message = newMessage;
    }

    @Override
    public String getMessage() { 
        return message;
    }*/

    public void pickUpItem(){
        for (Item item : game.getItems()) {
            if (collidesWithActorFromSide(this, item)) {
                addItem(item);
            }
        }
        checkInventory();
    }

    private void checkInventory() {
        List<IItem> usedItems = new ArrayList<>();
        for (IItem item : inventory){
            if (item.getName() == "MedKit" && item.isAlive()){
                item.setState();
                setHealth(item.getAmount());
                usedItems.add(item);
            }
        }
    }

    private void removeUsedItem(List<IItem> items){
        inventory.remove(items);
    }


    @Override
    public boolean keyDown(int keycode) {
        for (Enemy enemy : game.getEnemies()){
            enemy.move();
        }
        switch(keycode) {

            case Input.Keys.SPACE:
                if(GetCanJump())
                    getVelocity().y = getSpeed()+250 / 1.8f;
                SetCanJump(false);

                break;

            case Input.Keys.A:
            case Input.Keys.LEFT:
            	if(!GetCanJump())
            		getVelocity().x = -getSpeed() + 50;
            	else
            		getVelocity().x = -getSpeed();

                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
            	if(!GetCanJump())
            		getVelocity().x = getSpeed() - 50;
            	else
            		getVelocity().x = getSpeed();
                break;

            case Input.Keys.P:
                pickUpItem();
                break;
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
