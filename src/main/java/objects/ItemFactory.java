package objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import screens.Play;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemFactory {

    // CONSTANTS
    private final int LENGTH_OF_SPAWN = 496;
    private final int XVampire = 315;
    private final int YVampire = 16;
    private final int NUMBEROFBATS = 100;


    private List<Enemy> enemies;
    private List<Item> items;

    public ItemFactory(){
        enemies = new ArrayList<>();
        items = new ArrayList<>();
    }

    /**
     *
     * @param amount
     * @param map
     * @param play
     * @return n number of monsters in a list
     */
    public List<Enemy> getNextMonster(int amount, TiledMap map, Play play){
        for (int i = 0; i < amount; i++){
            int xPos = getNextXPos();
            monster monster = new monster(new Sprite(new Texture("assets/maps/monster.png")), (TiledMapTileLayer) map.getLayers().get(0), play);
            monster.setPosition(xPos * monster.getCollisionLayer().getTileWidth(), (monster.getCollisionLayer().getHeight() - 4) * monster.getCollisionLayer().getTileHeight());
            enemies.add(monster);
        }
        return enemies;
    }

    /**
     *
     * @param amount
     * @param map
     * @param play
     * @return n number of bombs-objects in a list
     */
    public List<Enemy> getNextBomb(int amount, TiledMap map, Play play){
        for (int i = 0; i < amount; i++){
            int xPos = getNextXPos();
            bombs bomb = new bombs(new Sprite(new Texture("assets/maps/bomb.png")), (TiledMapTileLayer) map.getLayers().get(0), play);
            bomb.setPosition(xPos * bomb.getCollisionLayer().getTileWidth(), (bomb.getCollisionLayer().getHeight() - 4) * bomb.getCollisionLayer().getTileHeight());
            enemies.add(bomb);
        }
        return enemies;
    }

    /**
     *
     * @param map
     * @param play
     * @param enemies
     * @return the vampire object
     */
    public Vampire getVampire(TiledMap map, Play play, List<Enemy> enemies){
        int xPos = 316;
        int yPos = 36;
        Vampire vampire = new Vampire(new Sprite(new Texture("assets/maps/vampire.png")), (TiledMapTileLayer) map.getLayers().get(0), play);
        vampire.setPosition(XVampire * vampire.getCollisionLayer().getTileWidth(), (vampire.getCollisionLayer().getHeight() - YVampire) * vampire.getCollisionLayer().getTileHeight());
        enemies.add(vampire);
        return vampire;
    }

    /**
     *
     * @param map
     * @param play
     * @param bats
     * @return n bats in a list
     */
    public List<Enemy> getNextBat(TiledMap map, Play play, List<Enemy> bats){
        int amount = NUMBEROFBATS;
        int xPos = 316;
        int yPos = 36;
        for (int i = 0; i < amount; i++) {
            Bat bat = new Bat(new Sprite(new Texture("assets/maps/bat.png")), (TiledMapTileLayer) map.getLayers().get(0), play);
            bat.setPosition(XVampire * bat.getCollisionLayer().getTileWidth(), (bat.getCollisionLayer().getHeight() - YVampire) * bat.getCollisionLayer().getTileHeight());
            enemies.add(bat);
            bats.add(bat);
        }
        return enemies;

    }

    /**
     *
     * @param amount
     * @param map
     * @param play
     * @return n number of medkit-objects in a list
     */
    public List<Item> getNextMedkit(int amount, TiledMap map, Play play){
        for (int n = 0; n < amount; n++) {
            int xPos = getNextXPos();
            medKit medKit = new medKit(new Sprite(new Texture("assets/maps/medkit.png")), (TiledMapTileLayer) map.getLayers().get(0));
            medKit.setPosition(xPos * medKit.getCollisionLayer().getTileWidth(), (medKit.getCollisionLayer().getHeight() - 4) * medKit.getCollisionLayer().getTileHeight());
            items.add(medKit);
        }
        return items;
    }

    /**
     *
     * @param map
     * @param play
     * @return  the key-object
     */
    public List<Item> getKey(TiledMap map, Play play){
        Key key = new Key(new Sprite(new Texture("assets/maps/key.png")), (TiledMapTileLayer) map.getLayers().get(0));
        key.setPosition(XVampire * key.getCollisionLayer().getTileWidth(), (key.getCollisionLayer().getHeight() - YVampire) * key.getCollisionLayer().getTileHeight());
        items.add(key);
        return items;
    }

    /**
     *
     * @return random x position for new objects to spawn
     */
    public int getNextXPos(){
        Random rand = new Random();
        int xPos = rand.nextInt(LENGTH_OF_SPAWN);
        return xPos;
    }
}
