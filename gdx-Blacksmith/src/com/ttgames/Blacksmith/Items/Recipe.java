package com.ttgames.Blacksmith.Items;

import com.ttgames.Blacksmith.Level;

/*
 * Represents a recipe to create a single item
 */
public class Recipe {
	private String Name;
	private boolean Discovered;
	private boolean Learned;
	private Level level;
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the discovered
	 */
	public boolean isDiscovered() {
		return Discovered;
	}
	/**
	 * @param discovered the discovered to set
	 */
	public void setDiscovered(boolean discovered) {
		Discovered = discovered;
	}
	/**
	 * @return the learned
	 */
	public boolean isLearned() {
		return Learned;
	}
	/**
	 * @param learned the learned to set
	 */
	public void setLearned(boolean learned) {
		Learned = learned;
	}
	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}
	
	
}
