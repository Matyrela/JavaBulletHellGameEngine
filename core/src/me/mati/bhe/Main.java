package me.mati.bhe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import me.mati.bhe.Utils.Camera;
import me.mati.bhe.go.GameObject;
import me.mati.bhe.Utils.EntityManager;
import me.mati.bhe.go.player.Player;

public class Main extends ApplicationAdapter {
	public static SpriteBatch Render;
	public static int Width, Heigth;
	public static Camera Cam;
	Player pl;

	@Override
	public void create (){
		Width = Gdx.graphics.getWidth();
		Heigth = Gdx.graphics.getHeight();
		Render = new SpriteBatch();

		Cam = new Camera(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		String[] stringArray = new String[4];
		stringArray[0] = "go/player/Walk0.png";
		stringArray[1] = "go/player/Walk1.png";
		stringArray[2] = "go/player/Walk2.png";
		stringArray[3] = "go/player/Walk3.png";

		pl = new Player(15, 15, stringArray);

		font = new BitmapFont();

		for (GameObject go : EntityManager.objectList) {
			go.Start();
		}
	}

	BitmapFont font;

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		Cam.Update();

		Render.begin();
		font.draw(Render, ".", 0, 0);
		font.draw(Render, "0 | 0", -12, 7);

		font.draw(Render, "(" + pl.Transform.getX() + " , " + pl.Transform.getY() + ")", pl.Transform.getX(), pl.Transform.getY());

		font.draw(Render, "(" + Cam.getRealPosX() + " , " + Cam.getRealPosY() + ")",  Cam.getRealPosX(), Cam.getRealPosY());
		font.draw(Render, "(" + Cam.getFuturePosX() + " , " + Cam.getFuturePosY() + ")",  Cam.getFuturePosX(), Cam.getFuturePosY());

		Cam.setFuturePosX(pl.Transform.getX());
		Cam.setFuturePosY(pl.Transform.getY());

		for (GameObject go: EntityManager.objectList) {
			go.Update();
		}

		Render.end();
	}

	@Override
	public void dispose() {
		for (GameObject go: EntityManager.objectList) {
			go.Dispose();
		}
	}

	@Override
	public void resize(int width, int height){
		Width = Gdx.graphics.getWidth();
		Heigth = Gdx.graphics.getHeight();
		Cam.setWidth(Width);
		Cam.setHeight(Heigth);
	}
}
