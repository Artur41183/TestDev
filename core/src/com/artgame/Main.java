package com.artgame;

import com.artgame.utils.Assets;
import com.artgame.view.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class Main extends Game {

	private Screen gameScreen;
	private Assets assets;

	@Override
	public void create() {
		assets = new Assets();
		gameScreen = new GameScreen();
		((GameScreen)gameScreen).setTextureAtlas(assets.getManager().get("atlas1.atlas", TextureAtlas.class));
		setScreen(gameScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		gameScreen.dispose();
		assets.dispose();
	}
}
