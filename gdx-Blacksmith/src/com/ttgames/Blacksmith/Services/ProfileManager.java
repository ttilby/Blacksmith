package com.ttgames.Blacksmith.Services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.ttgames.Blacksmith.Blacksmith;
import com.ttgames.Blacksmith.Profile;

public class ProfileManager {

	private  final String DATA_FILE1 = "data/profile1-v1.json";
	private  final String DATA_FILE2 = "data/profile2-v1.json";
	private String DATA_FILE = DATA_FILE1;
	
	private Profile profile;
	
	public ProfileManager() {}
	
	public void setProfileNumber(int num){
		Gdx.app.log(Blacksmith.LOG, "Setting Profile number: " + num);
		if(num == 1) DATA_FILE = DATA_FILE1;
		else if(num == 2) DATA_FILE = DATA_FILE2;
	}
	
	public String getDataFilePath(){
		return DATA_FILE;
	}
	
		
	public Profile retrieveProfile(){
		
		if(profile != null) return profile;
		
		FileHandle profileDataFile = Gdx.files.local(DATA_FILE);
		Gdx.app.log(Blacksmith.LOG, "Retrieving profile from: " + profileDataFile.path());
		
		Json json = new Json();
		
		if(profileDataFile.exists()){
			try{
				String profileAsText = profileDataFile.readString().trim();
				
				//decode
				if(profileAsText.matches("^[A-Za-z0-9/+=]+$")){
					Gdx.app.log(Blacksmith.LOG, "Persisted profile is base64 encoded");
					profileAsText = Base64Coder.decodeString(profileAsText);
				}
				
				profile = json.fromJson(Profile.class, profileAsText);
			} catch (Exception ex) {
				Gdx.app.error(Blacksmith.LOG, "Unable to parse existing profile data file: ", ex);
				
				profile = new Profile();
				
			}
		} else {
			profile = new Profile();  
		}
		
		return profile;
	}
	
	/**
	 * Retrieve a specific profile
	 * used to populate the button text when choosing a profile
	 * @param num
	 * @return
	 */
	public Profile retrieveProfile(int num){
		String dataFile = "";
		Profile p = null;
		if(num == 1){
			dataFile = DATA_FILE1;
		}else if(num == 2){
			dataFile = DATA_FILE2;
		}
		
		FileHandle profileDataFile = Gdx.files.local(dataFile);
		Gdx.app.log(Blacksmith.LOG, "Retrieving profile from: " + profileDataFile.path());
		
		Json json = new Json();
		
		if(profileDataFile.exists()){
			try{
				String profileAsText = profileDataFile.readString().trim();
				
				//decode
				if(profileAsText.matches("^[A-Za-z0-9/+=]+$")){
					Gdx.app.log(Blacksmith.LOG, "Persisted profile is base64 encoded");
					profileAsText = Base64Coder.decodeString(profileAsText);
				}
				
				p = json.fromJson(Profile.class, profileAsText);
			} catch (Exception ex) {
				Gdx.app.error(Blacksmith.LOG, "Unable to parse existing profile data file: ", ex);
			}
		}
		
		return p;
	}
	
	private void persist(Profile profile){
		FileHandle profileDataFile = Gdx.files.local(DATA_FILE);
		Gdx.app.log(Blacksmith.LOG, "Persisting profile in: " + profileDataFile.path());
		
		Json json = new Json();
		
		String profileAsText = json.toJson(profile);
		
		if(!Blacksmith.DEV_MODE){
			profileAsText = Base64Coder.encodeString(profileAsText);
		}
		
		profileDataFile.writeString(profileAsText,false);
	}
	
	public void persist(){
		if(profile != null){
			persist(profile);
		}
	}
}
