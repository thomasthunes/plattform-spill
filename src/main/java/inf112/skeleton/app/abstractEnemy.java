package inf112.skeleton.app;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import objects.IEnemy;
import screens.Play;

import java.util.Random;

public abstract class abstractEnemy extends abstractPlayer implements IEnemy {

    private final int damage = 1;
    private int health = 25;
    private Play game;
    private objects.mainPlayer mainPlayer;

    /**
     * specifies the common properties of all enemies
     * @param sprite
     * @param collisionLayer
     * @param play
     */
    public abstractEnemy(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer);
        this.game = play;
        setSize((float) (getWidth()*0.4), (float) (getHeight()*0.3));

    }


    @Override
    public int getHealth() {
        return health;
    }

    public Play getGame(){
        return game;
    }

    /**
     * Reduces the health by the amount of damage
     * @param damage
     */
    @Override
    public void loseHealth(int damage) {
        if (health > 0) {
            int newHealth = health - damage;
            health = newHealth;
        }
    }


    @Override
    public void update() {
    }

    /**
     *
     * @return the damage given by this enemy
     */
    @Override
    public abstract int getDamage();

    @Override
    public abstract int getAmount();

    /**
     *
     * @return The name of the enemy
     */
    @Override
    public abstract String getName();

    /**
     * abstract method specifying each the attack of a specific enemy
     * @param mainPlayer
     */
    public abstract void getAttack(objects.mainPlayer mainPlayer);

    /**
     * sets velocity x to positive speed, moving the enemy to the right
     */
    @Override
    public void moveRight() {
        getVelocity().x = getSpeed();
    }

    /**
     * sets velocity x to negative speed, moving the enemy to the left
     */
    @Override
    public void moveLeft() {
        getVelocity().x = -getSpeed();
    }

    /**
     * sets velocity x to zero
     */
    public void stopMoving(){
        getVelocity().x = 0;
    }

    /**
     *
     * @return true if health is above 0 and item isAlive
     */
    public boolean isAlive(){
        if (getHealth() > 0 && super.isAlive()){
            return true;
        }
        return false;
    }

    /**
     * moves enemy to a random direction (left or right)
     */
    @Override
    public void moveRandom() {
        Random rand = new Random();
        if (isAlive()){
            if (rand.nextBoolean()){
                moveLeft();
            }
            else {
                moveRight();
            }
        }
    }

    public void setHealth(int newHealth) {

    }

}
