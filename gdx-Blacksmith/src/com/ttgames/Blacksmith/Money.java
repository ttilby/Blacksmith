package com.ttgames.Blacksmith;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


public class Money {

	private int value;
	private int gold;
	private int silver;
	private int copper;
	
	public Money() {}
	
	public Money(int initialValue){
		this.value = initialValue;
		split();
	}
	
	public int getValue(){
		return value;
	}
	
	public void deposit(int d){
		value += d;
		split();
	}
	
	public boolean withdrawl(int w){
		if(value <= w){
			value -= w;
			split();
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * Splits the total value into gold, silver, and copper increments
	 * 100 copper = 1 silver
	 * 100 silver = 1 gold
	 */
	private void split(){
		gold = MathUtils.floor(value/1000);
		silver = MathUtils.floor((value-gold)/100);
		copper = value - (gold * 1000) - (silver * 100);
	}
	
	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * @return the silver
	 */
	public int getSilver() {
		return silver;
	}

	/**
	 * @return the copper
	 */
	public int getCopper() {
		return copper;
	}
	
	public Table getMoneyDisplay(Blacksmith game, Skin skin){
		int gold = getGold();
		int silver = getSilver();
		int copper = getCopper();
		
		Table table = new Table(skin);
		table.add(new Image(game.getAssetManager().get("data/images/goldIcon.png", Texture.class)));
		table.add(" " + gold + " ");
		table.add(new Image(game.getAssetManager().get("data/images/silverIcon.png", Texture.class)));
		table.add(" " + silver + " ");
		table.add(new Image(game.getAssetManager().get("data/images/copperIcon.png", Texture.class)));
		table.add(" " + copper + " ");
		
		return table;
	}

		
}
