package objects;

public interface IItem {

    /**
     *
     * @return string containing the items name (e.g "MedKit")
     */
    public String getName();

    /**
     *
     * @param item
     * @return
     */
    boolean collidesWithActorFromSide(Item thisItem, Item item);

    /**
     *
     * @param item
     * @return
     */
    boolean collidesWithActorFromTop(Item thisItem, Item item);

    /**
     * changes the isAlive field variable to false
     * letting the play know that the item should not be drawn
     */
    public void setAliveToFalse();

    /**
     * boolean representing the state of the item
     * @return
     */
    public boolean isAlive();

    /**
     * the amount of what ever value the item gives
     * e.g amount of hp given by a medkit
     * @return
     */
    public int getAmount();
}
