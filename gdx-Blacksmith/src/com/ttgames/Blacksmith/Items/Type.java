package com.ttgames.Blacksmith.Items;

public enum Type {
	
	RAW ("(Raw)", 2),
	REFINED ("Ingot", 2),
	
	POT ("Pot", 8),
	
	HANDLE ("Handle", 2),
	CROSSGUARD ("Crossguard", 4),
	BLADE ("Blade", 4),
	
	SWORD ("Sword", 20);
	
	
	
	private final String name;
	private final float value;
	
	Type(String name, float value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public float getValue(){
		return value;
	}
	
	public String toString(){
		return name;
	}
}
