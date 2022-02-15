package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;

public class application extends InputAdapter implements ApplicationListener {
    private TiledMap map;
    private TmxMapLoader mapLoader;
    private SpriteBatch batch;

    private TiledMapTileLayer layer1;

    private OrthoCachedTiledMapRenderer renderer;
    private OrthographicCamera cam;

    private int mapWidth;
    private int mapHeight;

    @Override
    public void create() {
        mapWidth = 50;
        mapHeight = 50;
        batch = new SpriteBatch();

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("assets/maps/map1.tmx");
        cam = new OrthographicCamera();

        layer1 = (TiledMapTileLayer) map.getLayers().get("Board");

        cam.setToOrtho(false, mapWidth, mapHeight);
        cam.update();

        renderer = new OrthoCachedTiledMapRenderer(map, 1/300f);
        renderer.setView(cam);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int i, int i1) {
        /*cam.viewportHeight = mapHeight;
        cam.viewportWidth = mapWidth;
        cam.update();*/

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        Gdx.app.exit();
        System.exit(0);
    }
}
