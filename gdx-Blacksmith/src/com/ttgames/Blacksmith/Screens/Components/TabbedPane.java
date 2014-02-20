package com.ttgames.Blacksmith.Screens.Components;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ttgames.Blacksmith.Blacksmith;

// 06-15-2013 This is not finished nor used // can probably be deleted

public class TabbedPane {

	private ArrayList<ScrollPane> scrollPanes;
	private ArrayList<Button> buttons;
	private Skin skin;
	private int width = 400;
	private int height = 500;
	private final int TAB_HEIGHT = 50;
	
	
	public TabbedPane(Skin skin) {
		this.skin = skin;
	}
	
	public void addContent(Table content, Button button){
		ScrollPane sp = new ScrollPane(content);
		scrollPanes.add(sp);
		buttons.add(button);
	}
	
	public Table generateTabbedPane(){
		if(scrollPanes.size() == 0){
			Gdx.app.log(Blacksmith.LOG, "There are no content scroll panes in the tabbed pane");
			return null;
		}
		if(buttons.size() == 0){
			Gdx.app.log(Blacksmith.LOG, "There are no buttons in the tabbed pane");
			return null;
		}
		if(scrollPanes.size() != buttons.size()) {
			Gdx.app.log(Blacksmith.LOG, "There is a mismatched number of scroll panes and buttons!");
			return null;
		}
		
		Table tp = new Table(skin);
		Table content = new Table(skin);
		Table tabs = new Table(skin);
		
		content.setSize(width, height - TAB_HEIGHT);
		tabs.setSize(width, TAB_HEIGHT);
		
		for(int x = 0; x < scrollPanes.size(); x++){
			ScrollPane sp = scrollPanes.get(x);
			if(x == 0){
				sp.setVisible(true);
			}else{
				sp.setVisible(false);
			}
			
			content.add(sp);
			
			Button b = buttons.get(x);
			b.addListener(new ClickListener(){
				public void clicked (InputEvent event, float x, float y){
					
				}
			});
			tabs.add(b);
			
		}
		
		return tp;
	}
	
	private class TabbedButtonListener extends ClickListener{
		public void clicked (InputEvent event, float x, float y){
			
		}
	}

}
