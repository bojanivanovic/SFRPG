package gameLogic;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TableLayout;

import com.schocktopia.systemshock.sfrpg.R;
import com.schocktopia.systemshock.sfrpg.Space;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by systemshock on 27/10/2015.
 */
public class Encounters extends Space {

	public void Fight(TableLayout table){
		AlertDialog.Builder builder = new AlertDialog.Builder(table.getContext());
		builder.setMessage(R.string.fight_alert)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});

		AlertDialog dialog = builder.create();
		dialog.show();
	}

	public void VisitPlanet(TableLayout table){
		AlertDialog.Builder builder = new AlertDialog.Builder(table.getContext());
		builder.setMessage(R.string.visit_planet)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});

		AlertDialog dialog = builder.create();
		dialog.show();
	}

	public void TalkToNPC(TableLayout table){
		AlertDialog.Builder builder = new AlertDialog.Builder(table.getContext());
		builder.setMessage(R.string.talk_to_npc)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});

		AlertDialog dialog = builder.create();
		dialog.show();
	}

	public void VisitRepairStation(TableLayout table){
		AlertDialog.Builder builder = new AlertDialog.Builder(table.getContext());
		builder.setMessage(R.string.visit_rep_station)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});

		AlertDialog dialog = builder.create();
		dialog.show();
	}

	public void PickUpWeaponBoost(TableLayout table){
		AlertDialog.Builder builder = new AlertDialog.Builder(table.getContext());
		builder.setMessage(R.string.pick_up_dps_boost)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});

		AlertDialog dialog = builder.create();
		dialog.show();
	}
}
