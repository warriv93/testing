package com.ThailandCrew.skalman2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	String classes[] = {"MainActivity", "textPlay", "kalender", "photo", "Dialogboxes", "Data"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
	//beroende på vilken pos du klickar så ska en speciell sida öppnas
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String pos = classes[position];
		
		
		try {
			Class start = Class.forName("com.ThailandCrew.skalman2." + pos);
			Intent ourIntent = new Intent(Menu.this, start);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
}
