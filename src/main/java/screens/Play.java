package screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
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

import java.util.*;

public class Play extends Event implements Screen {

    // CONSTANTS
    private final int STARTPOSITION = 36;
    private static final String GAME_OVER_MSG = "Game Over!";
    private static final String GAME_FINISHED_MSG = "You Won!";
    private static final String GAME_PAUSED_MSG = "GAME PAUSED";
    private static final String GAME_RESUME_MSG = "Press enter to resume game";
    private static final String BACK_TO_MENU = "<-- main menu";

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private BitmapFont font;

    private mainPlayer player1;
    private mainPlayer player2;
    private Vampire vampire;

    // Lists for actors
    private List<mainPlayer> players = new ArrayList<>();
    private List<abstractEnemy> enemies = new ArrayList<>();
    private List<abstractEnemy> bats = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    private final String currentMap;
    private app app;
    private ItemFactory itemFactory;
    
    private Music game_music;
    private Sound gameover;
    private Sound victory;

    private boolean pauseActive;
        
    private BitmapFont font2;
    private BitmapFont font3;
    private BitmapFont font4;
    private BitmapFont font5;
   
    
    private HashMap<abstractEnemy, Float> enemyVelocity = new HashMap<>();

    private ShapeRenderer shapeRenderer;
    private boolean gameActive;
    private boolean DBSaved = false;
    private List<Integer> topTen = new ArrayList<>();
    private boolean cameraViewSwiched;

    private final long timerStart;
    private final int gameMode;

    public Play(String currentMap, app app, int gameMode){
        this.currentMap = currentMap;
        this.app = app;
        this.itemFactory = new ItemFactory();
        this.gameMode = gameMode;
        this.gameActive = true;
        this.cameraViewSwiched = false;
        this.timerStart = System.currentTimeMillis();
        this.font5 = new BitmapFont();
        this.font4 = new BitmapFont();
        gameover = Gdx.audio.newSound(Gdx.files.internal("assets/sounds/gameover.mp3"));
        
        
		game_music = Gdx.audio.newMusic(Gdx.files.internal("assets/sounds/gamemusic.wav"));
		game_music.setLooping(true);
		game_music.setVolume(0.2f);
		game_music.play();
       
    }

