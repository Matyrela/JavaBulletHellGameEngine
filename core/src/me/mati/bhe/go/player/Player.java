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
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            if(Gdx.input.isKeyPressed(Input.Keys.D)){
                Transform.setY(Transform.getY() + 7.07f);
                Transform.setX(Transform.getX() + 7.07f);
            }else if(Gdx.input.isKeyPressed(Input.Keys.A)){
                Transform.setY(Transform.getY() + 7.07f);
                Transform.setX(Transform.getX() - 7.07f);
            }else{
                Transform.setY(Transform.getY() + 10f);
            }
        } else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            if(Gdx.input.isKeyPressed(Input.Keys.D)){
                Transform.setY(Transform.getY() - 7.07f);
                Transform.setX(Transform.getX() + 7.07f);
            }else if(Gdx.input.isKeyPressed(Input.Keys.A)){
                Transform.setY(Transform.getY() - 7.07f);
                Transform.setX(Transform.getX() - 7.07f);
            }else{
                Transform.setY(Transform.getY() - 10f);
            }
        } else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            Transform.setX(Transform.getX() + 10f);
        }else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            Transform.setX(Transform.getX() - 10f);
        }


    }

    @Override
    public void Dispose(){
        super.Dispose();
    }
}
