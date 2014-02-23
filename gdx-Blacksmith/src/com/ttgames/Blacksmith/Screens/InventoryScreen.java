package com.ttgames.Blacksmith.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Profile;
import com.ttgames.Blacksmith.Items.Item;

public class InventoryScreen extends AbstractScreen {
	
//	private final float MENU_BUTTON_WIDTH = 100;
//	private final float MENU_BUTTON_HEIGHT = 30;
//	private final float MENU_PADDING = 10;
//	private final float MENU_SPACE = 10;
	
	private Profile profile;
	
	
	public InventoryScreen(Blacksmith game) {
		super(game);

		profile = game.getProfileManager().retrieveProfile();
				
		Table table = super.getTable();
		if(Blacksmith.DEV_MODE) table.debug();
		table.top().left();
		
		table.add(backTextButton).colspan(7).size(MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT).expandX().left();
		
		
		table.row();
		table.add(profile.getSmithyName() + " - " + profile.getBlackSmith().getName()).expandX().left();
		table.add(profile.getBlackSmith().getMoneyDisplay(game, super.getSkin()));
		
		table.row();
		table.add("Inventory!").colspan(7).left();
		
		table.row().fillX();
		
//		final Tree tree = new Tree(getSkin());
//		
//		Iterator<Item> iter = profile.getBlackSmith().getInventory().iterator();
//		Gdx.app.log(Blacksmith.LOG, "has one? " + iter.hasNext());
//		while (iter.hasNext()){
//			Item item = iter.next();
//			
//			TextButton tb = new TextButton(item.getName(), getSkin());
//			tb.setName(Integer.toString(item.getItemID()));
//			tb.pad(10);
//			
//			final Node n = new Node(tb);
//			final Label l = new Label(item.getDescription(), getSkin());
//			Table t = new Table(getSkin());
//			t.add(l).left();
//			t.add(Components.getMoneyDisplay(game, item.getValue(), getSkin())).expandX().fill().right();
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
		
		final Tree tree = profile.getBlackSmith().getCharacterInventoryTree(game, getSkin());
		
					
		ScrollPane inventoryScrollPane = new ScrollPane(tree, getSkin());
		inventoryScrollPane.setScrollingDisabled(true, false);
		inventoryScrollPane.setSmoothScrolling(true);
		
		table.add(inventoryScrollPane).colspan(7).fill().left().top().pad(MENU_PADDING);
		
		TextButton dropTextButton = new TextButton("Drop", getSkin());
		dropTextButton.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Array<Tree.Node> arr = tree.getSelection();
				int id = Integer.parseInt(arr.get(0).getActor().getName());
				Item removed = profile.getBlackSmith().getInventory().removeItemID(id);
				
				if(removed != null){
					tree.remove(arr.get(0));
					Gdx.app.log(Blacksmith.LOG, "Selected Item: " + id + " --> Removed: " + removed.getName());
				}else{
					Gdx.app.error(Blacksmith.LOG, "ERROR: Item id: " + id + " does not exist!");
				}
			}
		});
		table.row().colspan(7).fillX();
		table.add(dropTextButton);
		
	}
	
	public void show(){
		super.show();
	}

}
