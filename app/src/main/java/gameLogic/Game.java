/*
package gameLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import characters.*;

import world.*;

public class Game {

	public static void main(String[] args) {
		boolean gameRunning = true;
		Scanner scan = new Scanner(System.in);
		PlayerShip player = new PlayerShip();

		System.out.println("Hello Captain! Ready to go where no man has gone before?");
		System.out.println("Please input your name: ");
		player.setPlayerName(scan.nextLine());
//		TODO: name input check
		System.out.println("Choose a class: \n1) Tactics\n2) Engineering\n3) Science");
		player.setPlayerClass(scan.nextInt());
		
//		TODO: class input check
		if(player.getPlayerClass().equals("Tactics")){
			player.setPlayerHP(200);
			player.setPlayerDPS(100);
		}else if(player.getPlayerClass().equals("Engineering")){
			player.setPlayerHP(180);
			player.setPlayerDPS(150);
		}else if(player.getPlayerClass().equals("Science")){
			player.setPlayerHP(250);
			player.setPlayerDPS(80);
		}
		
		System.out.println("Character\nName: " + player.getPlayerName() +
				"\nClass: " + player.getPlayerClass() +
				"\nHP: " + player.getPlayerHP() +
				"\nDPS: " + player.getPlayerDPS());

		List<List<Character>> gameMap = new ArrayList<List<Character>>();
		gameMap = GameMap.generateGameMap(11, 9);
		
		GameMap.drawMap(gameMap);
		
		do{
//			TODO: switch input from string scan to actual keys
			System.out.println("Enter a direction: ");
			String tmp = scan.next();
			if(tmp.equals("w")){
				Movement.moveUp(gameMap);
				GameMap.drawMap(gameMap);
			}else if(tmp.equals("s")){
				Movement.moveDown(gameMap);
				GameMap.drawMap(gameMap);
			}else if(tmp.equals("a")){
				Movement.moveLeft(gameMap);
				GameMap.drawMap(gameMap);
			}else if(tmp.equals("d")){
				Movement.moveRight(gameMap);
				GameMap.drawMap(gameMap);
			}else{
				gameRunning = false;
			}
		}while(gameRunning);
		
		scan.close();
	}

}
*/
