package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;
import screens.Play;

import java.util.Random;

public abstract class Enemy extends Player implements IEnemy{

    private final int damage = 1;
    private int health = 25;
    private Play game;

    public Enemy(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
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
    public abstract int getDamage();

    @Override
    public abstract int getAmount();

    @Override
    public abstract String getName();

    public abstract void getAttack();

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
        if (getHealth() > 0 && super.isAlive()){
            return true;
        }
        //setState();
        return false;
    }

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

    public void move(){
        // Todo: save the start value in a map,
        //  and move the enemy n-length to left
        //  and then n-length to the right when it has reached the n-left pos
        /*for (Enemy enemy : game.getEnemies()){
            if (enemy.isAlive()){
                if ()
            }
        }*/
    }

    public void setHealth(int newHealth) {

    }
}
