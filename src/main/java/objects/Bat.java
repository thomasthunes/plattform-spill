package objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import screens.Play;

public class Bat extends Enemy {

    private final int damage = 2;

    public Bat(Sprite sprite, TiledMapTileLayer collisionLayer, Play play) {
        super(sprite, collisionLayer, play);
    }

    @Override
    public void update(){
        moveRandom();
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
    public void getAttack() {
        getGame().getPlayer().loseHealth(this.damage);
    }

    public void moveToPlayer(){
        if (getGame().getPlayer().getX() < this.getX()){
            moveLeft();
        }
        else {
            moveRight();
        }
    }

    @Override
    public void moveRandom() {
        //super.move();
        moveToPlayer();
        if (getVelocity().y == 0){
            System.out.println(true);
            getVelocity().y = getSpeed();
            //moveToPlayer();
        }
    }
}
