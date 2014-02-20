package com.ttgames.Blacksmith.Screens;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Profile;
import com.ttgames.Blacksmith.Screens.Components.Components;

public class GameOptionsScreen extends AbstractScreen {
	
	private Profile profile;

	public GameOptionsScreen(Blacksmith game) {
		super(game);
		
		profile = game.getProfileManager().retrieveProfile();
		
		Table table = super.getTable();
		if(Blacksmith.DEV_MODE) table.debug();
		table.top().left();
		
		table.add(backTextButton).colspan(7).size(MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT).expandX().left();
		
		table.row();
		table.add(profile.getSmithyName() + " - " + profile.getBlackSmith().getName()).expandX().left();
		table.add(profile.getBlackSmith().getMoneyDisplay(game, super.getSkin()));
		
		
	}
	
}
