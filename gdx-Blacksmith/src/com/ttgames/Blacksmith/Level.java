package com.ttgames.Blacksmith;

public class Level {
	private int experiencePoints;
	private int experiencePointsNeededForNextLevel;
	private int currentLevel;
	private LevelType Type;
	
	public enum LevelType {
		Character,
		Skill,
		Item,
		Reputation,
		Satisfaction
	}
	
	public Level(){
		this.experiencePoints = 0;
		this.currentLevel = 0;
		this.experiencePointsNeededForNextLevel = 0;
		this.Type = LevelType.Character;
	}

	
	public Level(LevelType type){
		this.experiencePoints = 0;
		this.currentLevel = 0;
		this.Type = type;
		LevelUp();
	}
	
	public void AddExperiencePoints(int points){
		experiencePoints += points;
		if (experiencePoints >= experiencePointsNeededForNextLevel){
			LevelUp();
		}
	}
	
	public int getCurrentLevel(){
		return currentLevel;
	}
	
	private void LevelUp(){
		currentLevel++;
		experiencePointsNeededForNextLevel = 100 * currentLevel * currentLevel;
		
	}
	
	public int getExperiencePoints(){
		return experiencePoints;
	}
	
	public int getExperiencePointsNeededForNextLevel(){
		return experiencePointsNeededForNextLevel;
	}
	
}
