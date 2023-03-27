package me.mati.bhe.go;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.mati.bhe.Main;
import me.mati.bhe.go.bullets.EntityManager;

public class GameObject {

    public SpriteRender Sp;
    public Transform Tf;
    public GameObject(float x, float y, String texture){
        Sp = new SpriteRender(texture);
        Tf = new Transform(x,y);
        EntityManager.objectList.add(this);
    }

    public class SpriteRender{
        public Texture Sprite;

        public SpriteRender(String texture){

            this.Sprite = new Texture(texture);
        }

        public void Render(){
            Main.Render.draw(Sprite, Tf.X, Tf.Y);
        }

        public void Garbage(){
            Sprite.dispose();
        }
    }

    public class Transform {
        public float X = 0;
        public float Y = 0;

        public Transform(float x, float y){
            this.X = x;
            this.Y = y;
        }
        public void setX(float x) {
            X = x;
        }
        public void setY(float y) {
            Y = y;
        }
    }

    public void Start(){

    }

    public void Update(){
        Sp.Render();
    }

    public void Dispose(){
        Sp.Garbage();
    }
}
