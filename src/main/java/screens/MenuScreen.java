package screens;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import inf112.skeleton.app.app;
import screens.Play;

public class MenuScreen extends Game implements Screen  {
	
	app game;
    private SpriteBatch batch;
	private Texture background;
	private Texture playButton_active;
	private Texture playButton_inactive;
	private Texture exitButton_active;
	private Texture exitButton_inactive;
	
	public List<String> maps = new ArrayList<>();
	
	public MenuScreen(app game) {
		
		maps.add("assets/maps/map1.tmx");
		this.game = game;
		background = new Texture("assets/maps/background.png");
		playButton_active = new Texture("assets/maps/play_button_active.png");
		playButton_inactive = new Texture("assets/maps/play_button_inactive.png");
		exitButton_active = new Texture("assets/maps/exit_button_active.png");
		exitButton_inactive = new Texture("assets/maps/exit_button_inactive.png");
		
		
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
    	batch.draw(background, 0, 0, 800, 800);
    	  	
    	
    	if(Gdx.input.getX() < 500 && Gdx.input.getX() > 300 && Gdx.input.getY() < 500 && Gdx.input.getY() > 300) {
    		batch.draw(playButton_active, 300, 300, 200, 200);
        	if(Gdx.input.isTouched()) {
        		this.dispose();
        		game.setScreen(new Play(maps.get(0), game));
        	}
    	}
    	else {
    		batch.draw(playButton_inactive, 300, 300, 200, 200);
    	}
    	
    	if(Gdx.input.getX() < 450 && Gdx.input.getX() > 350 && Gdx.input.getY() > 500 && Gdx.input.getY() < 600) {
    		batch.draw(exitButton_active, 350, 200, 100, 100);
        	if(Gdx.input.isTouched()) {
        		Gdx.app.exit();
        		
        	}  	

    		
    	}
    	else {
    		batch.draw(exitButton_inactive, 350, 200, 100, 100);
    	}
    	
    	
    	
    	
//    	if(Gdx.input.isTouched()) {
//    		this.dispose();
//    		game.setScreen(new Play(maps.get(0), game));
//    	}

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

	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

}
