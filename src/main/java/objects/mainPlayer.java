package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;

public class mainPlayer extends Player {
    public mainPlayer(Sprite sprite, TiledMapTileLayer collisionLayer) {
        super(sprite, collisionLayer);
    }
}
