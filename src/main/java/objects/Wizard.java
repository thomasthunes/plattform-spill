package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import screens.Play;

import java.util.Random;

public class Wizard extends Enemy{

    private final String name = "wizard";
    private final int damage = 50;
    private final int health = 400;
    private final float startX = getCollisionLayer().getTileWidth();
    private final float startY = (getCollisionLayer().getHeight() - 4) * getCollisionLayer().getTileHeight();



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

    @Override
    public void getAttack(mainPlayer mainPlayer) {
        mainPlayer.setPosition(startX, startY);
        mainPlayer.loseHealth(this.damage);
        if (mainPlayer.getOtherPlayer() != null){
            mainPlayer.getOtherPlayer().setPosition(10 * startX, startY);
        }
        Random rand = new Random();
        this.setPosition(rand.nextInt(700) * startX, startY);
    }

}
