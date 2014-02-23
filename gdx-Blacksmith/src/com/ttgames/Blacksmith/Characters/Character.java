package com.ttgames.Blacksmith.Characters;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.ui.Tree.Node;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Design;
import com.ttgames.Blacksmith.Inventory;
import com.ttgames.Blacksmith.Level;
import com.ttgames.Blacksmith.Level.LevelType;
import com.ttgames.Blacksmith.Money;
import com.ttgames.Blacksmith.Items.Item;

public abstract class Character implements Serializable {
	private String name;
	private String description;
	private int age;
	private CharacterJob job;
	protected Money money;
	//private CharacterSkills Skills;
	protected Inventory inventory; //items carried
	//private CharacterEquipped Equipped;   //items equipped
	private Level level;
	
	
	private Window tradeWindow;
	
	public Character() {
		name = "";
		description = "";
		age = 0;
		job = CharacterJob.Townsman;
		inventory = new Inventory();
		money = new Money(0);
		level = new Level(LevelType.Character);
	}
		
	public Character(String name, CharacterJob job){
		this.name = name;
		this.job = job;
		this.description = "";
		this.age = 0;
		this.inventory = new Inventory();
		this.money = new Money(100);
		this.level = new Level(LevelType.Character);
		
//		for(int i=1; i<25; i++){
//			Item item = new Item(i, "Item " + i, "Item " + i + " Desc", i);
//			this.inventory.addItem(item);
//		}
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Money getMoney(){
		return money;
	}
	
	public Table getMoneyDisplay(Blacksmith game, Skin skin){
		return money.getMoneyDisplay(game, skin);
	}
	
	public Inventory getInventory(){
		if(inventory == null) {
			inventory = new Inventory();
		}
		
		return inventory;
	}
	
	protected Item getItem(int itemID) {
		return inventory.getItem(itemID);
	}
	
	public Level getLevel(){
		return level;
	}
	
	public CharacterJob getJob(){
		return job;
	}

	public void write(Json json){
		json.writeValue("name", name);
		json.writeValue("description", description);
		json.writeValue("age", age);
		json.writeValue("job", job);
		json.writeValue("inventory", inventory);
		json.writeValue("money", money);
		json.writeValue("level", level);
	}
	
	public void read(Json json, JsonValue jsonData){
		name = json.readValue("name", String.class, jsonData);
		description = json.readValue("description", String.class, jsonData);
		age = json.readValue("age", Integer.class, jsonData);
		job = json.readValue("job", CharacterJob.class, jsonData);
		inventory = json.readValue("inventory", Inventory.class, jsonData);
		money = json.readValue("money", Money.class, jsonData);
		level = json.readValue("level", Level.class, jsonData);
	}
	

	/*public void sellItem(Character c, Item i, Money m){
		this.inventory.removeItem(i);
		c.inventory.addItem(i);
		
		this.money.deposit(m.getValue());
		c.money.withdrawl(m.getValue());
		Gdx.app.log(Blacksmith.LOG, this.name + " sold item " + i.getName() + " to " + c.getName() + " for " + m.getValue());
	}*/
	
	public void tradeItem(Character c, Item i){
		this.inventory.removeItem(i);
		c.inventory.addItem(i);
		
		this.money.deposit(i.getValue());
		c.money.withdrawl(i.getValue());
		Gdx.app.log(Blacksmith.LOG, this.name + " traded item " + i.getName() + " to " + c.getName() + " for " + i.getValue().toString());
	}
	
	public Tree getCharacterInventoryTree(Blacksmith game, Skin skin){
		final Tree tree = new Tree(skin);
		
		Iterator<Item> iter = getInventory().iterator();
		Gdx.app.log(Blacksmith.LOG, getName() + " has next? " + iter.hasNext());
		while (iter.hasNext()){
			Item item = iter.next();
			Gdx.app.log(Blacksmith.LOG, item.toString());
			TextButton tb = new TextButton(item.getName(), skin);
			tb.setName(Integer.toString(item.getItemID()));
			tb.pad(10);
			
			final Node n = new Node(tb);
			final Label l = new Label(item.getDescription(), skin);
			Table t = new Table(skin);
			t.add(l).left();
			t.add(item.getMoneyDisplay(game, skin)).expandX().fill().right();
			final Node c = new Node(t);
			c.setSelectable(false);
			n.add(c);
			
			n.getActor().addListener(new ClickListener(){
				public void clicked (InputEvent event, float x, float y){
					if(n.isExpanded()){
						n.collapseAll();
					}else{
						tree.collapseAll();
						n.expandAll();
					}
				}
			});
			
			tree.add(n);
		}
		tree.pack();
		return tree;
	}
	
	public Table getCharacterTradeTable(final Blacksmith game, final Skin skin, final Window parent){
		Table t = new Table(skin);
		
		Button button = new Button(skin);
		
		button.addListener(new ClickListener(){
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button){
				super.touchUp(event, x, y, pointer, button);
				//game.setScreen(game.getTraderScreen(character));
				parent.setVisible(false);
				Window tradeWindow = getTradeWindow(game, skin);
				game.getMainScreen().addToStage(tradeWindow);
				tradeWindow.setVisible(true);
			}
		});
		
		button.add("Trade").pad(Design.GENERAL_BUTTON_PAD);
		t.add(button);
		
		Table tRight = new Table(skin);
		tRight.add(getName());
		tRight.add("Level " + getLevel().getCurrentLevel()).right();
		
		tRight.row();
		tRight.add(getJob().toString());
		tRight.add(getMoneyDisplay(game, skin)).right();
		
		t.add(tRight);
		
		return t;
	}
	
