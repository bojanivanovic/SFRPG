package world;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class WorldObjects {
	private Map<Integer, Character> m = Collections.synchronizedMap(new HashMap<Integer, Character>());
	
	public WorldObjects(){
		this.setMap();
	}
	
	void setMap(){
		this.m.put(1, ' '); //empty
		this.m.put(2, '*'); //planet
		this.m.put(3, '$'); //npc
		this.m.put(4, 'X'); //enemy
		this.m.put(5, 'O'); //repair station
		this.m.put(6, 'o'); //weapons boost
	}
	
	public Map<Integer, Character> getMap(){
		return this.m;
	}
	
	private int getRandomObject(){
		int randNo = (int)(Math.random()*100 + 1);
		int objIdentifier = 0;
		
		if(randNo <= 90){
			objIdentifier = 1;
		}else if(randNo == 91){
			objIdentifier = 5;
		}else if(randNo == 92){
			objIdentifier = 6;
		}else if(randNo > 92 && randNo < 95){
			objIdentifier = 2;
		}else if(randNo == 95){
			objIdentifier = 3;
		}else{
			objIdentifier = 4;
		}
		
		return objIdentifier;
	}
	
	public char getWorldObject(){
		WorldObjects objectsMap = new WorldObjects();
		return objectsMap.getMap().get(getRandomObject());
	}
}
