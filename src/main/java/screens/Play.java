package screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.scenes.scene2d.Event;

import inf112.skeleton.app.abstractEnemy;
import inf112.skeleton.app.ScoreDB;
import inf112.skeleton.app.app;
import inf112.skeleton.app.controller;
import objects.*;
import org.lwjgl.opengl.GL20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Play extends Event implements Screen {

    // CONSTANTS
    private final int STARTPOSITION = 36;
    private static final com.badlogic.gdx.graphics.Color GAME_SCREEN_OVERLAY_COLOR = new com.badlogic.gdx.graphics.Color(0, 0, 0, 128);
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final String GAME_OVER_MSG = "Game Over";
    private static final String GAME_FINISHED_MSG = "You Won";
    private static final String GAME_PAUSED_MSG = "GAME PAUSED";
    private static final String GAME_RESUME_MSG = "Press enter to resume game";

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private BitmapFont font;

    private mainPlayer player1;
    private mainPlayer player2;
    private Vampire vampire;
    private Wizard wizard;
    private medKit medKit;
    // Lists for actors
    private List<mainPlayer> players = new ArrayList<>();
    private List<abstractEnemy> enemies = new ArrayList<>();
    private List<abstractEnemy> bats = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    private int gameCount = 0;
    private String currentMap;
    private app app;
    private ItemFactory itemFactory;

    private boolean pauseActive; 
    
    private BitmapFont font2;
    private BitmapFont font3;
    
    private HashMap<abstractEnemy, Float> enemyVelocity = new HashMap<>();

    private ShapeRenderer shapeRenderer;
    private boolean gameActive;
    private boolean DBSaved = false;
    private List<Integer> topTen = new ArrayList<>();



    private final int gameMode;

    public Play(String currentMap, app app, int gameMode){
        this.currentMap = currentMap;
        this.app = app;
        this.itemFactory = new ItemFactory();
        this.gameMode = gameMode;
        this.gameActive = true;
    }

    @Override
    public void show() {
    	//batch = new SpriteBatch();
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load(currentMap);

        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();
        font = new BitmapFont();

        player1 = new mainPlayer(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0), this);//new Player(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0));
        player1.setPosition(10 * player1.getCollisionLayer().getTileWidth(), (player1.getCollisionLayer().getHeight() - STARTPOSITION) * player1.getCollisionLayer().getTileHeight());
        players.add(player1);

        if (gameMode == 1) {
            controller controller1 = new controller(player1);
            Gdx.input.setInputProcessor(controller1);
        }

        else if (gameMode == 2) {
            player2 = new mainPlayer(new Sprite(new Texture("assets/maps/luigi.png")), (TiledMapTileLayer) map.getLayers().get(0), this);//new Player(new Sprite(new Texture("assets/maps/mario.png")), (TiledMapTileLayer) map.getLayers().get(0));
            player2.setPosition(7 * player2.getCollisionLayer().getTileWidth(), (player2.getCollisionLayer().getHeight() - STARTPOSITION) * player2.getCollisionLayer().getTileHeight());
            player2.setSize((float) (player2.getWidth()*0.15), (float) (player2.getHeight()*0.2));;
            players.add(player2);

            controller controller = new controller(player1, player2);
            Gdx.input.setInputProcessor(controller);
        }

        createObjects();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);

    }

    /**
     * creates the new instances of the different objects
     * adds the respective instances to their lists
     */
    private void createObjects(){
        enemies = itemFactory.getNextBomb(20, map, this);
        enemies = itemFactory.getNextMonster(30, map, this);
        enemies = itemFactory.getNextBat(map, this, bats);
        vampire = itemFactory.getVampire(map, this, enemies);
        enemies = itemFactory.getNextWizard(map, this);

        items = itemFactory.getNextMedkit(30, map, this);
        items = itemFactory.getKey(map, this);
    }

    public Vampire getVampire(){
        return vampire;
    }

    public List<abstractEnemy> getBats(){
        return bats;
    }

    public ItemFactory getItemFactory(){
        return itemFactory;
    }

    public TiledMap getMap(){
        return map;
    }

    public List<mainPlayer> getPlayers(){
        return players;
    }

    public List<abstractEnemy> getEnemies(){
        return enemies;
    }

    public List<Item> getItems(){
        return items;
    }


    @Override
    public void render(float v) {
        if (gameActive == true) {

            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            renderer.setView(camera);
            renderer.render();
            camera.update();
            renderer.getBatch().begin();

            if (!player1.isAlive() && player2 != null)
                camera.position.set(player2.getX(), player2.getY(), 0);
            else
                camera.position.set(player1.getX(), player1.getY(), 0);

            if (player1.isAlive()) {
                player1.update();
                player1.draw(renderer.getBatch());
                player1.draw(renderer.getBatch());
            }

            if (player2 != null && player2.isAlive()) {
                player2.update();
                player2.draw(renderer.getBatch());
                player2.draw(renderer.getBatch());
            }

            drawItems();

            List<abstractEnemy> enemiesToBeRemoved = new ArrayList<>();
            for (abstractEnemy enemy : enemies) {
                if (enemy.isAlive()) {
                    enemy.draw(renderer.getBatch());
                } else {
                    enemiesToBeRemoved.add(enemy);
                }
            }
            removeDeadEnemies(enemiesToBeRemoved);


            font.draw(renderer.getBatch(), "Mario's Health: " + player1.getHealth(), player1.getX(), player1.getY() - 30);
            font.draw(renderer.getBatch(), player1.getMessage(), player1.getX() + 200, player1.getY() - 30);
            font.draw(renderer.getBatch(), "FINISH ZONE!", 633 * player1.getCollisionLayer().getTileWidth(), (player1.getCollisionLayer().getHeight() - 45) * player1.getCollisionLayer().getTileHeight());
            font.draw(renderer.getBatch(), "LEVEL 2!", 440 * player1.getCollisionLayer().getTileWidth(), (player1.getCollisionLayer().getHeight() - 9) * player1.getCollisionLayer().getTileHeight());

            if (player2 != null) {
                font.draw(renderer.getBatch(), "Luigi's Health: " + player2.getHealth(), player2.getX(), player2.getY() - 50);
                font.draw(renderer.getBatch(), player2.getMessage(), player2.getX() + 200, player1.getY() - 50);
            }
            
            printPausedMsg();
            
            
            gameOver();
            

            
            pause();
            
            renderer.getBatch().end();
        }
    }
    
    public void printPausedMsg() {
    	font2 = new BitmapFont();
    	font2.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    	font2.getData().setScale(5, 5);
    	font2.setColor(com.badlogic.gdx.graphics.Color.RED);
    	
    	font3 = new BitmapFont();
    	font3.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    	font3.getData().setScale(2, 2);
    	font3.setColor(com.badlogic.gdx.graphics.Color.WHITE);
    	
    
    	if(pauseActive) {
    		font2.draw(renderer.getBatch(), GAME_PAUSED_MSG, player1.getX()-250, Gdx.graphics.getHeight()/2);
    		font3.draw(renderer.getBatch(), GAME_RESUME_MSG, player1.getX()-160, (Gdx.graphics.getHeight()/2)-100);
    	}
    }

    /**
     * checks if all players are dead
     */
    public void gameOver(){
        int deadCount = 0;
        for (mainPlayer player : players){
            if (!player.isAlive()){
                deadCount++;
            }
        }

        if (deadCount == players.size()){
            runDB();
            paintOverlayMessage(GAME_OVER_MSG);
        }
        if (player1.getPlayerWon()){
            runDB();
            paintOverlayMessage(GAME_FINISHED_MSG);
        }
        if (player2 != null && player2.getPlayerWon()){
            runDB();
            paintOverlayMessage(GAME_FINISHED_MSG);
        }
    }
    
    

    public void runDB(){
        if (!DBSaved){
            ScoreDB scoreDB = new ScoreDB(players);
            topTen = scoreDB.getTopTen();
            DBSaved = true;
        }
    }

    public void scoreBoard(){
        float x = Gdx.graphics.getWidth()/2;
        float y = Gdx.graphics.getHeight()/2;
        font.draw(renderer.getBatch(), "Global Scoreboard", x-90, y);

        int count = 0;
        for (int score : topTen){
            count++;
            y -= 30;
            font.draw(renderer.getBatch(), count + ". " + score + " kills", x-30, y);
        }
    }

    /**
     * displays an overlay message with a background color
     * @param msg
     */
    public void paintOverlayMessage(String msg){
        renderer.getBatch().end();
        float x = Gdx.graphics.getWidth()/2;
        float y = Gdx.graphics.getHeight()/2;

        Color color = msg == GAME_OVER_MSG ? Color.RED : Color.GREEN;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer.end();

        renderer.getBatch().begin();
        camera.position.set(x, y, 0);
        scoreBoard();

        font.setColor(com.badlogic.gdx.graphics.Color.BLACK);
        font.draw(renderer.getBatch(), msg, x-50, y+100);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.getData().setScale(2);
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
    private void removeDeadEnemies(List<abstractEnemy> enemiesToBeRemoved){
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
    	

    	
        if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
        	
        	
        	if(!pauseActive) {
        		for(abstractEnemy enemy : enemies){
        			enemyVelocity.put(enemy, enemy.getVelocity().x);
        			enemy.setGravity(0);
        			enemy.setSpeed(0);
        			enemy.getVelocity().x = 0;

        			
        		}
        		for(mainPlayer player : players) {
        			player.setGravity(0);
        			player.setSpeed(0);
        		
        		}
        	
        		pauseActive = true;
        		
        		
        		
        	}
        	else {
        		
        		for(Map.Entry<abstractEnemy, Float> entry: enemyVelocity.entrySet()) {
        			entry.getKey().setGravity(140 * 1f);
        			entry.getKey().setSpeed(150);
        			entry.getKey().getVelocity().x = entry.getValue();
        		}

        			
        		for(mainPlayer player : players) {
        			player.setGravity(140 * 1f);
        			player.setSpeed(150);          	
        		}

        		pauseActive = false;
        	}
        }
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
        player1.getTexture().dispose();
        //player2.getTexture().dispose();
        //player.jump.dispose();
    }


}









