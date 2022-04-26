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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import inf112.skeleton.app.app;
import screens.Play;

public class MenuScreen extends Game implements Screen {
	
	app game;
    private SpriteBatch batch;
	private Texture background;
	private Texture playButton_active;
	private Texture playButton_inactive;
	private Texture exitButton_active;
	private Texture exitButton_inactive;
	private Texture twoPlayer_symbol;
	private Music menu_music;
	private final int onePlayer = 1;
	private final int twoPlayer = 2;
	
	public int screenWidth = Gdx.graphics.getWidth();
	public int screenHeight = Gdx.graphics.getHeight();
	
	private int playButton_height = 120;
	private int playButton_width = 220;
	private int pb_x_pos_min = screenWidth/2 - playButton_width/2;
	private int pb_x_pos_max = screenWidth/2 + playButton_width/2;
	private int pb_y_pos_min = screenHeight/2 - playButton_height/2;
	private int pb_y_pos_max = screenHeight/2 + playButton_height/2;
	
	private int exitButton_height = 100;
	private int exitButton_width = 100;
	private int eb_x_pos_min = screenWidth/2 - (playButton_width/2)/2;
	private int eb_x_pos_max = screenWidth/2 + (playButton_width/2)/2;
	private int eb_y_pos_max = pb_y_pos_min - 20;
	private int eb_y_pos_min = eb_y_pos_max - exitButton_height;
	
	private int twoPButton_height = 100;
	private int twoPButton_width = 100;
	private int twoPB_x_pos_min = screenWidth/2 - (playButton_width/2)/2;
	private int twoPB_x_pos_max = screenWidth/2 + (playButton_width/2)/2;
	private int twoPB_y_pos_min = pb_y_pos_max + 40;
	private int twoPB_y_pos_max = twoPB_y_pos_min + twoPButton_height;

	
	
	public MenuScreen(app game) {
		
		
		this.game = game;
		background = new Texture("assets/maps/game_background.png");
		playButton_active = new Texture("assets/maps/play_button_active.png");
		playButton_inactive = new Texture("assets/maps/play_button_inactive.png");
		exitButton_active = new Texture("assets/maps/exit_button_active.png");
		exitButton_inactive = new Texture("assets/maps/exit_button_inactive.png");
		twoPlayer_symbol = new Texture("assets/maps/twoplayer.png");
		
		
		menu_music = Gdx.audio.newMusic(Gdx.files.internal("assets/sounds/menuscreen_audio.mp3"));
		menu_music.setLooping(true);
		menu_music.setVolume(0.3f);
		menu_music.play();
		batch = new SpriteBatch();
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
    	
    	  	 	
    	if(Gdx.input.getX() < pb_x_pos_max && Gdx.input.getX() > pb_x_pos_min && Gdx.input.getY() < pb_y_pos_max && Gdx.input.getY() > pb_y_pos_min) {
    		batch.draw(playButton_active, pb_x_pos_min, pb_y_pos_min, playButton_width, playButton_height);
        	if(Gdx.input.isTouched()) {
				this.dispose();
        		game.setScreen(new Play("assets/maps/map1.tmx", game, onePlayer));
        	}
    	}
    	else {
    		batch.draw(playButton_inactive, pb_x_pos_min , pb_y_pos_min, playButton_width, playButton_height);
    	}
    	
    	if(Gdx.input.getX() < eb_x_pos_max && Gdx.input.getX() > eb_x_pos_min && Gdx.input.getY() < 620 && Gdx.input.getY() > 540) {
    		batch.draw(exitButton_active, eb_x_pos_min, eb_y_pos_min, exitButton_width, exitButton_height);
        	if(Gdx.input.isTouched()) {
        		
        		Gdx.app.exit();
        		
        	}  	
    		
    	}
    	else {
    		batch.draw(exitButton_inactive, eb_x_pos_min, eb_y_pos_min, exitButton_width, exitButton_height);
    	}
    	
    	
    	
    	
    	if(Gdx.input.getX() < twoPB_x_pos_max && Gdx.input.getX() > twoPB_x_pos_min && Gdx.input.getY() > 230 && Gdx.input.getY() < 360) {
    		batch.draw(playButton_active, twoPB_x_pos_min, twoPB_y_pos_min, twoPButton_width, twoPButton_height);
        	if(Gdx.input.isTouched()) {
				this.dispose();
				game.setScreen(new Play("assets/maps/map1.tmx", game, twoPlayer));
        		
        	}
    	}
    	else {
    		batch.draw(twoPlayer_symbol, twoPB_x_pos_min, twoPB_y_pos_min, twoPButton_width, twoPButton_height);
    	}
    	

    	batch.end();

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
		playButton_active.dispose();
		playButton_inactive.dispose();
		exitButton_active.dispose();
		exitButton_inactive.dispose();
		twoPlayer_symbol.dispose();
		menu_music.dispose();

	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
}
