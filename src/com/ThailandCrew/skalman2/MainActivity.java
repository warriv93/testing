package com.ThailandCrew.skalman2;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.os.Build;

public class MainActivity extends Activity implements View.OnClickListener {
	ImageButton help;
	ImageButton kalender;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findviewbyid();

		kalender.setOnClickListener(this);
		help.setOnClickListener(this);
	}

	private void findviewbyid() {
		// TODO Auto-generated method stub
		kalender = (ImageButton) findViewById(R.id.kalenderbtn);
		help = (ImageButton) findViewById(R.id.helpbtn);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.kalenderbtn:

			break;
		case R.id.helpbtn:
			try {
				Class start = Class.forName("com.ThailandCrew.skalman2.Help");
				Intent helppage = new Intent(MainActivity.this, start);
				startActivity(helppage);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

}
