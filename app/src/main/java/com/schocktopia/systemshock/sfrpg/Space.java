package com.schocktopia.systemshock.sfrpg;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import characters.PlayerShip;
import gameLogic.Movement;
import world.WorldObjects;

public class Space extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_space);

		final PlayerShip player = CreatePlayer();

        ClassPickerDialogFragment fm = new ClassPickerDialogFragment();
        fm.show(getFragmentManager(), "class");

        final TextView playerHP = (TextView)findViewById(R.id.player_hp_number_view);
        final TextView playerDPS = (TextView)findViewById(R.id.player_dps_number_view);
        final TextView chosenClass = (TextView)findViewById(R.id.class_name_view);

		chosenClass.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(String.valueOf(chosenClass.getText()).equals("Tactics")){
					player.setPlayerClass("Tactics");
					player.setPlayerHP(200);
					player.setPlayerDPS(100);
					playerHP.setText(String.valueOf(player.getPlayerHP()));
					playerDPS.setText(String.valueOf(player.getPlayerDPS()));
				}else if(String.valueOf(chosenClass.getText()).equals("Engineering")){
					player.setPlayerClass("Engineering");
					player.setPlayerHP(180);
					player.setPlayerDPS(150);
					playerHP.setText(String.valueOf(player.getPlayerHP()));
					playerDPS.setText(String.valueOf(player.getPlayerDPS()));
				}else if(String.valueOf(chosenClass.getText()).equals("Science")) {
					player.setPlayerClass("Science");
					player.setPlayerHP(250);
					player.setPlayerDPS(80);
					playerHP.setText(String.valueOf(player.getPlayerHP()));
					playerDPS.setText(String.valueOf(player.getPlayerDPS()));
				}else{
					playerHP.setText("Nope");
				}
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

        final TableLayout gameMapTable = (TableLayout)findViewById(R.id.space_content_table);
        WorldObjects worldObj = new WorldObjects();

		DrawGameMap(worldObj, gameMapTable);

		/*for(int j = 0; j < 16; j++){
			TableRow row = new TableRow(this);
            TextView tvMapObject = null;
            String s = "";
            for (int i = 0; i < 9; i++) {
                s = String.valueOf(worldObj.getWorldObject());
                tvMapObject = new TextView(this);
                tvMapObject.setTextColor(Color.WHITE);
                tvMapObject.setText(s);
                TableRow.LayoutParams params = new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT,
                        .11f);
                tvMapObject.setLayoutParams(params);
                tvMapObject.setGravity(Gravity.CENTER);
                row.addView(tvMapObject);
                if(i == 4 && j == 13){
                    tvMapObject.setText("M");
                }
            }
			gameMapTable.addView(row);
		}*/

		Button buttonUp = (Button)findViewById(R.id.button_up_arrow);
		Button buttonDown = (Button)findViewById(R.id.button_down_arrow);
		Button buttonLeft = (Button)findViewById(R.id.button_left_arrow);
		Button buttonRight = (Button)findViewById(R.id.button_right_arrow);
		Button buttonOptions = (Button)findViewById(R.id.button_options);

		buttonUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Movement.moveUp(gameMapTable);
			}
		});
		buttonDown.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Movement.moveDown(gameMapTable);
			}
		});
		buttonLeft.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Movement.moveLeft(gameMapTable);
			}
		});
		buttonRight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Movement.moveRight(gameMapTable);
			}
		});
		buttonOptions.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});



        /*
//		TODO: name input check
//		TODO: class input check


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

        scan.close();*/

    }

    public class ClassPickerDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.class_picker_title)
                    .setItems(R.array.class_pick_list, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            TextView chosenClass = (TextView)findViewById(R.id.class_name_view);
                            if(which == 0){
                                chosenClass.setText(R.string.class_tactics);
                            }else if(which == 1){
                                chosenClass.setText(R.string.class_engineering);
                            }else if(which == 2){
                                chosenClass.setText(R.string.class_science);
                            }else{
                                chosenClass.setText(R.string.error_massage);
                            }
                        }
                    });
            return builder.create();
        }
    }

	/*public class FightDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setMessage(R.string.fight_alert)
					.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					}).setNegativeButton("I don't care", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			});

			return builder.create();
		}
	}*/

    protected PlayerShip CreatePlayer(){

        PlayerShip player = new PlayerShip("Jean-Luc Picard", "Science", 200, 100);

        return player;
    }

	protected void DrawGameMap(WorldObjects wo, TableLayout table){
		for(int j = 0; j < 16; j++){
			TableRow row = new TableRow(this);
			TextView tvMapObject = null;
			String s = "";
			for (int i = 0; i < 9; i++) {
				s = String.valueOf(wo.getWorldObject());
				tvMapObject = new TextView(this);
				tvMapObject.setTextColor(Color.WHITE);
				tvMapObject.setText(s);
				TableRow.LayoutParams params = new TableRow.LayoutParams(
						TableRow.LayoutParams.WRAP_CONTENT,
						TableRow.LayoutParams.WRAP_CONTENT,
						.11f);
				tvMapObject.setLayoutParams(params);
				tvMapObject.setGravity(Gravity.CENTER);
				row.addView(tvMapObject);
				if(i == 4 && j == 13){
					tvMapObject.setText("M");
				}
			}
			table.addView(row);
		}
	}
}
