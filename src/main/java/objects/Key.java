package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Key extends Item{

    private final String name = "key";

    /**
     * Creates a new key instance
     * @param sprite
     * @param collisionLayer
     */
    public Key(Sprite sprite, TiledMapTileLayer collisionLayer) {
        super(sprite, collisionLayer);
        setSize((float) (getWidth()*0.2), (float) (getHeight()*0.2));
    }

    public String getName(){
        return name;
    }


}
