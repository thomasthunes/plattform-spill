package inf112.skeleton.app;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import objects.mainPlayer;

public class controller implements InputProcessor {

    private mainPlayer player1;
    private mainPlayer player2;
    private boolean gameOver;

    public controller(mainPlayer player1, mainPlayer player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public controller(mainPlayer player1){
        this.player1 = player1;
    }

    public void setGameOver(boolean status){
        gameOver = status;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (!gameOver) {
            for (abstractEnemy enemy : player1.getGame().getEnemies()) {
                if (enemy.getName() != "bat") {
                    enemy.moveRandom();
                }
            }
        }

        switch (keycode) {
            case Input.Keys.SPACE:
                if (player1.GetCanJump()) {
                    player1.getVelocity().y = player1.getSpeed();
                    player1.jump.play();
                }

                player1.SetCanJump(false);
                break;

            case Input.Keys.A:
                player1.getVelocity().x = -player1.getSpeed();
                break;

            case Input.Keys.D:
                player1.getVelocity().x = player1.getSpeed();
                break;

            case Input.Keys.F:
                player1.pickUpItem();
                break;
        }
        if (player2 != null) {
            switch (keycode) {
                case Input.Keys.UP:
                    if (player2.GetCanJump()) {
                        player2.getVelocity().y = player2.getSpeed();
                        player2.jump.play();
                    }
                    player2.SetCanJump(false);
                    break;

                case Input.Keys.LEFT:
                    player2.getVelocity().x = -player2.getSpeed();
                    break;

                case Input.Keys.RIGHT:
                    player2.getVelocity().x = player2.getSpeed();
                    break;

                case Input.Keys.P:
                    player2.pickUpItem();
                    break;
            }
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
                player1.getVelocity().x = 0;

            case Input.Keys.D:
                player1.getVelocity().x = 0;

        }
        if (player2 != null){
            switch (keycode){
                case Input.Keys.LEFT:
                    player2.getVelocity().x = 0;

                case Input.Keys.RIGHT:
                    player2.getVelocity().x = 0;
            }
        }
        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
