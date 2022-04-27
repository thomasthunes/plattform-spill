package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import jdk.jfr.Event;
import screens.MenuScreen;
import screens.Play;

import java.util.ArrayList;
import java.util.List;

public class app extends Game {

    public int currentMap;
    public List<String> maps = new ArrayList<>();
    private Play play;

    public app(){
        maps.add("assets/maps/map1.tmx");
        maps.add("assets/maps/map2.tmx");
        currentMap = 0;
    }

    @Override
    public void create() {
//        this.play = new Play(maps.get(currentMap), this);
//
//        setScreen(play);
    	
    	setScreen(new MenuScreen(this));

        currentMap++;
        



    }

    /*public void changeMap(){
        this.play.dispose();
        if (maps.size() > currentMap)
            create();
    }*/

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
        //if (play.nextMap()){
        //create();
       // }
    }
}
