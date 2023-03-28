package me.mati.bhe.go.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import me.mati.bhe.go.GameObject;

public class Player extends GameObject {
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
        move();
    }
    private void move() {
        Transform.setY(Transform.Y + (Gdx.input.isKeyPressed(Input.Keys.W) ? 10 : 0) + (Gdx.input.isKeyPressed(Input.Keys.S) ? -10 : 0));
        Transform.setX(Transform.X + (Gdx.input.isKeyPressed(Input.Keys.D) ? 10 : 0) + (Gdx.input.isKeyPressed(Input.Keys.A) ? -10 : 0));
    }

    @Override
    public void Dispose(){
        super.Dispose();
    }
}
