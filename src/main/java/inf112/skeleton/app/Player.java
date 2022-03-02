package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public abstract class Player extends Sprite implements InputProcessor {

	private Vector2 velocity = new Vector2();
	
	private float speed = 60 * 2, gravity = 60 * 1.8f;
	
	private boolean canJump;

	private int health = 100;

	
	private TiledMapTileLayer collisionLayer;
	
	public Player(Sprite sprite, TiledMapTileLayer collisionLayer) {
		super(sprite);
		this.collisionLayer = collisionLayer;
		setSize((float) (getWidth()*0.2), (float) (getHeight()*0.2));
	}
	
	@Override
	public void draw(Batch batch) {
		update(Gdx.graphics.getDeltaTime());
	
		super.draw(batch);
	}

	public Boolean inBounds(){
		if (getX() / collisionLayer.getTileWidth() < 0 || getX() / collisionLayer.getTileWidth() >= collisionLayer.getWidth()){
			return false;
		}
		if (getY() / collisionLayer.getTileHeight() < 0 || getY() / collisionLayer.getTileHeight() >= collisionLayer.getHeight()) {
			return false;
		}
		return true;
	}

	//Applies gravity
	private void update(float delta) {
		if (!inBounds()){
			velocity.y = 0;
			velocity.x = 0;
			return;
		}

		velocity.y -= gravity * delta;
		
		//clamp velocity
		if(velocity.y > speed)
			velocity.y = speed;
		else if(velocity.y < speed)
			velocity.y = -speed;
		
		//save old positions
		float oldX = getX(), oldY = getY();
		float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
		
		boolean collisionX = false, collisionY = false;
		
		//move on x
		setX(getX() + velocity.x * delta);

		// Calculate increment
		int increment = collisionLayer.getTileWidth()/2;
		//int increment = getWidth() < increment ? getWidth() / 2 : increment / 2;

		// Going left: collisionX will be true if player collides with blocked tile to the left
		if(velocity.x < 0) {
			collisionX = collidesLeft(increment);
		}

		// Going right: collisionX will be true if player collides with blocked tile to the right
		else if(velocity.x > 0) {
			collisionX = collidesRight(increment);
		}

		// Reaction to collision
		if (collisionX) {
			setX(oldX);
			velocity.x = 0;
		}

		//move on y
		setY(getY() + velocity.y * delta);

		// Calculate increment
		int incrementY = collisionLayer.getTileHeight()/2;

		if(velocity.y < 0) {// going down
			canJump = collisionY = collidesBottom(incrementY);
		}
		else if(velocity.y > 0) {// going up
			collisionY = collidesTop(incrementY);
		}

		// react to y collision
		if (collisionY) {
			setY(oldY);
			velocity.y = 0;
		}
	}


		


	// Helper functions
	private boolean isCellBlocked(float x, float y) {
		TiledMapTileLayer.Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
		return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey("blocked");
	}

	public boolean collidesRight(int increment) {
		for(float step = 0; step <= getHeight(); step += increment)
			if(isCellBlocked(getX() + getWidth(), getY() + step))
				return true;
		return false;
	}

	public boolean collidesLeft(int increment) {
		// Iterates over every cell
		for(float step = 0; step <= getHeight(); step += increment)
			if(isCellBlocked(getX(), getY() + step))
				return true;
		return false;
	}

	// collidesTop() is true if player collides with collision layer at top
	public boolean collidesTop(int increment) {
		for(float step = 0; step <= getWidth(); step += increment)
			if(isCellBlocked(getX() + step, getY() + getHeight())) // getHeight() to check at top of player
				return true;
		return false;

	}

	public boolean collidesBottom(double increment) {
		for(float step = 0; step <= getWidth(); step += increment)
			if(isCellBlocked(getX() + step, getY())) // getY() without any additional increment to check on bottom
				return true; // collidesBottom() is true if player collides with collision layer
		return false; // false if player do not collide with collision layer
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public TiledMapTileLayer getCollisionLayer() {
		return collisionLayer;
	}

	public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
		this.collisionLayer = collisionLayer;
	}

	public int getHealth() {
		return health;
	}

	public void loseHealth(int damage){
		if (health != 0) {
			int newHealth = health - damage;
			health = newHealth;
		}
	}


	//test
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
			
		case Keys.SPACE:
			if(canJump)
				setY(getY()+150);
			
			break;
		
		case Keys.A:
			velocity.x = -speed;
		case Keys.LEFT:
			velocity.x = -speed;
		
			break;
		case Keys.D:
			velocity.x = speed;
		case Keys.RIGHT:
			velocity.x = speed;
		}
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
		case Keys.A:
		case Keys.LEFT:
		
		case Keys.D:
		case Keys.RIGHT:
			velocity.x = 0;
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}
	public abstract String getMessage();

	public abstract void dieFromFall();
}
