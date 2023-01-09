package com.mygdx.tpk;

import com.badlogic.gdx.Game;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.GameScreen;

/**
 * Clase principal
 */
public class TpkGame extends Game {

	/**
	 * Carga el AssetLoader y manda a la SplashScreen al iniciar el juego
	 */
	@Override
	public void create () {
		AssetLoader.load();
		//this.setScreen(new SplashScreen(this));
		this.setScreen(new GameScreen()); // Temporal
	}

	/**
	 * Liberar recursos
	 */
	@Override
	public void dispose () {
		super.dispose();
		AssetLoader.dispose();
	}
}
