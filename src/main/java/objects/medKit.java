package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;

public class medKit extends Item/*Player*/ {

    private final int hp;
    private final String name;

    public medKit(Sprite sprite, TiledMapTileLayer tiledMapTileLayer) {
        super(sprite, tiledMapTileLayer);
        this.hp = 20;
        this.name = "MedKit";
        setSize((float) (getWidth()*0.5), (float) (getHeight()*0.5));
    }

    @Override
    public int getAmount(){
        return hp;
    }

    @Override
    public String getName() {
        return name;
    }
}
