package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import jdk.jfr.Event;
import screens.MenuScreen;
import screens.Play;

import java.util.ArrayList;
import java.util.List;

public class App extends Game {

    public App(){
    }

    @Override
    public void create() {
    	setScreen(new MenuScreen(this));
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
