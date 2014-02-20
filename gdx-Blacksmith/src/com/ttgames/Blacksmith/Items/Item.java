package com.ttgames.Blacksmith.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Money;

public class Item {
	
	//Dynamic ItemID - Increments for each item created
	private static int counter=1;
	
	private String name;
	private String description;
	//private int value;
	private Money value;
	private int itemID; //each item will be identified by a unique ID /?/
	private Quality quality;
	private MetallicMaterial metallicMaterial;
	private Type type;
	
	public Item() {}
	
	public Item(Quality q, MetallicMaterial mm, Type t){
		this.quality = q;
		this.metallicMaterial = mm;
		this.type = t;
		
		this.name = q.toString() + " " + mm.toString() + " " + t.toString();
		this.description = "A " + t.toString();
		this.value = new Money(MathUtils.ceil(q.getModifier() * mm.getModifier() * t.getValue()));
		this.itemID = counter;
		counter++;
		Gdx.app.log(Blacksmith.LOG, "Item created: " + counter + " " + name);
	}
	
	
//	public Item(int itemID, String name, String desc, int value){
//		this.itemID = itemID;
//		this.name = name;
//		this.description = desc;
//		//this.value = value;
//	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public String toString(){
		return name + " " + description + " :: " + value;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the value
	 */
	public Money getValue() {
		return value;
	}

		
	public int getItemID(){
		return itemID;
	}
	
	public Table getMoneyDisplay(Blacksmith game, Skin skin){
		return value.getMoneyDisplay(game, skin);
	}

	
}
