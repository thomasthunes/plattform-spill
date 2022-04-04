package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;
import screens.Play;

public class bombs extends Enemy{

    private final String name;
    private final boolean isAlive = true;
    private int hp = 1;

    public bombs(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer, play);
        this.name = "bomb";
    }


    @Override
    public int getHealth() {
        return hp;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    /*public boolean isAlive(){
        if (hp > 0){
            return true;
        }
        return false;
    }*/

    @Override
    public void loseHealth(int damage) {
        if (hp > 0) {
            int newHealth = hp - damage;
            hp = newHealth;
        }
    }

    @Override
    public void getAttack() {
        Player player = getGame().getPlayer();
        player.getVelocity().y = player.getSpeed()+250 / 1.8f;
        player.getVelocity().x = player.getSpeed()+50;
        loseHealth(hp);
    }
}
