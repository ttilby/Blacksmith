package com.ttgames.Blacksmith.Screens.Components;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Tree.Node;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Design;
import com.ttgames.Blacksmith.Money;
import com.ttgames.Blacksmith.Items.Item;

public class Components {

	
	
//	public static Table getMoneyDisplay(Blacksmith game, Money money, Skin skin){
//		int gold = money.getGold();
//		int silver = money.getSilver();
//		int copper = money.getCopper();
//		
//		Table table = new Table(skin);
//		table.add(new Image(game.getAssetManager().get("data/images/goldIcon.png", Texture.class)));
//		table.add(" " + gold + " ");
//		table.add(new Image(game.getAssetManager().get("data/images/silverIcon.png", Texture.class)));
//		table.add(" " + silver + " ");
//		table.add(new Image(game.getAssetManager().get("data/images/copperIcon.png", Texture.class)));
//		table.add(" " + copper + " ");
//		
//		return table;
//	}
	
//	public static Table getCharacterTradeTable(final Blacksmith game, final com.ttgames.Blacksmith.Characters.Character character, Skin skin){
//		Table t = new Table(skin);
//		
//		Button button = new Button(skin);
//		
//		button.addListener(new ClickListener(){
//			@Override
//			public void touchUp(InputEvent event, float x, float y, int pointer, int button){
//				super.touchUp(event, x, y, pointer, button);
//				game.setScreen(game.getTraderScreen(character));
//			}
//		});
//		
//		button.add("Trade");
//		t.add(button);
//		
//		Table tRight = new Table(skin);
//		tRight.add(character.getName());
//		tRight.add("Level " + character.getLevel().getCurrentLevel()).right();
//		
//		tRight.row();
//		tRight.add(character.getJob().toString());
//		tRight.add(getMoneyDisplay(game, character.getMoney(), skin)).right();
//		
//		t.add(tRight);
//		
//		return t;
//	}
	
//	public static Tree getCharacterInventoryTree(Blacksmith game, com.ttgames.Blacksmith.Characters.Character character, Skin skin){
//		final Tree tree = new Tree(skin);
//		
//		Iterator<Item> iter = character.getInventory().iterator();
//		Gdx.app.log(Blacksmith.LOG, character.getName() + " has next? " + iter.hasNext());
//		while (iter.hasNext()){
//			Item item = iter.next();
//			
//			TextButton tb = new TextButton(item.getName(), skin);
//			tb.setName(Integer.toString(item.getItemID()));
//			tb.pad(10);
//			
//			final Node n = new Node(tb);
//			final Label l = new Label(item.getDescription(), skin);
//			Table t = new Table(skin);
//			t.add(l).left();
//			t.add(Components.getMoneyDisplay(game, item.getValue(), skin)).expandX().fill().right();
//			final Node c = new Node(t);
//			c.setSelectable(false);
//			n.add(c);
//			
//			n.getActor().addListener(new ClickListener(){
//				public void clicked (InputEvent event, float x, float y){
//					if(n.isExpanded()){
//						n.collapseAll();
//					}else{
//						tree.collapseAll();
//						n.expandAll();
//					}
//				}
//			});
//			
//			tree.add(n);
//		}
//		
//		return tree;
//	}
	
//	public static Window getTradeWindow(Blacksmith game, com.ttgames.Blacksmith.Characters.Character character, Skin skin){
//		TextureRegion textureRegionDark = new TextureRegion(game.getAssetManager().get("data/images/1_navigation_cancel_dark.png", Texture.class));
//		TextureRegion textureRegionLight = new TextureRegion(game.getAssetManager().get("data/images/1_navigation_cancel_light.png", Texture.class));
//		ImageButtonStyle imageButtonStyle = new ImageButtonStyle(skin.get(ButtonStyle.class));
//		imageButtonStyle.imageUp = new TextureRegionDrawable(textureRegionDark);
//		imageButtonStyle.imageDown = new TextureRegionDrawable(textureRegionLight);
//		ImageButton closeButton = new ImageButton(imageButtonStyle);
//		
//		Window window = new Window("Trade with " + character.getName(), skin);
//		window.top().right();
//		window.add(closeButton);
//		
//		
//		return window;
//	}
	
	
//	private static Window tradeListWindow;
//	public static Window getTradeListWindow(Blacksmith game, Skin skin){
//		if(tradeListWindow == null) tradeListWindow = generateTradeListWindow(game, skin);
//		return tradeListWindow;
//	}
//	private static Window generateTradeListWindow(Blacksmith game, Skin skin){
//		final Window window = new Window("Trade", skin);
//		TextureRegion textureRegionDark = new TextureRegion(game.getAssetManager().get("data/images/1_navigation_cancel_dark.png", Texture.class));
//		TextureRegion textureRegionLight = new TextureRegion(game.getAssetManager().get("data/images/1_navigation_cancel_light.png", Texture.class));
//		ImageButtonStyle imageButtonStyle = new ImageButtonStyle(skin.get(ButtonStyle.class));
//		imageButtonStyle.imageUp = new TextureRegionDrawable(textureRegionDark);
//		imageButtonStyle.imageDown = new TextureRegionDrawable(textureRegionLight);
//		ImageButton closeButton = new ImageButton(imageButtonStyle);
//		closeButton.addListener(new ClickListener(){
//			public void clicked (InputEvent event, float x, float y){
//				window.setVisible(false);
//			}
//		});
//		
//		window.top().right();
//		window.add(closeButton).right();
//		
//		Table t = new Table(skin);
//		t.padLeft(Design.GENERAL_TABLE_PAD);
//		t.padRight(Design.GENERAL_TABLE_PAD);
//		t.padBottom(Design.GENERAL_TABLE_PAD);
//		t.add(Components.getCharacterTradeTable(game, game.getProfileManager().retrieveProfile().getMerchantCharacter(), skin)).spaceBottom(Design.GENERAL_TABLE_SPACE);
//		
//		t.row();
//		t.add(Components.getCharacterTradeTable(game, game.getProfileManager().retrieveProfile().getMerchantCharacter(), skin)).spaceBottom(Design.GENERAL_TABLE_SPACE);
//		
//		t.row();
//		t.add(Components.getCharacterTradeTable(game, game.getProfileManager().retrieveProfile().getMerchantCharacter(), skin)).spaceBottom(Design.GENERAL_TABLE_SPACE);
//		
//		window.row();
//		window.add(t);
//		window.pack();
//		
//		float posX = game.getWidth() / 2 - window.getPrefWidth() / 2;
//		float posY = game.getHeight() / 2 - window.getPrefHeight() / 2;
//		window.setPosition(posX, posY);		
//		
//		return window;
//	}
	
}