	// Shows list of characters available for trade
	public Window getAvailableTradeListWindow(Blacksmith game, Skin skin){
		final Window window = new Window("", skin);
		TextureRegion textureRegionDark = new TextureRegion(game.getAssetManager().get("data/images/1_navigation_cancel_dark.png", Texture.class));
		TextureRegion textureRegionLight = new TextureRegion(game.getAssetManager().get("data/images/1_navigation_cancel_light.png", Texture.class));
		ImageButtonStyle imageButtonStyle = new ImageButtonStyle(skin.get(ButtonStyle.class));
		imageButtonStyle.imageUp = new TextureRegionDrawable(textureRegionDark);
		imageButtonStyle.imageDown = new TextureRegionDrawable(textureRegionLight);
		ImageButton closeButton = new ImageButton(imageButtonStyle);
		closeButton.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x, float y){
				window.setVisible(false);
			}
		});
		
		window.add(new Label("Trade", skin)).center();		
		window.add(closeButton).right();
		
		Table t = new Table(skin);
		t.pad(Design.GENERAL_TABLE_PAD);
		t.add(game.getProfileManager().retrieveProfile().getMerchantCharacter().getCharacterTradeTable(game, skin, window)).spaceBottom(Design.GENERAL_TABLE_SPACE);
		
		t.row();
		t.add(game.getProfileManager().retrieveProfile().getMerchantCharacter().getCharacterTradeTable(game, skin, window)).spaceBottom(Design.GENERAL_TABLE_SPACE);
		
		t.row();
		t.add(game.getProfileManager().retrieveProfile().getMerchantCharacter().getCharacterTradeTable(game, skin, window)).spaceBottom(Design.GENERAL_TABLE_SPACE);
		
		window.row();
		window.add(t);
		window.pack();
		
		float posX = game.getWidth() / 2 - window.getPrefWidth() / 2;
		float posY = game.getHeight() / 2 - window.getPrefHeight() / 2;
		window.setPosition(posX, posY);		
		
		return window;
	}
	
	// handles view of trading with this character
	public Window getTradeWindow(Blacksmith game, Skin skin){
		if(tradeWindow == null) tradeWindow = generateTradeWindow(game, skin);
		return tradeWindow;
	}
	private Window generateTradeWindow(Blacksmith game, Skin skin){
		final Character blacksmith = game.getProfileManager().retrieveProfile().getBlackSmith();
		final Character character = this;
		
		final Window window = new Window("", skin);
		
		TextureRegion textureRegionDark = new TextureRegion(game.getAssetManager().get("data/images/1_navigation_cancel_dark.png", Texture.class));
		TextureRegion textureRegionLight = new TextureRegion(game.getAssetManager().get("data/images/1_navigation_cancel_light.png", Texture.class));
		ImageButtonStyle imageButtonStyle = new ImageButtonStyle(skin.get(ButtonStyle.class));
		imageButtonStyle.imageUp = new TextureRegionDrawable(textureRegionDark);
		imageButtonStyle.imageDown = new TextureRegionDrawable(textureRegionLight);
		ImageButton closeButton = new ImageButton(imageButtonStyle);
		closeButton.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x, float y){
				window.setVisible(false);
			}
		});
		
		window.setWidth(game.getWidth() - 40);
		window.setHeight(game.getHeight() - 300);
		
		final Label labelTitle = new Label("Trade with " + getName() + " : Buy", skin);
		
		final Table content = new Table(skin);
		content.padLeft(Design.GENERAL_TABLE_PAD);
		content.padRight(Design.GENERAL_TABLE_PAD);
		content.padBottom(Design.GENERAL_TABLE_PAD);
		
		final Tree blacksmithInventoryTree = blacksmith.getCharacterInventoryTree(game, skin);
		final Tree characterInventoryTree = getCharacterInventoryTree(game, skin);
		
		content.add(characterInventoryTree).expandX().fillX().top().left();
		
		final TextButton actionButton = new TextButton("BUY", skin);
		actionButton.setWidth(50);
		actionButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				Gdx.app.log(Blacksmith.LOG, "equals('BUY'): " + actionButton.getText().equals("BUY"));
				if (actionButton.getText().toString().equals("BUY")){
					// change to Sell
					Gdx.app.log(Blacksmith.LOG, "change to SELL");
					content.clear();
					content.add(blacksmithInventoryTree).expandX().fillX().top().left();
					labelTitle.setText("Trade with " + getName() + " : Sell");
					actionButton.setText("SELL");
				}else{
					//change to Buy
					Gdx.app.log(Blacksmith.LOG, "change to BUY");
					content.clear();
					content.add(characterInventoryTree).expandX().fillX().top().left();
					labelTitle.setText("Trade with " + getName() + " : Buy");
					actionButton.setText("BUY");
				}
			}
		});
		
		window.add(labelTitle).expandX().fillX().center();
		window.add(actionButton).padRight(Design.MENU_PADDING).center().right();
		window.add(closeButton).top().right();

		window.row();
		window.add(content).colspan(3).expand().fillX().top().left();
		
		window.row();
		TextButton tradeButton = new TextButton("Trade", skin);
		tradeButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				if(actionButton.getText().toString().equals("BUY")){
					Array<Tree.Node> arr = characterInventoryTree.getSelection();
					if(arr.size > 0){
						int itemID = Integer.parseInt(arr.get(0).getActor().getName());
						Gdx.app.log(Blacksmith.LOG, "buying item: " + itemID);
						Item item = getItem(itemID);
						character.tradeItem(blacksmith, item);
						characterInventoryTree.remove(arr.get(0));
					}
				}else{
					Array<Tree.Node> arr = blacksmithInventoryTree.getSelection();
					if(arr.size > 0){
						int itemID = Integer.parseInt(arr.get(0).getActor().getName());
						Gdx.app.log(Blacksmith.LOG, "selling item: " + itemID);
						Item item = getItem(itemID);
						blacksmith.tradeItem(character, item);
						blacksmithInventoryTree.remove(arr.get(0));
					}
				}
			}
		});
		window.add(tradeButton).colspan(3);

		window.row();
		
		
		//window.pack();
		
		float posX = game.getWidth() / 2 - window.getWidth() / 2;
		float posY = game.getHeight() / 2 - window.getHeight() / 2;
		window.setPosition(posX, posY);	
		window.debug();
		return window;
	}


	
//	private class WindowButtonListener extends ChangeListener{
//		@Override
//		public void changed(ChangeEvent event, Actor actor){
//			if(actor.isDescendantOf(tradeListWindow)){
//				
//			}
//		}
//	}
	
	
	
}
