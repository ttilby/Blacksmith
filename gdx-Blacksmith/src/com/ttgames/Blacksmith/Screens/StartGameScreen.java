package com.ttgames.Blacksmith.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Profile;
import com.ttgames.Blacksmith.Services.NameGenerator;

public class StartGameScreen extends AbstractScreen {
	
	private TextField masterSmithNameTextField;
	private TextField smithyNameTextField;
	private TextButton beginTextButton;
	private ImageButton refreshNameButton;
	private StartGameListener startGameListener;
	
	private Profile profile;
	
	public StartGameScreen(Blacksmith game){
		super(game);
		Gdx.app.log(Blacksmith.LOG, "Current Profile: " + game.getProfileManager().getDataFilePath()); 
		profile = game.getProfileManager().retrieveProfile();
		startGameListener = new StartGameListener();
	}
	
	//TODO
	public void show(){
		super.show();
		
		Table table = super.getTable();
		table.defaults().spaceBottom(10);
		
		table.add("Enter the name of the Master Blacksmith:").align(Align.left);
		table.row();
		
		masterSmithNameTextField = new TextField(profile.getBlackSmith().getName(), getSkin());
		table.add(masterSmithNameTextField).size(300, 30).spaceBottom(40);
		
		TextureRegion textureRegionDark = new TextureRegion(game.getAssetManager().get("data/images/1_navigation_refresh_dark.png", Texture.class));
		TextureRegion textureRegionLight = new TextureRegion(game.getAssetManager().get("data/images/1_navigation_refresh_light.png", Texture.class));
		ImageButtonStyle imageButtonStyle = new ImageButtonStyle(getSkin().get(ButtonStyle.class));
		imageButtonStyle.imageUp = new TextureRegionDrawable(textureRegionDark);
		imageButtonStyle.imageDown = new TextureRegionDrawable(textureRegionLight);
		refreshNameButton = new ImageButton(imageButtonStyle);
		refreshNameButton.addListener(new ClickListener(){
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button){
				super.touchUp(event, x, y, pointer, button);
				masterSmithNameTextField.setText(NameGenerator.getRomanName());
			}
		});
		
		table.add(refreshNameButton).size(30,30).spaceBottom(40);
		table.row();
		
		table.add("Enter the name of your new Smithy:").align(Align.left);
		table.row();
		
		smithyNameTextField = new TextField(profile.getSmithyName(), getSkin());
		table.add(smithyNameTextField).size(300, 30).spaceBottom(40);
		table.row();
		
		beginTextButton = new TextButton("Open For Business", getSkin());
		beginTextButton.addListener(startGameListener);
		table.add(beginTextButton).size(300, 60);
		
	}
	
	private class StartGameListener extends ClickListener {
		public void clicked(InputEvent event, float x, float y){
			profile.getBlackSmith().setName(masterSmithNameTextField.getText());
			profile.setSmithyName(smithyNameTextField.getText());
			game.setScreen(game.getMainScreen());
		}
	}
}


