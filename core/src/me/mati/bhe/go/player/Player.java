package me.mati.bhe.go.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import me.mati.bhe.Main;
import me.mati.bhe.go.GameObject;

public class Player extends GameObject {
    public Player(float x, float y, String[] texture) {
        super(x, y, texture, 250 , 250, 0.2f);
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
        Transform.setY(Transform.getY() + (Gdx.input.isKeyPressed(Input.Keys.W) ? 10 : 0) + (Gdx.input.isKeyPressed(Input.Keys.S) ? -10 : 0));
        Transform.setX(Transform.getX() + (Gdx.input.isKeyPressed(Input.Keys.D) ? 10 : 0) + (Gdx.input.isKeyPressed(Input.Keys.A) ? -10 : 0));

        //Main.Cam.setFuturePosX(Main.Cam.getFuturePosX() + (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ? 10 : 0) + (Gdx.input.isKeyPressed(Input.Keys.LEFT) ? -10 : 0));
        //Main.Cam.setFuturePosY(Main.Cam.getFuturePosY() + (Gdx.input.isKeyPressed(Input.Keys.UP) ? 10 : 0) + (Gdx.input.isKeyPressed(Input.Keys.DOWN) ? -10 : 0));

        if(Gdx.input.isKeyPressed(Input.Keys.H)){
            Main.Cam.MoveCamera(400, 400, 3);
        }
    }

    @Override
    public void Dispose(){
        super.Dispose();
    }
}
