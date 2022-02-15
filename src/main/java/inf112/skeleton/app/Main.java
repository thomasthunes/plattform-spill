package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("map");
        cfg.setWindowedMode(800, 600);

        //new Lwjgl3Application(new HelloWorld(), cfg);
        new Lwjgl3Application(new application(), cfg);
    }
}