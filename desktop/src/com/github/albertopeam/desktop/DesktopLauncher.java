package com.github.albertopeam.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.albertopeam.MoonLanderGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Moonlander";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new MoonLanderGame(), config);
	}
}
