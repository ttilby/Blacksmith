package com.ttgames.Blacksmith;

import com.ttgames.Blacksmith.Level.LevelType;

public class LevelTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level l = new Level(LevelType.Character);
		int points = 0;
		int count = 1;
		int prevLevel;
		while (l.getCurrentLevel() < 10) {
			prevLevel = l.getCurrentLevel();
			points = (int)(50 + Math.random() * 50);
			l.AddExperiencePoints(points);
			count++;
			
			if(prevLevel != l.getCurrentLevel()){
				System.out.println("Count=" + count + ", Experience=" + l.getExperiencePoints() + ", Level=" + l.getCurrentLevel());
				count = 1;
			}
			
			
		}
		System.out.println("Done");
	}

}
