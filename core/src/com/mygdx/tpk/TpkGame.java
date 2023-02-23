package com.mygdx.tpk;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.GameScreen;
import com.mygdx.screens.MainMenuScreen;

/**
 * Clase principal
 */
public class TpkGame extends Game {

	/**
	 * La pista de música actual del juego
	 */
	private Music music;

	/**
	 * Carga el AssetLoader y manda a la SplashScreen al iniciar el juego
	 */
	@Override
	public void create () {
		AssetLoader.load();
		this.setScreen(new MainMenuScreen(this));
	}

	/**
	 * Liberar recursos
	 */
	@Override
	public void dispose () {
		super.dispose();
		AssetLoader.dispose();
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
}
