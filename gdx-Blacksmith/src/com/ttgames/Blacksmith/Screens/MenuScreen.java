package com.ttgames.Blacksmith.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ttgames.Blacksmith.Blacksmith;

public class MenuScreen extends AbstractScreen {
	
	private Table table;
	
	public MenuScreen(Blacksmith game) {
		super(game);
	}
	
	public void show(){
		super.show();
		
		table = super.getTable();
		table.add("Welcome to Blacksmith for Android!").spaceBottom(50);
		table.row();
		
		
		//-------------------------------------------------------------
		//register the button "start game"
		//-------------------------------------------------------------
		TextButton startGameButton = new TextButton("Play!", getSkin());
		startGameButton.addListener(new ClickListener(){
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button){
				super.touchUp(event, x, y, pointer, button);
				game.setScreen(game.getChooseProfileScreen());
			}
		});
		table.add(startGameButton).size(300, 60).uniform().spaceBottom(10);
		table.row();
						
		//--------------------------------------------------------
		//register the button "options"
		//--------------------------------------------------------
		TextButton optionsButton = new TextButton("Options", getSkin());
		/*optionsButton.setClickListener(new ClickListener(){
			@Override
			public void click(Actor actor, float x, float y){
				//game.setScreen(game.getOptionsScreen());
			}
		});*/
		table.add(optionsButton).size(300, 60).uniform().spaceBottom(10);
		table.row();
		
		//--------------------------------------------------------
		//register the button "Exit"
		//--------------------------------------------------------
		TextButton exitButton = new TextButton("Exit", getSkin());
		exitButton.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		table.add(exitButton).size(300, 60).uniform().spaceBottom(10);
		
	}

	public void resize(int width, int height){
		super.resize(width, height);
		
		//resize the table
		table.setWidth(width);
		table.setHeight(height);
		
		//we need a complete redraw
		table.invalidateHierarchy();		
		
	}
	
	
	//not needed?
//	public void render(float delta){
//		super.render(delta);
//		
//	}
}
