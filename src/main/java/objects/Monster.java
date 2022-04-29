package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.AbstractEnemy;
import screens.Play;


public class Monster extends AbstractEnemy {

    private final int damage = 1;
    private int health = 25;
    private final String name = "monster";

    /**
     * Creates a new monster instance
     * @param sprite
     * @param collisionLayer
     * @param play
     */
    public Monster(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
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
    public String getName() {
        return name;
    }

    /**
     * Inflicts the damage given by a player
     * @param mainPlayer
     */
    public void getAttack(objects.MainPlayer mainPlayer){
        mainPlayer.loseHealth(this.damage);
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
