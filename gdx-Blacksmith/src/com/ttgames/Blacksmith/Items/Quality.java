package com.ttgames.Blacksmith.Items;

public enum Quality {
	
	INGENIOUS (1.5f, "Ingenious"),
	DISTINGUISHED (1.4f, "Distinguished"),
	ADMIRABLE (1.3f, "Admirable"),
	IMPRESSIVE (1.2f, "Impressive"),
	EFFICIENT (1.1f, "Efficient"),
	BASIC (1.0f, "Basic"),
	INEFFICIENT (0.9f, "Inefficient"),
	PETTY (0.8f, "Petty"),
	INSIGNIFICANT (0.7f, "Insignificant"),
	SILLY (0.6f, "Silly"),
	WORTHLESS (0.5f, "Worthless");
	
	
	private final float modifier;
	private final String str;
	
	Quality(float modifier, String str){
		this.modifier = modifier;
		this.str = str;
	}
	
	public float getModifier(){ 
		return modifier; 
	}
	
	public String toString(){
		return str;
	}
	
	public Quality getAverageQuality(Quality... qualities){
		float total = 0f;
		float avg = 0f;
		
		for(Quality q : qualities)
			total += q.getModifier();
		
		avg = total / qualities.length;
		
		for(Quality q : Quality.values()){
			if(q.modifier <= avg) return q;
		}
		
		return Quality.WORTHLESS;
	}
	
}
