package objects;

import java.util.List;

public interface IMainPlayer {

    /**
     * shows a message on the screen, given as a param
     * @param newMessage
     */
    public void setMessage(String newMessage);

    /**
     *
     * @return the message given
     */
    public String getMessage();

    /**
     *
     * @return the damage given in an attack
     */
    public int getDamage();

    /**
     * adds an Item to the inventory
     */
    public void addItem(IItem item);

}
