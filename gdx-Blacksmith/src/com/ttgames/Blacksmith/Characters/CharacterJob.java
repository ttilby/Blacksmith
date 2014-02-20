package com.ttgames.Blacksmith.Characters;

public enum CharacterJob {
	Blacksmith ("Blacksmith"),
	Apprentice ("Apprentice"),
	Wizard ("Wizard"),
	Shopkeeper ("Shopkeeper"),
	Townsman ("Townsman"),
	Merchant ("Merchant"),
	Adventurer ("Adventurer"),
	Miner ("Miner");
	
	private final String str;
	
	CharacterJob(String str){
		this.str = str;
	}
	
	public String toString(){
		return str;
	}
}
