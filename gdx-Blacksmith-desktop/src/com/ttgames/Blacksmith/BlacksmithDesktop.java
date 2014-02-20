package com.ttgames.Blacksmith;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class BlacksmithDesktop {
	public static void main(String[] args) {
		
		ApplicationListener listener = new Blacksmith();
		String title = "Blacksmith";
		int width = 480;
		int height = 800;
		boolean useOpenGLES2 = false;
		
		
		new LwjglApplication(listener,
							title,
							width, height,
							useOpenGLES2);
	}
}
