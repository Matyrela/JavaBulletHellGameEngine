package me.mati.bhe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import me.mati.bhe.go.GameObject;
import me.mati.bhe.go.bullets.EntityManager;
import me.mati.bhe.go.player.Player;

public class Main extends ApplicationAdapter {
	public static SpriteBatch Render;

	@Override /**Start like*/
	public void create () {
		Render = new SpriteBatch();

		Player pl = new Player(15, 15, "go/player/player.png");
		Gdx.input.setInputProcessor(pl);

		for (GameObject go: EntityManager.objectList) {
			go.Start();
		}
	}

	@Override /**Update like*/
	public void render() {
		ScreenUtils.clear(1, 0, 0, 1);
		Render.begin();

		for (GameObject go: EntityManager.objectList) {
			go.Update();
		}

		Render.end();
	}

	@Override /**??? OnClose? like*/
	public void dispose () {
		for (GameObject go: EntityManager.objectList) {
			go.Dispose();
		}
	}
}
