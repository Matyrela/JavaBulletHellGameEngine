package me.mati.bhe.go.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import me.mati.bhe.go.GameObject;

public class Player extends GameObject implements InputProcessor {
    public Player(float x, float y, String texture) {
        super(x, y, texture);
    }

    @Override
    public void Start(){
        super.Start();
    }

    @Override
    public void Update(){
        super.Update();
    }

    @Override
    public void Dispose(){
        super.Dispose();
    }

    /** InputProcesor Methods*/

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            super.Tf.setY(Tf.Y + 10);
            return true;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            super.Tf.setY(Tf.Y - 10);
            return true;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            super.Tf.setX(Tf.X - 10);
            return true;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            super.Tf.setX(Tf.X + 10);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
