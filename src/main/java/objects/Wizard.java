package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.abstractEnemy;
import screens.Play;

import java.util.Random;

public class Wizard extends abstractEnemy {

    private final String name = "wizard";
    private final int damage = 50;
    private int health = 400;
    private final float startX = getCollisionLayer().getTileWidth();
    private final float startY = (getCollisionLayer().getHeight() - 6) * getCollisionLayer().getTileHeight();

    /**
     * Creates a new Wizard instance
     * @param sprite
     * @param collisionLayer
     * @param play
     */
    public Wizard(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer, play);
        setSize((float) (getWidth()*2), (float) (getHeight()*2));
    }

    @Override
    public int getHealth(){
        return health;
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
        return name;
    }

    /**
     * The attack of a wizard
     * 1. Sets the position of the players to the upper left corner
     * 2. Inflicts damage to the player it attacked
     * 3. Teleports to a new random position
     * @param mainPlayer
     */
    @Override
    public void getAttack(objects.mainPlayer mainPlayer) {
        mainPlayer.setPosition(startX, startY);
        mainPlayer.loseHealth(this.damage);
        if (mainPlayer.getOtherPlayer() != null){
            mainPlayer.getOtherPlayer().setPosition(10 * startX, startY);
        }
        Random rand = new Random();
        this.setPosition(rand.nextInt(700) * startX, startY);
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
