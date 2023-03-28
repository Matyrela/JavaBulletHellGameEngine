package me.mati.bhe.go.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import me.mati.bhe.go.GameObject;

public class Player extends GameObject implements InputProcessor {
    public Player(float x, float y, String[] texture) {
        super(x, y, texture, 250 , 250);
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
    public boolean keyUp(int keycode) { return false; }

    @Override
    public boolean keyTyped(char character) {
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            Transform.setY(Transform.Y + 10);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            Transform.setY(Transform.Y - 10);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            Transform.setX(Transform.X - 10);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            Transform.setX(Transform.X + 10);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
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
