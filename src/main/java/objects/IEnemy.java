package objects;

public interface IEnemy {

    /**
     *
     * @return integer representing the damage while attacking
     */
    public int getDamage();

    /**
     * moves the player to the right
     */
    public void moveRight();

    /**
     * moves player to the left
     */
    public void moveLeft();

    /**
     * moves the player to right and the left
     */
    public void move();
}
