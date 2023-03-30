package me.mati.bhe.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import me.mati.bhe.Main;

public class Camera {
    int X,Y;
    int W,H;

    public float getFuturePosX() {
        return FuturePos.x;
    }
    public float getFuturePosY() {
        return  FuturePos.y;
    }
    public void setFuturePosX(float x) {
        FuturePos.x = x;
    }
    public void setFuturePosY(float y) {
        FuturePos.y = y;
    }


    public float getRealPosX() {
        return RealPos.x;
    }
    public float getRealPosY() {
        return RealPos.y;
    }
    public void setRealPosX(float x) {
        FuturePos.x = x;
        RealPos.x = x;
    }
    public void setRealPosY(float y) {
        FuturePos.y = y;
        RealPos.y = y;
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

    OrthographicCamera cam;

    Vector3 RealPos;
    Vector3 FuturePos;

    public Camera(int x, int y, int w, int h){
        this.X = x;
        this.Y = y;

        this.W = w;
        this.H = h;

        RealPos = new Vector3(X, Y, 0);
        FuturePos = new Vector3(X, Y, 0);

        cam = new OrthographicCamera(30, 30 * (H / W));
        cam.position.set(cam.viewportWidth / 2, cam.viewportHeight / 2, 0);
        cam.update();
    }

    public void Update(){
        Main.Render.setProjectionMatrix(cam.combined);
        cam.setToOrtho(false, this.W, this.H);
        moveToFuturePos();

        cam.update();
    }
    public float CameraSpeed = 0.1f;

    public void TeleportCamera(int x, int y){
        RealPos.x = x;
        RealPos.y = y;
        FuturePos.x = x;
        FuturePos.y = y;
    }

    public void MoveCamera(float x, float y, float speed){
        FuturePos.x = x;
        FuturePos.y = y;
        FuturePos.z = 0;
        CameraSpeed = speed;
    }

    private static final float MAX_DISTANCE_TO_GO = 100f;

    void moveToFuturePos() {
        if (RealPos == FuturePos) {
            return;
        }

        cam.position.set(RealPos);

        Vector3 direction = FuturePos.cpy().sub(RealPos);
        float distanceToGo = direction.len();
        float timeElapsed = Gdx.graphics.getDeltaTime();

        float speedMultiplier = MathUtils.clamp(distanceToGo / MAX_DISTANCE_TO_GO, 0f, 1f);
        float speed = CameraSpeed * 43 * (float)Math.exp(speedMultiplier);

        float moveDistance = Math.min(distanceToGo, timeElapsed * speed);

        RealPos.add(direction.nor().scl(moveDistance));

        if (FuturePos.dst(RealPos) < moveDistance) {
            RealPos.set(FuturePos);
        }
    }


}
