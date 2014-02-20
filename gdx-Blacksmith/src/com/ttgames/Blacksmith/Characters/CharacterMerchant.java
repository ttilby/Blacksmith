package com.ttgames.Blacksmith.Characters;

import com.ttgames.Blacksmith.Items.Item;
import com.ttgames.Blacksmith.Items.MetallicMaterial;
import com.ttgames.Blacksmith.Items.Quality;
import com.ttgames.Blacksmith.Items.Type;

public class CharacterMerchant extends Character {

	public CharacterMerchant() {
		super();
	}

	public CharacterMerchant(String name) {
		super(name, CharacterJob.Merchant);
		
		inventory.addItem(new Item(Quality.BASIC, MetallicMaterial.COPPER, Type.RAW));
		inventory.addItem(new Item(Quality.WORTHLESS, MetallicMaterial.COPPER, Type.POT));
		inventory.addItem(new Item(Quality.PETTY, MetallicMaterial.IRON, Type.SWORD));
		
		money.deposit((int) Math.ceil(Math.random() * 300 + 100)); //deposit a random amount between 100-400		
	}

}
