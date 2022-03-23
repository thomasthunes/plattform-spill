package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;
import screens.Play;

import java.util.Random;

public class Enemy extends Player implements IEnemy{

    private final int damage = 1;
    private int health = 25;
    private final float initialX;
    private Play game;

    public Enemy(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer);
        this.initialX = this.getX();
        this.game = play;

    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void loseHealth(int damage) {
        if (health > 0) {
            int newHealth = health - damage;
            health = newHealth;
        }
    }

    @Override
    public void update() {
        Player player = game.getPlayer();

        System.out.println("player y: " + player.getY());
        System.out.println("enemy y: " + this.getY());

        if (player.getY() < this.getY()) {
            this.loseHealth(player.getDamage());
            setMessage("you killed an enemy!");
            System.out.println(this.isAlive());
        }
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
        return null;
    }

    @Override
    public void moveRight() {
        getVelocity().x = getSpeed();
    }

    @Override
    public void moveLeft() {
        getVelocity().x = -getSpeed();
    }

    public void stopMoving(){
        getVelocity().x = 0;
    }

    public boolean isAlive(){
        if (getHealth() > 0){
            return true;
        }
        //setState();
        return false;
    }

    @Override
    public void move() {
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
        health = newHealth;
    }
}
