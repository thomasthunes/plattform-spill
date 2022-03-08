package objects;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;

import java.util.List;

public class mainPlayer extends Player implements IMainPlayer, InputProcessor {

    private String message = "";

    public mainPlayer(Sprite sprite, TiledMapTileLayer collisionLayer) {
        super(sprite, collisionLayer);
    }

    @Override
    public void dieFromFall(){
        if (!inBounds()){
            setMessage("You died from falling");
            loseHealth(100);
        }
    }

    @Override
    public void setMessage(String newMessage){
        message = newMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }


    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {

            case Input.Keys.SPACE:
                if(GetCanJump())
                    getVelocity().y = getSpeed()+250 / 1.8f;
                SetCanJump(false);

                break;

            case Input.Keys.A:
                getVelocity().x = -getSpeed();
            case Input.Keys.LEFT:
                getVelocity().x = -getSpeed();

                break;
            case Input.Keys.D:
                getVelocity().x = getSpeed();
            case Input.Keys.RIGHT:
                getVelocity().x = getSpeed();
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch(keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:

            case Input.Keys.D:
            case Input.Keys.RIGHT:
                getVelocity().x = 0;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
