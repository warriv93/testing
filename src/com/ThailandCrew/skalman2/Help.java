package com.ThailandCrew.skalman2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;

public class Help extends Activity implements View.OnClickListener {
	ImageButton vard1177btn;
	EditText personsEmail, intro, personsName, stupidThings, hatefulAction,
			outro;
	String emailAdd, beginning, name, stupidAction, hatefulAct, out;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);

		findviewbyid();
		vard1177btn.setOnClickListener(this);
		sendEmail.setOnClickListener(this);

	}

	private void findviewbyid() {
		// TODO Auto-generated method stub
		vard1177btn = (ImageButton) findViewById(R.id.vardbtn);
		personsEmail = (EditText) findViewById(R.id.etEmail);
		intro = (EditText) findViewById(R.id.etintro);
		personsName = (EditText) findViewById(R.id.etPerson);
		stupidThings = (EditText) findViewById(R.id.etThings);
		hatefulAction = (EditText) findViewById(R.id.etAction);
		outro = (EditText) findViewById(R.id.etoutro);
		sendEmail = (Button) findViewById(R.id.bSendEmail);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.bSendEmail:
			convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated();
			String emailaddress[] = { emailAdd };
			String message = "Well hello "
					+ name
					+ " I just wanted to say "
					+ beginning
					+ ". Not only that but i hate when you "
					+ stupidAction
					+ ", that just really makes me crazy. I just want to make you "
					+ hatefulAct
					+ ". Welp, that all i wanted to chit-chatter about, oh and"
					+ out
					+ ". Oh also if you get bored you should check out www.google.se"
					+ '\n' + "PS. I think i love you...   ";
			
			//make android device use inner service 
			Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
			emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
			emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I hate you! ");
			emailIntent.setType("plain/text");
			emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
			startActivity(emailIntent);
			break;
		case R.id.vardbtn:
			Uri uri = Uri
					.parse("http://www.1177.se/Skane/Fakta-och-rad/Sjukdomar/Funktionsnedsattning/?ar=True");
			Intent url = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(url);
			break;

		}

	}

	private void convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated() {
		// TODO Auto-generated method stub
		emailAdd = personsEmail.getText().toString();
		beginning = intro.getText().toString();
		name = personsName.getText().toString();
		stupidAction = stupidThings.getText().toString();
		hatefulAct = hatefulAction.getText().toString();
		out = outro.getText().toString();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
