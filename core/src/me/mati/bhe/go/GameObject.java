package me.mati.bhe.go;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.mati.bhe.Main;
import me.mati.bhe.go.bullets.EntityManager;

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
        Transform = new Transformizer(x,y);
        EntityManager.objectList.add(this);
    }

    public class SpriteRender{
        public Texture Sprite;

        public SpriteRender(String texture){

            this.Sprite = new Texture(texture);
        }

        public void Render(){
            Main.Render.draw(Sprite, Transform.X, Transform.Y, Transform.XT, Transform.YT);
        }

        public void Garbage(){
            Sprite.dispose();
        }
    }

    public class Transformizer {
        public float X = 0;
        public float Y = 0;
        public float XT = SpriteRenderer.Sprite.getWidth();
        public float YT = SpriteRenderer.Sprite.getHeight();

        public Transformizer(float x, float y){
            this.X = x;
            this.Y = y;
        }
        public Transformizer(float x, float y, float xT, float yT){
            this.X = x;
            this.Y = y;
            this.XT = xT;
            this.YT = yT;
        }


        public void setX(float x) { X = x; }
        public void setY(float y) {
            Y = y;
        }
    }

    public void Start(){

    }

    public void Update(){
        SpriteRenderer.Render();
    }

    public void Dispose(){
        SpriteRenderer.Garbage();
    }
}
