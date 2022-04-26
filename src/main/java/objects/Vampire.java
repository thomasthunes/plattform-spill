package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.abstractEnemy;
import screens.Play;

import java.util.List;

public class Vampire extends abstractEnemy {

    private final int health = 75;
    private final int damage = 2;
    private Play game;

    public Vampire(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer, play);
        this.game = play;
        setSize((float) (getWidth()*0.25), (float) (getHeight()*0.25));
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public String getName() {
        return "vampire";
    }

    @Override
    public void getAttack(objects.mainPlayer mainPlayer) {

    }

    /**
     * returns true if the player is within range of bats
     * @return boolean
     */
    public boolean playerInRange(){
        for (objects.mainPlayer player : getGame().getPlayers()) {
            if (player.getX() > this.getX() - 500 && player.getX() < this.getX() + 500)
                return true;
        }
        return false;
    }

    /**
     * throws the bats by calling the move method from bats
     * the vampire itself does not move
     */
    @Override
    public void moveRandom(){
        //Stands still
        List<abstractEnemy> stones = game.getBats();
        if (!stones.isEmpty() && playerInRange()) {
            abstractEnemy bat = stones.get(0);
            bat.update();
            game.getBats().remove(bat);
        }
    }
}
