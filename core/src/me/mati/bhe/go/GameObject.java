package me.mati.bhe.go;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import me.mati.bhe.Main;
import me.mati.bhe.utils.EntityManager;

public class GameObject {

    public SpriteRender SpriteRenderer;
    public Transformizer Transform;
    public GameObject(float x, float y, String texture){
        SpriteRenderer = new SpriteRender(texture);
        Transform = new Transformizer(x,y);
        EntityManager.objectList.add(this);
    }

    public GameObject(float x, float y, String texture, float xT, float yT){
        SpriteRenderer = new SpriteRender(texture);
        Transform = new Transformizer(x,y,xT,yT);
        EntityManager.objectList.add(this);
    }

    public GameObject(float x, float y, String[] texture, float animSpeed){
        SpriteRenderer = new SpriteRender(texture, animSpeed);
        Transform = new Transformizer(x,y);
        EntityManager.objectList.add(this);
    }

    public GameObject(float x, float y, String[] texture, float xT, float yT, float animSpeed){
        SpriteRenderer = new SpriteRender(texture, animSpeed);
        Transform = new Transformizer(x,y,xT,yT);
        EntityManager.objectList.add(this);
    }

    public class SpriteRender{
        public Texture Sprite;
        public Texture[] Sprites;
        int frames;
        float AnimSpeed = 0;


        public SpriteRender(String texture){
            this.Sprite = new Texture(texture);
        }

        public SpriteRender(String[] texture, float animSpeed){
            AnimSpeed = animSpeed;
            Texture[] Textures = new Texture[texture.length];
            for (int i = 0; i < texture.length; i++) {
                Texture j = new Texture(texture[i]);
                Textures[i] = j;
            }
            this.Sprites = Textures;
        }

        void Render(){

            Main.Render.draw(Sprite, Transform.X, Transform.Y, Transform.XT, Transform.YT);
        }
        long lastFrameTime;
        void MultiRender(){
            long currentTime = TimeUtils.nanoTime();
            float deltaTime = (currentTime - lastFrameTime) / 1000000000.0f;

            if (deltaTime > AnimSpeed) {
                frames += (int)(deltaTime / AnimSpeed);
                lastFrameTime = currentTime;
            }

            if(frames >= Sprites.length)
                frames = 0;

            Main.Render.draw(Sprites[frames], Transform.X - (Transform.XT / 2), Transform.Y - (Transform.YT / 2), Transform.XT, Transform.YT);
        }

        public void Garbage(){
            if(Sprite == null){
                for(Texture s : Sprites){
                    s.dispose();
                }
            }else{
                Sprite.dispose();
            }
        }
    }

    public class Transformizer {
        float X = 0;
        float Y = 0;
        float XT = (SpriteRenderer.Sprite == null) ? SpriteRenderer.Sprites[0].getWidth() : SpriteRenderer.Sprite.getWidth();
        float YT = (SpriteRenderer.Sprite == null) ? SpriteRenderer.Sprites[0].getHeight() : SpriteRenderer.Sprite.getHeight();
        private Vector3 position;
        private Matrix4 matrix;

        Transformizer(float x, float y){
            this.X = x;
            this.Y = y;
            position = new Vector3();
            matrix = new Matrix4();
        }

        Transformizer(float x, float y, float xT, float yT){
            this.X = x;
            this.Y = y;
            this.XT = xT;
            this.YT = yT;
            position = new Vector3();
            matrix = new Matrix4();
        }
        public void setX(float x) {
            X = x;
        }

        public void setY(float y) {
            Y = y;
        }

        public void translate(float x, float y, float z) {
            position.add(x, y, z);
            matrix.translate(x, y, z);
            X = position.x;
            Y = position.y;
        }

        public float getX() {
            return X;
        }

        public float getY() {
            return Y;
        }
    }

    public void Start(){

    }

    public void Update(){
        if(this.SpriteRenderer.Sprites == null){
            SpriteRenderer.Render();
        }else if(this.SpriteRenderer.Sprite == null){
            SpriteRenderer.MultiRender();
        }
    }

    public void Dispose(){
        SpriteRenderer.Garbage();
    }
}
