package com.ttgames.Blacksmith.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Profile;
import com.ttgames.Blacksmith.Screens.Components.Components;
import com.ttgames.Blacksmith.ui.MenuBuilder;

public class MainScreen extends AbstractScreen {

//	private final float MENU_BUTTON_WIDTH = 100;
//	private final float MENU_BUTTON_HEIGHT = 30;
//	private final float MENU_PADDING = 10;
//	private final float MENU_SPACE = 10;
	
	private Profile profile;

	//private Window menuWindow;
	private Actor gameMenu;
	private Window tradeWindow;
	private Window tradeListWindow;
	private TextButton menuWindowBuySellTextButton;
	private TextButton menuWindowInventoryTextButton;
	private TextButton menuWindowSettingsTextButton;
	private TextButton menuWindowExitTextButton;
	private TextButton menuButton;
	
	private boolean menuVisible = false;
	
	private MenuButtonListener menuButtonListener;
	
	public MainScreen(Blacksmith game) {
		super(game);
		
		profile = game.getProfileManager().retrieveProfile();
		
		menuButton = new TextButton("Menu", getSkin());
//		menuWindow = new Window("", getSkin());
//		menuWindow.pad(MENU_PADDING);
//		menuWindow.setMovable(false);
		menuWindowBuySellTextButton = new TextButton("Buy / Sell", getSkin());
		menuWindowInventoryTextButton = new TextButton("Inventory", getSkin());
		menuWindowSettingsTextButton = new TextButton("Settings", getSkin());
		menuWindowExitTextButton = new TextButton("Exit", getSkin());
		
		menuButtonListener = new MenuButtonListener();
		
		Table table = super.getTable();
		//table.clear();
		if(Blacksmith.DEV_MODE) table.debug();
		table.top().left();
		
		table.add(menuButton).colspan(7).size(MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT).expandX().left();
		
		table.row();
		table.add(profile.getSmithyName() + " - " + profile.getBlackSmith().getName()).expandX().left();
		
		table.add(profile.getBlackSmith().getMoneyDisplay(game, getSkin()));
				
//		menuWindow.add(menuWindowBuySellTextButton).size(MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);
//		menuWindow.row().space(MENU_SPACE);
//		menuWindow.add(menuWindowInventoryTextButton).size(MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);
//		menuWindow.row().space(MENU_SPACE);
//		menuWindow.add(menuWindowSettingsTextButton).size(MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);
//		menuWindow.row().space(MENU_SPACE);
//		menuWindow.add(menuWindowExitTextButton).size(MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);
//		menuWindow.setPosition(0, (game.getHeight() - menuWindow.getPrefHeight() - MENU_BUTTON_HEIGHT));
//		menuWindow.pack();
//		menuWindow.setVisible(false);
//		stage.addActor(menuWindow);
		//gameMenu = MenuBuilder.buildMenu(this);
		
		
		Gdx.app.log(Blacksmith.LOG, "menuButton listener size: " + menuButton.getListeners().size);
		menuButton.addListener(menuButtonListener);
		menuWindowBuySellTextButton.addListener(menuButtonListener);
		menuWindowInventoryTextButton.addListener(menuButtonListener);
		menuWindowSettingsTextButton.addListener(menuButtonListener);
		menuWindowExitTextButton.addListener(menuButtonListener);
		
	}
	
	public void show(){
		super.show();
	}
	
//	public void render(float delta){
//		
//	}
	
	private class MenuButtonListener extends ChangeListener {

		@Override
		public void changed(ChangeEvent event, Actor actor) {
			if(gameMenu == null) gameMenu = MenuBuilder.buildGameMenu(game.getMainScreen());
			
			if(gameMenu.getStage() != null){
				gameMenu.remove();
				//menuVisible = false;
			}else{
				stage.addActor(gameMenu);
				//menuVisible = true;
			}
		}

//		@Override
//		public void changed(ChangeEvent event, Actor actor) {
//			if(actor == menuButton){
//				if(menuWindow.isVisible()){
//					menuWindow.setVisible(false);
//				}else{
//					menuWindow.setVisible(true);
//				}
//				Gdx.app.log(Blacksmith.LOG, " *** menu button clicked ***");
//			}else if(actor == menuWindowBuySellTextButton){
//				Gdx.app.log(Blacksmith.LOG, "Buy/Sell!!");
//				//game.setScreen(game.getTraderListScreen());
//				tradeListWindow = profile.getBlackSmith().getAvailableTradeListWindow(game, getSkin());
//				tradeListWindow.setVisible(false);
//				stage.addActor(tradeListWindow);
//				tradeListWindow.setVisible(true);
//				menuWindow.setVisible(false);
//			}else if(actor == menuWindowInventoryTextButton){
//				Gdx.app.log(Blacksmith.LOG, "Inventory!!");
//				game.setScreen(game.getInventoryScreen());
//				menuWindow.setVisible(false);
//			}else if(actor == menuWindowSettingsTextButton){
//				Gdx.app.log(Blacksmith.LOG, "Settings!!");
//				game.setScreen(game.getGameOptionsScreen());
//				menuWindow.setVisible(false);
//			}else if(actor == menuWindowExitTextButton){
//				Gdx.app.exit();
//			}
//		}
		
	}
	
	public void menuTrade(){
		Gdx.app.log(Blacksmith.LOG, "Menu option: Trade");
		tradeListWindow = profile.getBlackSmith().getAvailableTradeListWindow(game, getSkin());
		tradeListWindow.setVisible(false);
		stage.addActor(tradeListWindow);
		tradeListWindow.setVisible(true);
		gameMenu.remove();
	}
	
	public void menuInventory(){
		Gdx.app.log(Blacksmith.LOG, "Menu option: Inventory");
		game.setScreen(game.getInventoryScreen());
		gameMenu.remove();
	}
	
	public void menuSettings(){
		Gdx.app.log(Blacksmith.LOG, "Menu option: Settings");
		game.setScreen(game.getGameOptionsScreen());
		gameMenu.remove();
	}
	
	public void menuExit(){
		Gdx.app.log(Blacksmith.LOG, "Menu option: Exit");
		Gdx.app.exit();
	}

}
