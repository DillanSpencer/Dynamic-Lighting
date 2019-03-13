package com.quad.test;

import com.quad.core.AbstractGame;
import com.quad.core.GameContainer;
import com.quad.core.Settings;

public class LightTest {
	
	public static void main(String[] args) {
		 GameContainer gc = new GameContainer(new AbstractGame());
         gc.setWidth(Settings.WIDTH);
         gc.setHeight(Settings.HEIGHT);
         gc.setScale(Settings.SCALE);
         gc.setTitle("Quad Engine: 2D Dynamic Light Test");
         gc.setClearScreen(true);
         gc.start();
	}

}
