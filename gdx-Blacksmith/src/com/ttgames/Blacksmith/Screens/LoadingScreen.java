package com.ttgames.Blacksmith.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ttgames.Blacksmith.Blacksmith;

public class LoadingScreen implements Screen {

	private Blacksmith game;
	private AssetManager assetManager;
	private Stage stage;
	private Image loadingFrame;
	private Image loadingBarHidden;
	private Image screenBg;
	private Image loadingBg;
	
	private float startX, endX;
	private float percent;
	
	private Actor loadingBar;
	
	public LoadingScreen(Blacksmith game) {
		this.game = game;
		assetManager = game.getAssetManager();
		stage = new Stage();
	}
	
	public void show(){
		assetManager.load("data/images/loading.pack", TextureAtlas.class);
		assetManager.finishLoading();
		Gdx.app.log(Blacksmith.LOG, "Loading Screen TextureAtlas loaded.");
		TextureAtlas atlas = assetManager.get("data/images/loading.pack", TextureAtlas.class);
		
		loadingFrame = new Image(atlas.findRegion("loading-frame"));
		loadingBarHidden = new Image(atlas.findRegion("loading-bar-hidden"));
		screenBg = new Image(atlas.findRegion("screen-bg"));
		loadingBg = new Image(atlas.findRegion("loading-frame-bg"));
		loadingBar = new Image(atlas.findRegion("loading-bar2"));
		
		stage.addActor(loadingFrame);
		stage.addActor(loadingBarHidden);
		stage.addActor(screenBg);
		stage.addActor(loadingBg);
		stage.addActor(loadingBar);
		
		//All assets to be loaded for the game
		assetManager.load("data/images/splashscreen/anvilhammer.png", Texture.class);
		assetManager.load("data/skin/uiskin.json", Skin.class);
		assetManager.load("data/images/goldIcon.png", Texture.class);
		assetManager.load("data/images/silverIcon.png", Texture.class);
		assetManager.load("data/images/copperIcon.png", Texture.class);
		assetManager.load("data/images/1_navigation_refresh_dark.png", Texture.class);
		assetManager.load("data/images/1_navigation_refresh_light.png", Texture.class);
		assetManager.load("data/images/1_navigation_cancel_dark.png", Texture.class);
		assetManager.load("data/images/1_navigation_cancel_light.png", Texture.class);
		//assetManager.load("data/skin/menuTexture.png", Texture.class);
	}
	
	public void resize(int width, int height){
		loadingFrame.setX((stage.getWidth() - loadingFrame.getWidth()) / 2);
		loadingFrame.setY((stage.getHeight() - loadingFrame.getHeight()) / 2);
		
		loadingBar.setX(loadingFrame.getX() + 15);
		loadingBar.setY(loadingFrame.getY() + 5);
		
		loadingBarHidden.setX(loadingBar.getX() + 35);
		loadingBarHidden.setY(loadingBar.getY() - 3);
		
		startX = loadingBarHidden.getX();
		endX = 440;
		
		loadingBg.setSize(450, 50);
		loadingBg.setX(loadingBarHidden.getX() + 30);
		loadingBg.setY(loadingBarHidden.getY() + 3);
		
	}
	
	public void render(float delta){
		
		if(assetManager.update()){
			game.setScreen(game.getSplashScreen());
		}
		
		percent = Interpolation.linear.apply(percent, assetManager.getProgress(), 0.1f);
		
		loadingBarHidden.setX(startX + endX * percent);
		loadingBg.setX(loadingBarHidden.getX() + 30);
		loadingBg.setWidth(450 - 450 * percent);
		loadingBg.invalidate();
		
		stage.draw();
	}
	
	public void hide(){
		assetManager.unload("data/images/loading.pack");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

}
