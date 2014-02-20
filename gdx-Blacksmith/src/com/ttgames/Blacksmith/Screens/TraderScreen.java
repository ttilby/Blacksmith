package com.ttgames.Blacksmith.Screens;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.ttgames.Blacksmith.Characters.Character;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Profile;
import com.ttgames.Blacksmith.Screens.Components.Components;

public class TraderScreen extends AbstractScreen {

	private Profile profile;
	//private Character characterTradeWith;
	
	public TraderScreen(Blacksmith game, Character characterTradeWith) {
		super(game);
		
		//this.characterTradeWith = characterTradeWith;
		profile = game.getProfileManager().retrieveProfile();
		
		Table table = super.getTable();
		if(Blacksmith.DEV_MODE) table.debug();
		table.top().left();
		
		table.add(backTextButton).colspan(7).size(MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT).expandX().left();
		
		table.row();
		table.add(profile.getSmithyName() + " - " + profile.getBlackSmith().getName()).expandX().left();
		//table.add(Components.getMoneyDisplay(game, profile.getBlackSmith().getMoney(), getSkin()));
		
		table.row();
		table.add("Trade with " + characterTradeWith.getName()).colspan(7).left().spaceBottom(MENU_SPACE);
		
		table.row();
		
		//Add Player Inventory
		//final Tree tree1 = Components.getCharacterInventoryTree(game, profile.getBlackSmith(), getSkin());
		//ScrollPane blacksmithInventoryScrollPane = new ScrollPane(tree1, getSkin());
		//blacksmithInventoryScrollPane.setScrollingDisabled(true, false);
		//blacksmithInventoryScrollPane.setSmoothScrolling(true);
		//blacksmithInventoryScrollPane.setVisible(false);
		
		//Add Other Player Inventory
		//final Tree tree2 = Components.getCharacterInventoryTree(game, characterTradeWith, getSkin());
		//ScrollPane tradeWithInventoryScrollPane = new ScrollPane(tree2, getSkin());
		//tradeWithInventoryScrollPane.setScrollingDisabled(true, false);
		//tradeWithInventoryScrollPane.setSmoothScrolling(true);
		
		
		//table.add(blacksmithInventoryScrollPane).colspan(7).expandX().fill();
		table.row();
		//table.add(tradeWithInventoryScrollPane).colspan(7).expandX().fill();
		
		//Add buttons (tabs)
	}

}
