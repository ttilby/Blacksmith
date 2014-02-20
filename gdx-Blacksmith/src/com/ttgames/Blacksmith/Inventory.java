package com.ttgames.Blacksmith;

import java.util.Iterator;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.OrderedMap;
import com.ttgames.Blacksmith.Items.Item;

public class Inventory implements Serializable {
	
	private Array<Item> items;
	
	public Inventory(){
		items = new Array<Item>();
	}
	
	public void addItem(Item i){
		items.add(i);
	}
	
	public boolean removeItem(Item i){
		return items.removeValue(i, false);
	}
	
	public Item removeIndex(int i){
		return items.removeIndex(i);
	}
	
	public boolean removeItemID(int id){
		for(Item i : items){
			if(i.getItemID() == id) 
				return items.removeValue(i, false);
		}
		
		return false;
	}
	
	public int getSize(){
		return items.size;
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
		items = json.readValue("items", Array.class, jsonData);
	}
}
