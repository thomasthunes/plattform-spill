package objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Item<T> extends Sprite implements IItem<T>{

    private boolean isAlive = true;
    private TiledMapTileLayer collisionLayer;
    private Vector2 velocity = new Vector2();

    private float speed = 150 /*60 * 2*/, gravity = 140 * 1f;

    private boolean canJump;

    private boolean gameFinished = false;

    public Item(Sprite sprite, TiledMapTileLayer collisionLayer) {
        super(sprite);
        this.collisionLayer = collisionLayer;
        setSize((float) (getWidth()*0.2), (float) (getHeight()*0.2));
    }

    public TiledMapTileLayer getCollisionLayer() {
        return collisionLayer;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean collidesWithActorFromSide(Item thisItem, Item item) {
        if (this.getX() < item.getX() + 35 && this.getX() > item.getX() - 35){
            return true;
        }
        return false;
    }

    @Override
    public boolean collidesWithActorFromTop(Item thisItem, Item item){
        double thisY = Math.floor(this.getY());
        double enemyY = Math.floor(item.getY());

        if (thisY == enemyY + 40){
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAliveToFalse(){
        isAlive = false;
    }

    public int getAmount(){
        return 0;
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());

        super.draw(batch);
    }

    public Boolean inBounds(){
        if (getX() / collisionLayer.getTileWidth() < 0 || getX() / collisionLayer.getTileWidth() >= collisionLayer.getWidth()){
            this.setAliveToFalse();
            return false;
        }
        if (getY() / collisionLayer.getTileHeight() < 0 || getY() / collisionLayer.getTileHeight() >= collisionLayer.getHeight()) {
            this.setAliveToFalse();
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
// Rescueline heihei
        velocity.y -= gravity * delta;

        //clamp velocity
        if(velocity.y > speed)
            velocity.y = speed;
        else if(velocity.y < -speed)
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
        //setY(getY() + velocity.y * delta);
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

        // Update animation
    }

    /*public boolean isCellFinish(float x, float y){
        TiledMapTileLayer.Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
        return cell.getTile().getProperties().containsKey("finish");
    }

    public boolean finishZone() {
        int increment = collisionLayer.getTileHeight()/2;
        for(float step = 0; step <= getWidth(); step += increment)
            if(isCellFinish(getX() + step, getY()))
                return true;
        return false;
    }*/

    public boolean getGameStatus(){
        return gameFinished;
    }


    // Helper functions
    protected boolean isCellBlocked(float x, float y) {
        TiledMapTileLayer.Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
        if ((cell == null)) {
            throw new IllegalArgumentException("cell is null");
        }
        boolean isFinish = cell.getTile().getProperties().containsKey("finish");
        if (isFinish){
            this.gameFinished = true;
        }
        else {
            this.gameFinished = false;
        }
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


    public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
        this.collisionLayer = collisionLayer;
    }

    public boolean GetCanJump(){
        return canJump;
    }

    public void SetCanJump(boolean value){
        canJump = value;
    }

}
