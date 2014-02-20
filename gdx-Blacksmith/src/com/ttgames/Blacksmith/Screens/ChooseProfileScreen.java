package com.ttgames.Blacksmith.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Profile;

public class ChooseProfileScreen extends AbstractScreen {

	private Profile profile1;
	private Profile profile2;
	private Table table;
	private TextButton profile1Button;
	private TextButton profile2Button;
	private ProfileButtonListener profileButtonListener;
	
	
	public ChooseProfileScreen(Blacksmith game) {
		super(game);
		
		String text1 = "Start New Game";
		String text2 = "Start New Game";
		
		profile1 = game.getProfileManager().retrieveProfile(1);
		profile2 = game.getProfileManager().retrieveProfile(2);
		
		profileButtonListener = new ProfileButtonListener();
		
		if(profile1 != null){
			text1 = profile1.getSmithyName();
		}
		
		if(profile2 != null){
			text2 = profile2.getSmithyName();
		}
		
		profile1Button = new TextButton(text1, getSkin());
		profile2Button = new TextButton(text2, getSkin());
		
		profile1Button.addListener(profileButtonListener);
		profile2Button.addListener(profileButtonListener);
	}
	
	public void show(){
		super.show();
		
		table = super.getTable();
		table.add(profile1Button).size(300,60).uniform().spaceBottom(10);
		table.row();
		table.add(profile2Button).size(300,60).uniform().spaceBottom(10);
		
	}
	
	private class ProfileButtonListener extends ChangeListener {

		@Override
		public void changed(ChangeEvent event, Actor actor) {
			int num = 0;
			
			if(actor == profile1Button) num = 1;
			else if(actor == profile2Button) num = 2;
			
			if(num > 0){
				game.getProfileManager().setProfileNumber(num);
				game.getProfileManager().retrieveProfile();
				
				Screen nextScreen = game.getStartGameScreen();
				
				if(actor == profile1Button){
					if(profile1 == null){
						nextScreen = game.getStartGameScreen();
					}else{
						nextScreen = game.getMainScreen();
					}
				}else if(actor == profile2Button){
					num = 2;
					if(profile2 == null){
						nextScreen = game.getStartGameScreen();
					}else{
						nextScreen = game.getMainScreen();
					}
				}
				
				game.setScreen(nextScreen);
				
			}else{
				Gdx.app.log(Blacksmith.LOG, "Profile number '" + num + "' not recognized.");
			}
		}
		
	}

}
