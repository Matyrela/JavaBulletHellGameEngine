package me.mati.bhe.go.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
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
        move(Gdx.graphics.getDeltaTime());

    }

    // Definir la velocidad de movimiento
    private final float SPEED = 10;
    private final float DIAGONAL_SPEED = (float) (SPEED / Math.sqrt(2));

    // Definir un vector de dirección inicial
    Vector2 direction = new Vector2();

    private void move(float delta) {

        direction.set(0f, 0f);

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            direction.y = 1f;
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            direction.y = -1f;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            direction.x = -1f;
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            direction.x = 1f;
        }

        if (direction.len2() > 0) {
            direction.nor();
        }

        float dx = direction.x * SPEED * 50 * delta;
        float dy = direction.y * SPEED * 50 * delta;

        Transform.translate(dx, dy, 0f);
    }

    @Override
    public void Dispose(){
        super.Dispose();
    }
}
