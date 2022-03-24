package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;
import screens.Play;

import java.util.Random;


public class monster extends Enemy{

    private final int damage = 1;
    private int health = 25;
    private Play game;
    private final String name = "monster";

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

    public void getAttack(){
        getGame().getPlayer().loseHealth(this.damage);
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public boolean isAlive(){
        if (getHealth() > 0){
            return true;
        }
        return false;
    }

    @Override
    public void loseHealth(int damage) {
        if (health > 0) {
            int newHealth = health - damage;
            health = newHealth;
        }
    }
}
