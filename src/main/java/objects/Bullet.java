package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;

public class Bullet extends Player {

    private String picture;
    private int damage = 100;


    public Bullet(Sprite sprite, TiledMapTileLayer collisionLayer) {
        super(sprite, collisionLayer);
        setGravity(0);
        picture = "assets/maps/bat.png";
    }

    public String getPicture(){
        return picture;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void loseHealth(int damage) {

    }

    @Override
    public void update() {

    }

    @Override
    public int getDamage() {
        return damage;
    }


}
