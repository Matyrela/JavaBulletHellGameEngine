package me.mati.bhe.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import me.mati.bhe.Main;

public class Camera {
    int X,Y;
    int W,H;

    public int getFuturePosX() {
        return (int) FuturePos.x;
    }
    public int getFuturePosY() {
        return (int) FuturePos.y;
    }
    public void setFuturePosX(int x) {
        FuturePos.x = x;
    }
    public void setFuturePosY(int y) {
        FuturePos.y = y;
    }


    public int getRealPosX() {
        return (int) RealPos.x;
    }
    public int getRealPosY() {
        return (int) RealPos.y;
    }
    public void setRealPosX(int x) {
        FuturePos.x = x;
        RealPos.x = x;
    }
    public void setRealPosY(int y) {
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

    private OrthographicCamera cam;

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
        moveToPostToGo();
        cam.position.lerp(RealPos, 0.5f);

        cam.update();
    }
    float CameraSpeed = 1;

    public void TeleportCamera(int x, int y){
        RealPos.x = x;
        RealPos.y = y;
        FuturePos.x = x;
        FuturePos.y = y;
    }

    public void MoveCamera(int x, int y, float speed){
        FuturePos.x = x;
        FuturePos.y = y;
        FuturePos.z = 0;
        CameraSpeed = speed;
    }

    void moveToPostToGo(){
        if(RealPos == FuturePos){
            return;
        }

        Vector3 direction = FuturePos.cpy().sub(RealPos); // calcular la dirección hacia posToGo
        float distanceToGo = direction.len(); // calcular la distancia a posToGo
        float timeElapsed = Gdx.graphics.getDeltaTime(); // obtener el tiempo transcurrido desde la última actualización de pantalla
        float moveDistance = Math.min(distanceToGo, timeElapsed * CameraSpeed * 100); // calcular la distancia a mover, limitada por la distancia restante o la velocidad de la cámara

        RealPos.add(direction.nor().scl(moveDistance)); // actualizar la posición de la cámara

        // Si la cámara se mueve más cerca de posToGo que moveDistance, ajusta la posición a posToGo
        if (FuturePos.dst(RealPos) < moveDistance) {
            RealPos.set(FuturePos);
        }
    }
}
