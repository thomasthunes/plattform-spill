package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player;
import screens.Play;

public class Bat extends Enemy {

    private final int damage = 2;

    public Bat(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer, play);
    }

    @Override
    public void update(){
        attack();
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
        return "bat";
    }

    @Override
    public void getAttack(mainPlayer mainPlayer) {
        mainPlayer.loseHealth(this.damage);
    }

    public void moveToPlayer() {
        Player player = getGame().getPlayers().get(0);
        boolean left = player.getX() < this.getX();
        boolean right = player.getX() > this.getX();
        if (left) {
            moveLeft();
        }
        if (right) {
            moveRight();
        }
    }

    public void attack(){
        moveToPlayer();
        if (getVelocity().y == 0){
            getVelocity().y = getSpeed();
        }
    }

    @Override
    public void moveRandom() {
    }
}
