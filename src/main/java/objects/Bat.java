package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.abstractEnemy;
import inf112.skeleton.app.abstractPlayer;
import screens.Play;

import java.util.List;
import java.util.Random;

public class Bat extends abstractEnemy {

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

    @Override
    public int getAmount() {
        return 0;
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
    public void getAttack(objects.mainPlayer mainPlayer) {
        mainPlayer.loseHealth(this.damage);
    }

    /**
     * moves a bat towards the players directions
     */
    public void moveToPlayer() {
        List<objects.mainPlayer> players = getGame().getPlayers();
        abstractPlayer player = null;
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