    @Override
    public void show() {
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load(currentMap);

        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();
        font = new BitmapFont();

        // Creates the player(s) and sets the controllers
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
            player2.setSize((float) (player2.getWidth()*0.15), (float) (player2.getHeight()*0.2));
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

    @Override
    public void render(float v) {
        if (gameActive == true) {

            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            renderer.setView(camera);
            renderer.render();
            camera.update();
            renderer.getBatch().begin();

            drawPlayers();
            drawItems();
            drawEnemies();
            drawFont();
            
            printPausedMsg();
            gameOver();
           
            pause();
            setCameraViewSwiched();
            
            renderer.getBatch().end();
        }
    }

    /**
     * draws player1 and player2 if there are two players
     * determines which player to focus the camera on
     */
    private void drawPlayers(){
        if (gameMode == 1){
            camera.position.set(player1.getX(), player1.getY(), 0);
        }
        else if (!player1.isAlive() || cameraViewSwiched) {
            if (player2 != null) {
                camera.position.set(player2.getX(), player2.getY(), 0);
            }
        }
        else {
            camera.position.set(player1.getX(), player1.getY(), 0);
        }


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
    }

    /**
     * draws the font to be displayed on the screen
     */
    private void drawFont() {
        font.draw(renderer.getBatch(), "Mario's Health: " + player1.getHealth(), player1.getX(), player1.getY() - 30);
        font.draw(renderer.getBatch(), player1.getMessage(), player1.getX() + 200, player1.getY() - 30);
        font.draw(renderer.getBatch(), "FINISH ZONE!", 633 * player1.getCollisionLayer().getTileWidth(), (player1.getCollisionLayer().getHeight() - 45) * player1.getCollisionLayer().getTileHeight());
        font.draw(renderer.getBatch(), "LEVEL 2!", 440 * player1.getCollisionLayer().getTileWidth(), (player1.getCollisionLayer().getHeight() - 9) * player1.getCollisionLayer().getTileHeight());


        if (player1.isAlive() && !cameraViewSwiched)
            font5.draw(renderer.getBatch(), getTime() , player1.getX() - 500, player1.getY() + 400);
        else if (player2 != null || cameraViewSwiched)
            font5.draw(renderer.getBatch(), getTime() , player2.getX() - 500, player2.getY() + 400);


        if (player2 != null) {
            font.draw(renderer.getBatch(), "Luigi's Health: " + player2.getHealth(), player2.getX(), player2.getY() - 50);
            font.draw(renderer.getBatch(), player2.getMessage(), player2.getX() + 200, player2.getY() - 50);
        }
    }


    public void printPausedMsg() {
    	font4.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    	font4.getData().setScale(5, 5);
    	font4.setColor(com.badlogic.gdx.graphics.Color.RED);
    	
    	font5.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    	font5.getData().setScale(2, 2);
    	font5.setColor(com.badlogic.gdx.graphics.Color.WHITE);
    	
    
    	if(pauseActive && player1.isAlive()) {
    		font4.draw(renderer.getBatch(), GAME_PAUSED_MSG, player1.getX()-250, Gdx.graphics.getHeight()/2);
    		font5.draw(renderer.getBatch(), GAME_RESUME_MSG, player1.getX()-160, (Gdx.graphics.getHeight()/2)-80);
    	}
        else if (pauseActive && player2 != null){
            font4.draw(renderer.getBatch(), GAME_PAUSED_MSG, player2.getX()-250, Gdx.graphics.getHeight()/2);
            font5.draw(renderer.getBatch(), GAME_RESUME_MSG, player2.getX()-160, (Gdx.graphics.getHeight()/2)-80);
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


    /**
     * updates the file containing the scores
     */
    public void runDB(){
        if (!DBSaved){
            ScoreDB scoreDB = new ScoreDB(players);
            topTen = scoreDB.getTopTen();
            DBSaved = true;
        }
    }

    /**
     * draws the all-time top ten best scores on the gameOver/finished screen
     */
    public void scoreBoard(){
        float x = Gdx.graphics.getWidth()/2;
        float y = Gdx.graphics.getHeight()/2;
        
        font5.draw(renderer.getBatch(), "Global Scoreboard", x-120, y+150);

        int count = 0;
        for (int score : topTen){
            count++;
            y -= 30;
            font.draw(renderer.getBatch(), count + ". " + score + " kills", x-30, y+100);
        }
    }

    /**
     * displays an overlay message with a background color
     * @param msg
     */
    public void paintOverlayMessage(String msg){
    	
    	game_music.stop();
    	
        float x = Gdx.graphics.getWidth()/2;
        float y = Gdx.graphics.getHeight()/2;
          

        renderer.getBatch().draw(new Texture("assets/maps/about_background.png"), 0, 30, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        camera.position.set(x, y, 0);
        scoreBoard();

        font2 = new BitmapFont();
        font2.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font2.setColor(com.badlogic.gdx.graphics.Color.RED);
        font2.getData().setScale(4, 4);    
        font2.draw(renderer.getBatch(), msg, x - 150, y+300);
        
        font3 = new BitmapFont();
        font3.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font3.setColor(com.badlogic.gdx.graphics.Color.YELLOW);
        font3.getData().setScale(2, 2);    

        
        font5.draw(renderer.getBatch(), BACK_TO_MENU, 40, 120);
        

        if(Gdx.input.getX() < 230 && Gdx.input.getX() > 40 && Gdx.input.getY() > 780 && Gdx.input.getY() < 810) {
            
        	font3.draw(renderer.getBatch(), BACK_TO_MENU, 40, 120);      
        	
        	if(Gdx.input.isTouched()) {
        		app.create();
        }
      }
        
        
    }

    private String getTime(){
        long nowTime = System.currentTimeMillis();
        return (int)((nowTime - this.timerStart) / 1000) + " Seconds";
    }

    /**
     * draws the enemies
     */
    private void drawEnemies() {
        List<abstractEnemy> enemiesToBeRemoved = new ArrayList<>();
        for (abstractEnemy enemy : enemies) {
            if (enemy.isAlive()) {
                enemy.draw(renderer.getBatch());
            } else {
                enemiesToBeRemoved.add(enemy);
            }
        }
        removeDeadEnemies(enemiesToBeRemoved);
    }

    /**
     * draws the items to be on the board
     */
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
        		game_music.pause();
        		
        		for(abstractEnemy enemy : enemies){
        			enemyVelocity.put(enemy, enemy.getVelocity().x);
        			enemy.setGravity(0);
        			enemy.setSpeed(0);
        			enemy.getVelocity().x = 0;
        		}
        		for(mainPlayer player : players) {
        			player.setGravity(0);
        			player.setSpeed(0);
                    player.getVelocity().x = 0;
        		}
        		pauseActive = true;
        	}
        	else {
        		
        		game_music.play();
        		
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

    /**
     * Switches camera focus to the other player
     */
    public void setCameraViewSwiched(){
        if(Gdx.input.isKeyJustPressed(Keys.C)) {
            if (gameMode == 2) {
                if (!cameraViewSwiched) {
                    cameraViewSwiched = true;
                } else {
                    cameraViewSwiched = false;
                }
            }
        }
    }

    public Vampire getVampire(){
        return vampire;
    }

    public List<abstractEnemy> getBats(){
        return bats;
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
        game_music.dispose();
        gameover.dispose();
    }


}









