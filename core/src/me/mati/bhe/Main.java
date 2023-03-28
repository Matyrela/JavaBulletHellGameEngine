package me.mati.bhe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import me.mati.bhe.Utils.BulletHellCamera;
import me.mati.bhe.go.GameObject;
import me.mati.bhe.go.bullets.EntityManager;
import me.mati.bhe.go.player.Player;

public class Main extends ApplicationAdapter {
	public static SpriteBatch Render;
	public static int Width, Heigth;
	public BulletHellCamera Camera;

	@Override
	public void create (){
		Width = Gdx.graphics.getWidth();
		Heigth = Gdx.graphics.getHeight();
		Render = new SpriteBatch();
		Camera = new BulletHellCamera(0, -250, 500, 500);

		String[] stringArray = new String[4];
		stringArray[0] = "go\\player\\Walk0.png";
		stringArray[1] = "go\\player\\Walk1.png";
		stringArray[2] = "go\\player\\Walk2.png";
		stringArray[3] = "go\\player\\Walk3.png";

		Player pl = new Player(15, 15, stringArray);
		Gdx.input.setInputProcessor(pl);

		font = new BitmapFont();

		for (GameObject go : EntityManager.objectList) {
			go.Start();
		}
	}

	BitmapFont font;

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		Camera.Update();

		Render.begin();
		font.draw(Render, "SOY UNA REFERENCIA AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", 10, 10);

		for (GameObject go: EntityManager.objectList) {
			go.Update();
		}

		Render.end();
	}

	@Override
	public void dispose () {
		for (GameObject go: EntityManager.objectList) {
			go.Dispose();
		}
	}
}
