package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.abstractEnemy;
import inf112.skeleton.app.abstractPlayer;
import screens.Play;

public class bombs extends abstractEnemy {

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

    @Override
    public void loseHealth(int damage) {
        if (hp > 0) {
            int newHealth = hp - damage;
            hp = newHealth;
        }
    }

    /**
     * Bomb explodes and the player is thrown away
     * @param mainPlayer
     */
    @Override
    public void getAttack(objects.mainPlayer mainPlayer) {
        abstractPlayer player = mainPlayer;
        player.getVelocity().y = player.getSpeed()+250 / 1.8f;
        player.getVelocity().x = player.getSpeed()+50;
        loseHealth(hp);
    }
}
