package me.mati.bhe.go.bullets;

import me.mati.bhe.utils.EntityManager;
import me.mati.bhe.go.GameObject;

public class Bullet extends GameObject {

    public Bullet(float x, float y, String texture, int TTL) {
        super(x, y, texture);
        EntityManager.bulletList.add(this);
    }

    public Bullet(float x, float y, String texture, byte Rebotes) {
        super(x, y, texture);
        EntityManager.bulletList.add(this);
    }

    @Override
    public void Start(){
        super.Start();
    }

    @Override
    public void Update(){
        super.Update();

        //asda
    }

    @Override
    public void Dispose(){
        super.Dispose();
    }
}
