package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
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

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import inf112.skeleton.app.Player;

import inf112.skeleton.app.app;
import objects.*;
import org.lwjgl.opengl.GL20;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Play extends Event implements Screen {

    // CONSTANTS
    private final int STARTPOSITION = 38;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    //private SpriteBatch batch;
    private mainPlayer player;
    private medKit medKit;
    //private Enemy enemy;
    private BitmapFont font;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private int gameCount = 0;
    private String currentMap;
    private app app;

    public Play(String currentMap, app app){
        this.currentMap = currentMap;
        this.app = app;
    }

    @Override
    public void show() {
    	//batch = new SpriteBatch();
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load(currentMap);//loader.load("assets/maps/map1.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();
        font = new BitmapFont();

        //TiledMapTileLayer layer1 = (TiledMapTileLayer) map.getLayers().get("Board");

        //camera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //cam.position.set(cam.viewportWidth/2f, cam.viewportHeight/2f, 0);
        //camera.update();

        player = new mainPlayer(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0), this);//new Player(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0));
        player.setPosition(7 * player.getCollisionLayer().getTileWidth(), (player.getCollisionLayer().getHeight() - STARTPOSITION) * player.getCollisionLayer().getTileHeight());

        int numberOfEnemies = 50;
        Random rand = new Random();
        for (int n = 0; n < numberOfEnemies; n++) {
            int xPos = rand.nextInt(317);
            monster monster = new monster(new Sprite(new Texture("assets/maps/monster.png")), (TiledMapTileLayer) map.getLayers().get(0), this);
            monster.setPosition(xPos * monster.getCollisionLayer().getTileWidth(), (monster.getCollisionLayer().getHeight() - 4) * monster.getCollisionLayer().getTileHeight());
            enemies.add(monster);
        }

        bombs bombs = new bombs(new Sprite(new Texture("assets/maps/bomb.png")), (TiledMapTileLayer) map.getLayers().get(0), this);//new Player(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0));
        bombs.setPosition(14 * bombs.getCollisionLayer().getTileWidth(), (bombs.getCollisionLayer().getHeight() - STARTPOSITION) * bombs.getCollisionLayer().getTileHeight());

        enemies.add(bombs);


        medKit = new medKit(new Sprite(new Texture("assets/maps/medkit.png")), (TiledMapTileLayer) map.getLayers().get(0));
        medKit.setPosition(17 * medKit.getCollisionLayer().getTileWidth(), (player.getCollisionLayer().getHeight() - STARTPOSITION) * player.getCollisionLayer().getTileHeight());
        items.add(medKit);

        Key key = new Key(new Sprite(new Texture("assets/maps/key.png")), (TiledMapTileLayer) map.getLayers().get(0));
        key.setPosition(12 * key.getCollisionLayer().getTileWidth(), (key.getCollisionLayer().getHeight() - STARTPOSITION) * key.getCollisionLayer().getTileHeight());
        items.add(key);


        Gdx.input.setInputProcessor((InputProcessor) player);
        createNewItems(medKit, "assets/maps/medkit.png");
    }

    /*private <T> void createNewItems(Item<T> object, String picture){
        int numberOfEnemies = 50;
        Random rand = new Random();
        for (int n = 0; n < numberOfEnemies; n++) {
            int xPos = rand.nextInt(317);
            object = new Item<T>(new Sprite(new Texture(picture)), (TiledMapTileLayer) map.getLayers().get(0));
            object.setPosition(xPos * object.getCollisionLayer().getTileWidth(), (object.getCollisionLayer().getHeight() - 4) * object.getCollisionLayer().getTileHeight());
            items.add(object);
        }

    }*/
    private <T> void createNewItems(medKit object, String picture){
        int numberOfItems = 20;
        Random rand = new Random();
        for (int n = 0; n < numberOfItems; n++) {
            int xPos = rand.nextInt(317);
            object = new medKit(new Sprite(new Texture(picture)), (TiledMapTileLayer) map.getLayers().get(0));
            object.setPosition(xPos * object.getCollisionLayer().getTileWidth(), (object.getCollisionLayer().getHeight() - 4) * object.getCollisionLayer().getTileHeight());
            items.add(object);
        }

    }

    public Player getPlayer(){ 
        return player;
    }

    public List<Enemy> getEnemies(){
        return enemies;
    }

    public List<Item> getItems(){
        return items;
    }


    @Override
    public void render(float v) {
        //nextMap();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setView(camera);
        renderer.render();

        camera.position.set(player.getX(), player.getY(), 0);
        camera.update();
        player.update();
        
        renderer.getBatch().begin();
        player.draw(renderer.getBatch());
        player.draw(renderer.getBatch());

        //medKit.draw(renderer.getBatch());
        drawItems();

        List<Enemy> enemiesToBeRemoved = new ArrayList<>();
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                enemy.draw(renderer.getBatch());
            }
            else {
                enemiesToBeRemoved.add(enemy);
            }
        }
        removeDeadEnemies(enemiesToBeRemoved);


        font.draw(renderer.getBatch(), "Current Health: " + player.getHealth(), player.getX(), player.getY() - 30);
        font.draw(renderer.getBatch(), player.getMessage(), player.getX() + 200, player.getY() - 30);
        font.draw(renderer.getBatch(), "FINISH ZONE!", 487 * player.getCollisionLayer().getTileWidth(), (player.getCollisionLayer().getHeight() - 18) * player.getCollisionLayer().getTileHeight());


        /*System.out.println("PLayer y: " + player.getY());
        System.out.println("enemy y: " + enemy.getY());*/


        renderer.getBatch().end();

    }

    private void drawItems(){
        List<Item> usedItems = new ArrayList<>();
        for (Item object : items) {
            if (object.isAlive()) {
                object.draw(renderer.getBatch());
            }
            else {
                usedItems.add(object);
            }
        }
        removeUsedItems(usedItems);
    }

    /**
     * removes the dead enemies
     * @param enemiesToBeRemoved
     */
    private void removeDeadEnemies(List<Enemy> enemiesToBeRemoved){
        enemies.removeAll(enemiesToBeRemoved);
    }

    /**
     * removes the dead enemies
     * @param usedItems
     */
    private void removeUsedItems(List<Item> usedItems){
        enemies.removeAll(usedItems);
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

    /*public void nextMap(){
        if (player.playerWon()){
            app.changeMap();
            //new Play(currentMap, app);
            //this.stop();
            //dispose();
            //gameCount++;
            //this.app.create();
            //return true;

        }
        //System.out.println(gameCount);
        //return false;
    }*/
}









