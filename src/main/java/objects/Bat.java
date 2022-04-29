package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.AbstractEnemy;
import inf112.skeleton.app.AbstractPlayer;
import screens.Play;

import java.util.List;
import java.util.Random;

public class Bat extends AbstractEnemy {

    private final int damage = 10;
    private final String name = "bat";

    /**
     * Creates a new bat instance
     * @param sprite
     * @param collisionLayer
     * @param play
     */
    public Bat(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer, play);
    }

    @Override
    public void update(){
        attack();
    }

    /**
     * @return Damage
     */
    @Override
    public int getDamage() {
        return damage;
    }

    /**
     * @return Name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Inflicts the damage given from a player
     * @param mainPlayer
     */
    @Override
    public void getAttack(objects.MainPlayer mainPlayer) {
        mainPlayer.loseHealth(this.damage);
    }

    /**
     * moves a bat towards the players directions
     */
    public void moveToPlayer() {
        List<objects.MainPlayer> players = getGame().getPlayers();
        AbstractPlayer player = null;
        if (players.size() == 1) {
            player = getGame().getPlayers().get(0);
        }
        else {
            Random rand = new Random();
            player = getGame().getPlayers().get(rand.nextInt(2));
        }

        boolean left = player.getX() < this.getX();
        boolean right = player.getX() > this.getX();
        if (left) {
            moveLeft();
        }
        if (right) {
            moveRight();
        }
    }

    /**
     * runs moveToPlayer method
     */
    public void attack(){
        moveToPlayer();
        if (getVelocity().y == 0){
            getVelocity().y = getSpeed();
        }
    }

    @Override
    public void moveRandom() {
    }
}
