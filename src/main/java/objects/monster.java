package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.abstractEnemy;
import screens.Play;


public class monster extends abstractEnemy {

    private final int damage = 1;
    private int health = 25;
    private Play game;
    private final String name = "monster";

    /**
     * Creates a new monster instance
     * @param sprite
     * @param collisionLayer
     * @param play
     */
    public monster(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer, play);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage(){
        return damage;
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Inflicts the damage given by a player
     * @param mainPlayer
     */
    public void getAttack(objects.mainPlayer mainPlayer){
        mainPlayer.loseHealth(this.damage);
    }

    /**
     * Sets the health to newHealth
     * @param newHealth
     */
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    /**
     * Reduces the health of the instance with -damage
     * @param damage
     */
    @Override
    public void loseHealth(int damage) {
        if (health > 0) {
            int newHealth = health - damage;
            health = newHealth;
        }
    }
}
