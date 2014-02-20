package com.ttgames.Blacksmith.Items;

public enum MetallicMaterial {

	STEEL (3f, "Steel"),
	IRON (2f, "Iron"),
	COPPER (1f, "Copper");
	
	private final float modifier;
	private final String str;
	
	MetallicMaterial(float modifier, String str){
		this.modifier = modifier;
		this.str = str;
	}
	
	public float getModifier(){ 
		return modifier; 
	}
	
	public String toString(){
		return str;
	}
}
