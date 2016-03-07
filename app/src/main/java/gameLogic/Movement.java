package gameLogic;

import android.graphics.Color;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import world.*;

public class Movement {
	/*public static List<List<Character>> moveUp(List<List<Character>> map){
		map.add(0, GameMap.generateMapLine(map.get(1).size()));
		map.remove(map.size()-1);
		return map;
	}
	public static List<List<Character>> moveDown(List<List<Character>> map){
		map.add((map.size()-1), GameMap.generateMapLine(map.get(1).size()));
		map.remove(0);
		return map;
	}
	public static List<List<Character>> moveLeft(List<List<Character>> map){
		WorldObjects wo = new WorldObjects();
		for(int i = 0; i < map.size(); i++){
			map.get(i).add(0, wo.getWorldObject());
			map.get(i).remove(map.get(i).size()-1);
		}
		return map;
	}
	public static List<List<Character>> moveRight(List<List<Character>> map){
		WorldObjects wo = new WorldObjects();
		for(int i = 0; i < map.size(); i++){
			map.get(i).add((map.get(i).size()-1), wo.getWorldObject());
			map.get(i).remove(0);
		}
		return map;
	}*/

	public static void moveUp(TableLayout table){
		TableRow row = (TableRow)table.getChildAt(table.getChildCount() - 1);
 		table.removeView(row);

		TableRow newRow = new TableRow(table.getContext());
		String s = "";
		WorldObjects wo = new WorldObjects();
		TextView tvMapObject;

		for (int i = 0; i < 9; i++) {
			s = String.valueOf(wo.getWorldObject());
			tvMapObject = new TextView(table.getContext());
			tvMapObject.setTextColor(Color.WHITE);
			tvMapObject.setText(s);
			TableRow.LayoutParams params = new TableRow.LayoutParams(
					TableRow.LayoutParams.WRAP_CONTENT,
					TableRow.LayoutParams.WRAP_CONTENT,
					.11f);
			tvMapObject.setLayoutParams(params);
			tvMapObject.setGravity(Gravity.CENTER);
			newRow.addView(tvMapObject);
		}

		table.addView(newRow, 0);
		CheckEncounter("up", table);
		ShipMove("up", table);
	}

	public static void moveDown(TableLayout table){
		TableRow row = (TableRow)table.getChildAt(0);
		table.removeView(row);

		TableRow newRow = new TableRow(table.getContext());
		String s = "";
		WorldObjects wo = new WorldObjects();
		TextView tvMapObject;

		for (int i = 0; i < 9; i++) {
			s = String.valueOf(wo.getWorldObject());
			tvMapObject = new TextView(table.getContext());
			tvMapObject.setTextColor(Color.WHITE);
			tvMapObject.setText(s);
			TableRow.LayoutParams params = new TableRow.LayoutParams(
					TableRow.LayoutParams.WRAP_CONTENT,
					TableRow.LayoutParams.WRAP_CONTENT,
					.11f);
			tvMapObject.setLayoutParams(params);
			tvMapObject.setGravity(Gravity.CENTER);
			newRow.addView(tvMapObject);
		}

		table.addView(newRow, table.getChildCount()-1);

		CheckEncounter("down", table);
		ShipMove("down", table);
	}

	public static void moveLeft(TableLayout table){
		TableRow tr;
		WorldObjects wo = new WorldObjects();
		String s = "";
		TextView tv;

		for(int i = 0; i < 16; i++){
			tr = (TableRow)table.getChildAt(i);
			tr.removeView(tr.getChildAt(tr.getChildCount()-1));

			s = String.valueOf(wo.getWorldObject());
			tv = new TextView(table.getContext());
			tv.setTextColor(Color.WHITE);
			tv.setText(s);
			TableRow.LayoutParams params = new TableRow.LayoutParams(
					TableRow.LayoutParams.WRAP_CONTENT,
					TableRow.LayoutParams.WRAP_CONTENT,
					.11f);
			tv.setLayoutParams(params);
			tv.setGravity(Gravity.CENTER);
			tr.addView(tv, 0);
		}

		CheckEncounter("left", table);
		ShipMove("left", table);
	}

