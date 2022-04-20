package screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import com.badlogic.gdx.scenes.scene2d.Event;
import inf112.skeleton.app.Player;

import inf112.skeleton.app.app;
import objects.*;
import org.lwjgl.opengl.GL20;

import java.util.ArrayList;
import java.util.List;

public class Play extends Event implements Screen {

    // CONSTANTS
    private final int STARTPOSITION = 38;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    //private SpriteBatch batch;
    private mainPlayer player;
    private mainPlayer player2;
    private List<mainPlayer> players = new ArrayList<>();
    private Vampire vampire;
    private medKit medKit;
    //private Enemy enemy;
    private BitmapFont font;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Enemy> bats = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private int gameCount = 0;
    private String currentMap;
    private app app;
    private ItemFactory itemFactory;

    public Play(String currentMap, app app){
        this.currentMap = currentMap;
        this.app = app;
        this.itemFactory = new ItemFactory();
    }

    @Override
    public void show() {
    	//batch = new SpriteBatch();
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load(currentMap);//loader.load("assets/maps/map1.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();
        font = new BitmapFont();

        player = new mainPlayer(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0), this, players);//new Player(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0));
        player.setPosition(10 /*293*/ * player.getCollisionLayer().getTileWidth(), (player.getCollisionLayer().getHeight() - STARTPOSITION /*42*/) * player.getCollisionLayer().getTileHeight());
        players.add(player);

        /*
        player2 = new mainPlayer(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0), this, players);//new Player(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0));
        player2.setPosition(7 * player2.getCollisionLayer().getTileWidth(), (player2.getCollisionLayer().getHeight() - STARTPOSITION) * player2.getCollisionLayer().getTileHeight());
        players.add(player2);
         */

        Bat bat = new Bat(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0), this);
        bat.setPosition(325 * bat.getCollisionLayer().getTileWidth(), (bat.getCollisionLayer().getHeight() - 42) * bat.getCollisionLayer().getTileHeight());

        enemies = itemFactory.getNextBomb(20, map, this);
        enemies = itemFactory.getNextMonster(30, map, this);
        enemies = itemFactory.getNextBat(map, this, bats);
        vampire = itemFactory.getVampire(map, this, enemies);

        items = itemFactory.getNextMedkit(30, map, this);
        items = itemFactory.getKey(map, this);

        /*InputMultiplexer twoPlayer = new InputMultiplexer();
        twoPlayer.addProcessor(player);
        twoPlayer.addProcessor(player2);*/

        //Gdx.input.setInputProcessor(twoPlayer);
        Gdx.input.setInputProcessor((InputProcessor) player);
    }

    public Vampire getVampire(){
        return vampire;
    }

    public List<Enemy> getBats(){
        return bats;
    }

    public ItemFactory getItemFactory(){
        return itemFactory;
    }

    public TiledMap getMap(){
        return map;
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

        if (player.isAlive()) {
            player.draw(renderer.getBatch());
            player.draw(renderer.getBatch());
        }

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

}









