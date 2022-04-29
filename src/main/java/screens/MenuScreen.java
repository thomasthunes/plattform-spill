package screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import inf112.skeleton.app.App;
import screens.Play;

public class MenuScreen extends Game implements Screen {
	
	App game;
    private SpriteBatch batch;
	private Texture background;
	private Music menu_music;
	private final int onePlayer = 1;
	private final int twoPlayer = 2;
	
	public int screenWidth = Gdx.graphics.getWidth();
	public int screenHeight = Gdx.graphics.getHeight();
	
	private int pb_x_pos_min = 570;
	private int pb_x_pos_max = 900;
	private int pb_y_pos_min = 490;

	private int eb_x_pos_min = 665;
	private int eb_x_pos_max = 780;
	private int eb_y_pos_min = 380;

	private int twoPB_x_pos_min = 595;
	private int twoPB_x_pos_max = 870;
	private int twoPB_y_pos_min = 600;
	

	
	private final String ABOUT_CNTRL_TXT = 
			  "\n"
			+ "A: Move left\n"
			+ "D: Move right\n"				  
			+ "F: Pick up items\n"
			+ "SPACE: Jump\n"
			+ "ENTER: Pause game\n\n"
			+ "\n"
			+ "RIGHT ARROW: Move right\n"
			+ "LEFT ARROW: Move left\n"
			+ "PAGE UP: Jump\n"
			+ "P: Pick up item\n"
			+ "ENTER: Pause game\n"
			+ "C: Switch camera between player 1 and player 2";
	
	private final String ABOUT_HOWTO_TXT = 
			"\n"
		  + "Help Mario/Luigi out of their terrible fever\n"
		  + "dream. Avoid getting stuck in the dream for \n"
		  + "ever by not getting killed by the wizard,\n"
		  + "monsters or the evil ogers. Pick up the key which\n"
		  + "is heavily guarded by the intimidating vampire,\n"
		  + "to get to the next level and to reach the finish-\n"
		  + "pad. If you kill enough sleazy enemies you\n"
		  + "might enter the top ten scoreboard.\n"
		  + "P.S. avoid the red burning lava!";
	

	private final String ABOUT_BACK_BTN = "<-- BACK";	
	private final String ABOUT_BTN = "ABOUT";
	private final String ABOUT_CONTRL = "-CONTROLS-";
	private final String ABOUT_ONEPLAYER = "One player:";
	private final String ABOUT_TWOPLAYER = "Two player (player 2):";
	private final String ABOUT_HOW_TO = "-HOW TO PLAY-";
	private final String MENU_PLAY_GAME = "PLAY GAME";
	private final String MENU_EXIT = "EXIT";
	private final String MENU_TWO_PLAYER = "2 PLAYER";
	private final String MENU_HEADLINE = "-SUPER JAVA BROS-";
	
	private BitmapFont font;
	private BitmapFont font2;
	private BitmapFont font3;
	private BitmapFont font4;
	private BitmapFont font5;
	
	private ShapeRenderer shapeRenderer;
	private boolean aboutScreenActive;
	
	public MenuScreen(App game) {

		
		this.game = game;
		background = new Texture("assets/maps/game_background.png");
		
		
		menu_music = Gdx.audio.newMusic(Gdx.files.internal("assets/sounds/menuscreen_audio.mp3"));
		menu_music.setLooping(true);
		menu_music.setVolume(0.4f);
		menu_music.play();
		batch = new SpriteBatch();
		
		font = new BitmapFont();
		font2 = new BitmapFont();
		font3 = new BitmapFont();
		font4 = new BitmapFont();
		font5 = new BitmapFont();
		shapeRenderer = new ShapeRenderer();
		
	}	

	@Override
	public void show() {
		
	}
		

