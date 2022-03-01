package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Player;

import objects.mainPlayer;
import org.lwjgl.opengl.GL20;

import javax.swing.*;

public class Play implements Screen {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    //private SpriteBatch batch;
    private Player player;
    private BitmapFont font;


    @Override
    public void show() {
    	//batch = new SpriteBatch();
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("assets/maps/map1.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();
        font = new BitmapFont();

        //TiledMapTileLayer layer1 = (TiledMapTileLayer) map.getLayers().get("Board");

        //camera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //cam.position.set(cam.viewportWidth/2f, cam.viewportHeight/2f, 0);
        //camera.update();

        player = new mainPlayer(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0));//new Player(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0));
        player.setPosition(7 * player.getCollisionLayer().getTileWidth(), (player.getCollisionLayer().getHeight() - 38) * player.getCollisionLayer().getTileHeight());

        //renderer.setView(camera);

        Gdx.input.setInputProcessor(player);
    }

    public Player getPlayer(){
        return player;
    }


    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setView(camera);
        renderer.render();

        camera.position.set(player.getX(), player.getY(), 0);
        camera.update();
        player.dieFromFall();
        
        renderer.getBatch().begin();
        player.draw(renderer.getBatch());
        player.draw(renderer.getBatch());
        font.draw(renderer.getBatch(), "Current Health: " + player.getHealth(), player.getX(), 30);
        font.draw(renderer.getBatch(), player.getMessage(), player.getX()+200, 30);

        renderer.getBatch().end();
    }


    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.setToOrtho(false, width, height);
        camera.update();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        player.getTexture().dispose();
    }
}
