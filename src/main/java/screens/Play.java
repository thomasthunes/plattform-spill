package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import org.lwjgl.opengl.GL20;

public class Play implements Screen {

    private TiledMap map;
    private OrthoCachedTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private SpriteBatch batch;


    @Override
    public void show() {
    	batch = new SpriteBatch();
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("assets/maps/map1.tmx");

        renderer = new OrthoCachedTiledMapRenderer(map, 1, 3000);

        camera = new OrthographicCamera();

        TiledMapTileLayer layer1 = (TiledMapTileLayer) map.getLayers().get("Board");

        camera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //cam.position.set(cam.viewportWidth/2f, cam.viewportHeight/2f, 0);
        camera.update();
        
        renderer.setView(camera);

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        renderer.setView(camera);
        renderer.render();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
    }
}
