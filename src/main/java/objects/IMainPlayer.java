package objects;

public interface IMainPlayer {

    /**
     * shows message on screen when a MainPlayer falls off map
     * reduce life with 100
     */
    public void dieFromFall();

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

}
