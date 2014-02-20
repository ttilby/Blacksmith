package com.ttgames.Blacksmith.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.ttgames.Blacksmith.Blacksmith;

public abstract class AbstractScreen implements Screen {

	protected final Blacksmith game;
	protected final AssetManager assetManager;
	public final Stage stage;
	
	protected final float MENU_BUTTON_WIDTH = 100;
	protected final float MENU_BUTTON_HEIGHT = 30;
	protected final float MENU_PADDING = 10;
	protected final float MENU_SPACE = 10;
	
	private BitmapFont font;
	private SpriteBatch batch;
	private Skin skin;
	private Table table;
	
	protected TextButton backTextButton;
	private MenuButtonListener menuButtonListener;
	
	
	public AbstractScreen(Blacksmith game){
		this.game = game;
		this.assetManager = game.getAssetManager();
		this.stage = new Stage(0,0,true);
		
		backTextButton = new TextButton("Back", getSkin());
		
		menuButtonListener = new MenuButtonListener();
		backTextButton.addListener(menuButtonListener);
	}
	
	public void addToStage(Actor actor){
		this.stage.addActor(actor);
	}
	
	protected String getName(){
		return getClass().getSimpleName();
	}
	
	public BitmapFont getFont(){
		if (font == null){
			font = new BitmapFont();
		}
		return font;
	}
	
	public SpriteBatch getBatch(){
		if(batch == null){
			batch = new SpriteBatch();
		}
		return batch;
	}
	
	protected Skin getSkin(){
		if (skin == null){
			//FileHandle skinFile = Gdx.files.internal("data/skin/uiskin.json");
			//skin = new Skin(skinFile);
			skin = assetManager.get("data/skin/uiskin.json");
		}
		return skin;
	}
	
	protected Table getTable(){
		if(table == null){
			table = new Table(getSkin());
			table.setFillParent(true);
			//TODO DEV_MODE
			stage.addActor(table);
		}
		return table;
	}
	
	@Override
	public void show() {
		Gdx.app.log(Blacksmith.LOG, "Showing screen: " + getName());
		
		//set the input processor
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void resize(int width, int height) {
		Gdx.app.log(Blacksmith.LOG, "Resizing screen: " + getName() + " to: W" + width + " x H" + height);
		
		//resize the stage
		stage.setViewport(width, height, true);
		
	}
	
	@Override
	public void render(float delta) {
		// 1> process game logic
		stage.act(delta);
		
		// 2> draw the result
		
		//Clears the screen with the given RGB color
		Gdx.gl.glClearColor(0f,0f,0f,5f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//draw the actors
		stage.draw();
		
		if(Blacksmith.DEV_MODE) Table.drawDebug(stage);
	}

	
	@Override
	public void hide() {
		Gdx.app.log(Blacksmith.LOG, "Hiding screen: " + getName());
		
		// dispose resources by default //? why is this needed ?//
		dispose();
	}

	@Override
	public void pause() {
		Gdx.app.log(Blacksmith.LOG, "Pausing screen: " + getName());
	}

	@Override
	public void resume() {
		Gdx.app.log(Blacksmith.LOG, "Resuming screen: " + getName());
	}

	@Override
	public void dispose() {
		Gdx.app.log(Blacksmith.LOG, "Disposing screen: " + getName());
		if(font != null) font.dispose();
		if(batch != null) batch.dispose();
		
		//With this line un-commented, I get crashes, possibly due to null reference
		//if(stage != null) stage.dispose();
	}
	
	protected class MenuButtonListener extends ChangeListener {

		@Override
		public void changed(ChangeEvent event, Actor actor) {
			if(actor == backTextButton){
				game.setScreen(game.getMainScreen());
			}
		}
		
	}

}
