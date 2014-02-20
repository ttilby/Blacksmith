package com.ttgames.Blacksmith;

import com.ttgames.Blacksmith.Items.Item;
import com.ttgames.Blacksmith.Items.MetallicMaterial;
import com.ttgames.Blacksmith.Items.Quality;
import com.ttgames.Blacksmith.Items.Type;

public class ValueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		for(Type t : Type.values()){
			for(MetallicMaterial mm : MetallicMaterial.values()){
				for(Quality q : Quality.values()){
					count++;
					
					Item i = new Item(q, mm, t);
					String s = String.format("Item %3d : %-40s", count, i.getName());
					
					System.out.println(s + i.getValue());
				}
				System.out.println("");
			}
			System.out.println("");
		}
		System.out.println("\nTotal: " + count);
	}

}
