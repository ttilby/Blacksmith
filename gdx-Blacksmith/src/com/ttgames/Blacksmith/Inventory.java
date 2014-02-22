package com.ttgames.Blacksmith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.OrderedMap;
import com.ttgames.Blacksmith.Items.Item;

public class Inventory implements Serializable {
	
	private Map<Integer, Item> items;
	
	public Inventory(){
		items = new HashMap<Integer, Item>();
	}
	
	public void addItem(Item i){
		items.put(i.getItemID(), i);
	}
	
	public Item getItem(int itemID){
		return items.get(itemID);
	}
	
	public Item removeItem(Item i){
		return items.remove(i.getItemID());
	}
	
	/*public Item removeIndex(int i){
		return items.removeIndex(i);
	}*/
	
	public Item removeItemID(int id){
		return items.remove(id);
	}
	
	public int getSize(){
		return items.size();
	}
	
	public Iterator<Item> iterator(){
		return items.values().iterator();
	}
		
	@Override
	public void write(Json json) {
		json.setElementType(Array.class, "items", Item.class);
		json.writeValue("items", items);
	}

	public void read(Json json, JsonValue jsonData) {
		items = json.readValue("items", HashMap.class, jsonData);
	}
}
