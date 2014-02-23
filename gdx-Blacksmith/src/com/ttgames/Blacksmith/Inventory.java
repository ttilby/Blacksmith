package com.ttgames.Blacksmith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.ttgames.Blacksmith.Items.Item;

public class Inventory implements Serializable {
	
	private List<Item> items;
	
	public Inventory(){
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item i){
		items.add(i);
	}
	
	public Item getItem(int itemID){
		for(Item item : items){
			if(item.getItemID() == itemID){
				return item;
			}
		}
		return null;
	}
	
	public boolean removeItem(Item i){
		return items.remove(i);
	}

	public boolean removeItemID(int id){
		Gdx.app.log(Blacksmith.LOG, "removing item: " + id);
		Gdx.app.log(Blacksmith.LOG, items.getClass().toString());
		for(Item item : items){
			if (item.getItemID() == id){
				items.remove(item);
				return true;
			}
		}
		return false;
	}
	
	public int getSize(){
		return items.size();
	}
	
	public Iterator<Item> iterator(){
		return items.iterator();
	}
		
	@Override
	public void write(Json json) {
		json.setElementType(Array.class, "items", Item.class);
		json.writeValue("items", items);
	}

	public void read(Json json, JsonValue jsonData) {
		items = json.readValue("items", ArrayList.class, jsonData);
	}
}
