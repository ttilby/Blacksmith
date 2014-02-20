package com.ttgames.Blacksmith;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.OrderedMap;
import com.ttgames.Blacksmith.Characters.Character;
import com.ttgames.Blacksmith.Characters.CharacterBlacksmith;
import com.ttgames.Blacksmith.Characters.CharacterMerchant;
import com.ttgames.Blacksmith.Services.NameGenerator;

public class Profile implements Serializable {

	/*
	 * (non-Javadoc)
	 * @see com.badlogic.gdx.utils.Json.Serializable#write(com.badlogic.gdx.utils.Json)
	 * 
	 * This class will hold all the information for a given Player (Characters, items, skills, etc.)
	 * When the data is to be saved, this class will be written out. To restore, the file on disk is
	 * read back into the program.
	 */
	
	private String smithyName; // Name of the Smithy
	private Character blacksmith;
	private Character merchant1;
	//private Character apprentice1, apprentice2, apprentice3;
	//private Character shopkeeper1, shopkeeper2, shopkeeper3;
	//private Character wizard;
	
	//private List RecipeList;


	public Profile() {
		smithyName = "Smithy";
		blacksmith = new CharacterBlacksmith(NameGenerator.getRomanName());
	}
	
		
	public void setSmithyName(String name){
		this.smithyName = name;
	}
	
	public String getSmithyName(){
		return smithyName;
	}
	
	public Character getBlackSmith(){
		if(blacksmith == null) blacksmith = new CharacterBlacksmith("Jim");
		return blacksmith;
	}
	
	public Character getMerchantCharacter(){
		if(merchant1 == null) merchant1 = new CharacterMerchant(NameGenerator.getRomanName());
		return merchant1;
	}
	
	@Override
	public void write(Json json) {
		json.writeValue("smithyName", smithyName);
		json.writeValue("blacksmith", blacksmith, Character.class);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		smithyName = json.readValue("smithyName", String.class, jsonData);
		blacksmith = json.readValue("blacksmith", Character.class, jsonData);
	}

}