	public static void moveRight(TableLayout table) {
		TableRow tr;
		WorldObjects wo = new WorldObjects();
		String s = "";
		TextView tv;

		for (int i = 0; i < 16; i++) {
			tr = (TableRow) table.getChildAt(i);
			tr.removeView(tr.getChildAt(0));

			s = String.valueOf(wo.getWorldObject());
			tv = new TextView(table.getContext());
			tv.setTextColor(Color.WHITE);
			tv.setText(s);
			TableRow.LayoutParams params = new TableRow.LayoutParams(
					TableRow.LayoutParams.WRAP_CONTENT,
					TableRow.LayoutParams.WRAP_CONTENT,
					.11f);
			tv.setLayoutParams(params);
			tv.setGravity(Gravity.CENTER);
			tr.addView(tv, tr.getChildCount()-1);
		}

		CheckEncounter("right", table);
		ShipMove("right", table);
	}

	private static void ShipMove(String direction, TableLayout table){

//		redraw ship
		TableRow tr = (TableRow)table.getChildAt(13);
		TextView tv = (TextView)tr.getChildAt(4);
		tv.setText("M");

//		delete prev pos
		TableRow trPrev;
		TextView tvPrev;

		if(direction.equals("up")) {
			trPrev = (TableRow) table.getChildAt(14);
			tvPrev = (TextView) trPrev.getChildAt(4);
			tvPrev.setText(" ");
		}else if(direction.equals("down")){
			trPrev = (TableRow)table.getChildAt(12);
			tvPrev = (TextView)trPrev.getChildAt(4);
			tvPrev.setText(" ");
		}else if(direction.equals("left")){
			trPrev = (TableRow)table.getChildAt(13);
			tvPrev = (TextView)trPrev.getChildAt(5);
			tvPrev.setText(" ");
		}else if(direction.equals("right")){
			trPrev = (TableRow)table.getChildAt(13);
			tvPrev = (TextView)trPrev.getChildAt(3);
			tvPrev.setText(" ");
		}
	}

	private static void CheckEncounter(String direction, TableLayout table){
		TableRow tr = (TableRow)table.getChildAt(13);
		TextView tv = (TextView)tr.getChildAt(4);

		TableRow trNext;
		TextView tvNext;

		Encounters enc = new Encounters();

		if(direction.equals("up")) {
			trNext = (TableRow)table.getChildAt(13);
			tvNext = (TextView)trNext.getChildAt(4);

			switch(String.valueOf(tvNext.getText())){
				case "*":
					enc.VisitPlanet(table);
					break;
				case "$":
					enc.TalkToNPC(table);
					break;
				case "X":
					enc.Fight(table);
					break;
				case "O":
					enc.VisitRepairStation(table);
					break;
				case "o":
					enc.PickUpWeaponBoost(table);
					break;
				default:
					break;
			}
		}else if(direction.equals("down")){
			trNext = (TableRow)table.getChildAt(13);
			tvNext = (TextView)trNext.getChildAt(4);

			switch(String.valueOf(tvNext.getText())){
				case "*":
					enc.VisitPlanet(table);
					break;
				case "$":
					enc.TalkToNPC(table);
					break;
				case "X":
					enc.Fight(table);
					break;
				case "O":
					enc.VisitRepairStation(table);
					break;
				case "o":
					enc.PickUpWeaponBoost(table);
					break;
				default:
					break;
			}
		}else if(direction.equals("left")){
			trNext = (TableRow)table.getChildAt(13);
			tvNext = (TextView)trNext.getChildAt(4);

			switch(String.valueOf(tvNext.getText())){
				case "*":
					enc.VisitPlanet(table);
					break;
				case "$":
					enc.TalkToNPC(table);
					break;
				case "X":
					enc.Fight(table);
					break;
				case "O":
					enc.VisitRepairStation(table);
					break;
				case "o":
					enc.PickUpWeaponBoost(table);
					break;
				default:
					break;
			}
		}else if(direction.equals("right")){
			trNext = (TableRow)table.getChildAt(13);
			tvNext = (TextView)trNext.getChildAt(4);

			switch(String.valueOf(tvNext.getText())){
				case "*":
					enc.VisitPlanet(table);
					break;
				case "$":
					enc.TalkToNPC(table);
					break;
				case "X":
					enc.Fight(table);
					break;
				case "O":
					enc.VisitRepairStation(table);
					break;
				case "o":
					enc.PickUpWeaponBoost(table);
					break;
				default:
					break;
			}
		}
	}
}
