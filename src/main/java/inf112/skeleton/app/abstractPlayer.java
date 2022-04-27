package inf112.skeleton.app;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import objects.Item;

public abstract class abstractPlayer extends Item {

	private String message = "";
	private TiledMapTileLayer collisionLayer;

	/**
	 * abstract class containing common methods used by main players and enemies
	 * @param sprite
	 * @param collisionLayer
	 */
	public abstractPlayer(Sprite sprite, TiledMapTileLayer collisionLayer) {
		super(sprite, collisionLayer);
		this.collisionLayer = collisionLayer;
	}

	public abstract int getHealth();

	public abstract void loseHealth(int damage);

	/**
	 * Sets the message to be displayed
	 * @param newMessage
	 */
	public void setMessage(String newMessage){
		message = newMessage;
	}

	/**
	 * Gets the message to be displayed
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	
	public abstract void update();

	public abstract int getDamage();

}