	@Override
	public void render(float delta) {
        
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
    	batch.begin();
    	batch.draw(background, 0, 0, screenWidth, screenHeight);
    	
    	if(aboutScreenActive) {
    		aboutScreen();
    	}
    	
    	
    	if(!aboutScreenActive) {
    	
    	//Creating the menuscreen
    	
    	aboutButton();
    	
    	font4.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font4.getData().setScale(5, 5);
        font4.setColor(com.badlogic.gdx.graphics.Color.RED);
        font4.draw(batch, MENU_HEADLINE, 380, 750);
    	
		font5 = new BitmapFont();
		font5.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font5.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        font5.getData().setScale(4, 4);    
        
        font5.draw(batch, MENU_PLAY_GAME, pb_x_pos_min, pb_y_pos_min);
        font5.draw(batch, MENU_EXIT, eb_x_pos_min, eb_y_pos_min);
        font5.draw(batch, MENU_TWO_PLAYER, twoPB_x_pos_min, twoPB_y_pos_min);
    	
    	   	  	 	
    	if(Gdx.input.getX() < pb_x_pos_max && Gdx.input.getX() > pb_x_pos_min && Gdx.input.getY() < 460 && Gdx.input.getY() > 400) {
            
    		font5.setColor(com.badlogic.gdx.graphics.Color.YELLOW);
            font5.draw(batch, MENU_PLAY_GAME, pb_x_pos_min, pb_y_pos_min);
        	
            if(Gdx.input.isTouched()) {
				this.dispose();
        		game.setScreen(new Play("assets/maps/map1.tmx", game, onePlayer));
        	}
    	}

    	
    	if(Gdx.input.getX() < eb_x_pos_max && Gdx.input.getX() > eb_x_pos_min && Gdx.input.getY() < 570 && Gdx.input.getY() > 520) {

    		font5.setColor(com.badlogic.gdx.graphics.Color.YELLOW);
            font5.draw(batch, MENU_EXIT, eb_x_pos_min, eb_y_pos_min);
        	
            if(Gdx.input.isTouched()) {
        		
        		Gdx.app.exit();
        		
        	}  	
    		
    	}
 	
    	
    	if(Gdx.input.getX() < twoPB_x_pos_max && Gdx.input.getX() > twoPB_x_pos_min && Gdx.input.getY() > 300 && Gdx.input.getY() < 350) {
            
    		font5.setColor(com.badlogic.gdx.graphics.Color.YELLOW);
            font5.draw(batch, MENU_TWO_PLAYER, twoPB_x_pos_min, twoPB_y_pos_min);
        	
            if(Gdx.input.isTouched()) {
				this.dispose();
				game.setScreen(new Play("assets/maps/map1.tmx", game, twoPlayer));
        		
        	}
    	}
    	
    }
    	
    	batch.end();

	}
	
	
    	
	
	
	public void aboutButton() {
		
        font2.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font2.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        font2.getData().setScale(3, 3);    
        font2.draw(batch, ABOUT_BTN, 1200, 820);
        
        if(Gdx.input.getX() < 1350 && Gdx.input.getX() > 1200 && Gdx.input.getY() > 70 && Gdx.input.getY() < 120) {
        	font2.setColor(com.badlogic.gdx.graphics.Color.YELLOW);
        	font2.draw(batch, ABOUT_BTN, 1200, 820);
        	if(Gdx.input.isTouched()) {
        		aboutScreenActive = true;
				     		
        	}
        }
	
	}
	
	public void aboutScreen() {
		
        batch.draw(new Texture("assets/maps/about_background.png"), 0, 30, screenWidth, screenHeight);
        
        font4.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font4.setColor(com.badlogic.gdx.graphics.Color.RED);
        font4.getData().setScale(4, 4);    
        font4.draw(batch, ABOUT_BTN, Gdx.graphics.getWidth()/2 -100, 850);
        
		
        font3.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font3.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        font3.getData().setScale(2, 2);    
        font3.draw(batch, ABOUT_CNTRL_TXT, 100, 700);
        font3.draw(batch, ABOUT_HOWTO_TXT, 810, 700);
        
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        font.getData().setScale(2, 2);    
        font.draw(batch, ABOUT_BACK_BTN, 40, 120);
        font.setColor(com.badlogic.gdx.graphics.Color.BLACK);
        font.draw(batch, ABOUT_CONTRL, 250, 750);
        font.draw(batch, ABOUT_HOW_TO, 970, 750);
        
        font4.getData().setScale(2, 2);
        font4.setColor(com.badlogic.gdx.graphics.Color.YELLOW);
        font4.draw(batch, ABOUT_ONEPLAYER, 100, 700);
        font4.draw(batch, ABOUT_TWOPLAYER, 100, 450);
        
        
		if(Gdx.input.getX() < 180 && Gdx.input.getX() > 40 && Gdx.input.getY() > 780 && Gdx.input.getY() < 810) {
		            
			font.setColor(com.badlogic.gdx.graphics.Color.YELLOW);
		    font.draw(batch, ABOUT_BACK_BTN, 40, 120);      
		        	
		        	
		        if(Gdx.input.isTouched()) {
		        		aboutScreenActive = false;
		        }
		     }
       
		
	}
    

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		background.dispose();
		menu_music.dispose();

	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
	}
}
