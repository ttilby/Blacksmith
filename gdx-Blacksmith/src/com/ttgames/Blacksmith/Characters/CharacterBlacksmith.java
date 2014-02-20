package com.ttgames.Blacksmith.Characters;

import com.ttgames.Blacksmith.Items.Item;
import com.ttgames.Blacksmith.Items.MetallicMaterial;
import com.ttgames.Blacksmith.Items.Quality;
import com.ttgames.Blacksmith.Items.Type;

public class CharacterBlacksmith extends Character {

	public CharacterBlacksmith() {
		super();
	}
	
	public CharacterBlacksmith(String name) {
		super(name, CharacterJob.Blacksmith);
		
		// Add starter Items
		for(int i = 1; i<=5; i++){
			Item item = new Item(Quality.BASIC, MetallicMaterial.COPPER, Type.RAW);
			inventory.addItem(item);
		}
	}

}
