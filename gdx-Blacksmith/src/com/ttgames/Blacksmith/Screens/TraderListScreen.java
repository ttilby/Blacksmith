package com.ttgames.Blacksmith.Screens;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Profile;
import com.ttgames.Blacksmith.Screens.Components.Components;

public class TraderListScreen extends AbstractScreen {

//	private final float MENU_BUTTON_WIDTH = 100;
//	private final float MENU_BUTTON_HEIGHT = 30;
//	private final float MENU_PADDING = 10;
//	private final float MENU_SPACE = 10;
	
	private Profile profile;
	
	
	public TraderListScreen(Blacksmith game) {
		super(game);
		
		profile = game.getProfileManager().retrieveProfile();
				
		Table table = super.getTable();
		//table.defaults().space(MENU_SPACE);
		if(Blacksmith.DEV_MODE) table.debug();
		table.top().left();
		
		table.add(backTextButton).colspan(7).size(MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT).expandX().left();
		
		table.row();
		table.add(profile.getSmithyName() + " - " + profile.getBlackSmith().getName()).expandX().left();
		//table.add(Components.getMoneyDisplay(game, profile.getBlackSmith().getMoney(), getSkin()));
		
		table.row();
		table.add("Buy / Sell").colspan(7).left().spaceBottom(MENU_SPACE);
		
		table.row();
		//table.add(Components.getCharacterTradeTable(game, profile.getMerchantCharacter(), getSkin())).colspan(2).spaceBottom(MENU_SPACE);
		
		table.row();
		//table.add(Components.getCharacterTradeTable(game, profile.getMerchantCharacter(), getSkin())).colspan(2).spaceBottom(MENU_SPACE);
		
		table.row();
		//table.add(Components.getCharacterTradeTable(game, profile.getMerchantCharacter(), getSkin())).colspan(2).spaceBottom(MENU_SPACE);
	
		
	}

}
