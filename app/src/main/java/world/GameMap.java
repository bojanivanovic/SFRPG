package world;

import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
//	TODO:
	public static List<List<Character>> generateGameMap(int height, int width){
		List<List<Character>> map = new ArrayList<List<Character>>();
		for(int i = 0; i < height; i++){
			map.add(new ArrayList<Character>());
		}
		for(int i = 0; i < map.size(); i++){
			map.get(i).addAll(generateMapLine(width));
		}
		
		return map;
	}
	
	public static List<Character> generateMapLine(int width){
		List<Character> lst = new ArrayList<Character>();
		WorldObjects wo = new WorldObjects();
		for(int i = 0; i < width; i++){
			lst.add(wo.getWorldObject());
		}
		return lst;
	}

	/*public ArrayList<Character> generateTableLayoutRow(int width){
		for(int i = 0; i < width; i++){
			TableRow row = new TableRow();

		}
	}*/
	
	public static void drawMap(List<List<Character>> map){
		for(int i = 0; i < map.size(); i++){
			for(char c: map.get(i)){
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
