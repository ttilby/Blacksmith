package com.ttgames.Blacksmith;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
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

	public Item removeItemID(int id){
		Gdx.app.log(Blacksmith.LOG, "removing item: " + id);
		Gdx.app.log(Blacksmith.LOG, items.getClass().toString());
		if(items.containsKey(Integer.valueOf(id))){
			Gdx.app.log(Blacksmith.LOG, "has item : " + id);
		}else{
			Gdx.app.error(Blacksmith.LOG, "no item: " + id + " :: items-->" + items.keySet().toString());
		}
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
