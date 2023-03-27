package me.mati.bhe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import me.mati.bhe.go.player.Player;

public class Main extends ApplicationAdapter {
	Player pl;
	Player pl2lasecuela;

	@Override /**Start like*/
	public void create () {
		pl = new Player(0,0, "go/player/player.png");
		pl.Start();

		pl2lasecuela = new Player(200,0, "go/player/player.png");
		pl2lasecuela.Start();
	}

	@Override /**Update like*/
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		pl.Update();

		pl2lasecuela.Update();
	}

	@Override /**??? OnClose? like*/
	public void dispose () {
		pl.Dispose();

		pl2lasecuela.Dispose();
	}
}
