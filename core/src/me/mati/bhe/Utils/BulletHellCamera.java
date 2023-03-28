package me.mati.bhe.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import me.mati.bhe.Main;

public class BulletHellCamera {
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

    public int getW() {
        return W;
    }

    public void setW(int w) {
        W = w;
    }

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }

    private OrthographicCamera cam;

    public BulletHellCamera(int x, int y, int w, int h){
        this.X = x;
        this.Y = y;

        this.W = w;
        this.H = h;

        cam = new OrthographicCamera(30, 30 * (h / w));
        cam.position.set(cam.viewportWidth / 2f + X, cam.viewportHeight / 2f + Y, 0);
        cam.update();
    }

    public void Update(){
        cam.update();
        Main.Render.setProjectionMatrix(cam.combined);
        cam.setToOrtho(false, this.W, this.H);
    }
}
