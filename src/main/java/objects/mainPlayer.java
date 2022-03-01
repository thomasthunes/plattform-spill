package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;

import java.util.List;

public class mainPlayer extends Player {

    private String message = "";

    public mainPlayer(Sprite sprite, TiledMapTileLayer collisionLayer) {
        super(sprite, collisionLayer);
    }

    public void dieFromFall(){
        if (!collidesBottom(getCollisionLayer().getTileWidth()/2) && getSpeed() == 0.0){
            setMessage("You died from falling");
            loseHealth(100);
        }
    }

    public void setMessage(String newMessage){
        message = newMessage;
    }

    public String getMessage() {
        return message;
    }
}
