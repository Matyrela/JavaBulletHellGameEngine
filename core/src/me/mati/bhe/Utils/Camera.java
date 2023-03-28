package me.mati.bhe.Utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import me.mati.bhe.Main;

public class Camera {
    int X,Y;
    int W,H;

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getWidth() {
        return W;
    }

    public void setWidth(int w) {
        W = w;
    }

    public int getHeight() {
        return H;
    }

    public void setHeight(int h) {
        H = h;
    }

    private OrthographicCamera cam;

    public Camera(int x, int y, int w, int h){
        this.X = x;
        this.Y = y;

        this.W = w;
        this.H = h;

        cam = new OrthographicCamera(30, 30 * (H / W));
        cam.position.set(cam.viewportWidth / 2, cam.viewportHeight / 2, 0);
        cam.update();
    }

    public void Update(){
        Main.Render.setProjectionMatrix(cam.combined);
        cam.setToOrtho(false, this.W, this.H);
        cam.update();


    }
}
