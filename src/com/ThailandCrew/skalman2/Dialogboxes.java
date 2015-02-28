package com.ThailandCrew.skalman2;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Dialogboxes extends Activity implements OnClickListener {

	private Button btnPizzaName, btnPizzaCrust, btnPizzaSize, btnPizzaTopping;
	private TextView lblPizzaOrder;
	
	private String strOrder = "Current Pizza:", strTopping = "\nTopping: ",
			strName = "Pizza Name: ", strPizzaSize = "\nSize: ",
			strCrust = "\nCrust:";
	private AlertDialog.Builder dialogBuilder;

	public void Display() {
		strOrder = "Current Pizza:\n" + strName + "\n" + strTopping + "\n"
				+ strPizzaSize + "\n" + strCrust;
		lblPizzaOrder.setText(strOrder);
	}

	private void pizzaNameDialog() {

		// TODO Auto-generated method stub
		// variables
		dialogBuilder = new AlertDialog.Builder(this);
		final EditText txtInput = new EditText(this);
		strName = "Pizza Name: ";

		// process
		dialogBuilder.setTitle("Name your Pizza");
		dialogBuilder.setMessage("What is the name of your pizza?");
		dialogBuilder.setView(txtInput);

		dialogBuilder.setPositiveButton("Ok",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						strName += txtInput.getText().toString();

						Display();
						Toast.makeText(getApplicationContext(),
								"Pizza has been named.", Toast.LENGTH_SHORT)
								.show();
						;
					}
				});

		dialogBuilder.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(),
								"Pizza has not been named.", Toast.LENGTH_SHORT)
								.show();

					}
				});
		// output
		AlertDialog dialogPizzaName = dialogBuilder.create();
		dialogPizzaName.show();
	}

	private void pizzaSizeDialog() {

		// variables
		dialogBuilder = new AlertDialog.Builder(this);
		final String[] strSize = { "Small (10\" -6 slices)",
				"Medium (12\",-8 slices)", "Large (12\" - 10 slices)",
				"ExtraLarge (16\" - 12 slices)" };
		strPizzaSize = "\nSize: ";

		// process
		dialogBuilder.setTitle("Select pizza size: ");
		dialogBuilder.setSingleChoiceItems(strSize, -1,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						strPizzaSize += strSize[which];

						Display();
						Toast.makeText(getApplicationContext(),
								"Size of pizza has been determined.",
								Toast.LENGTH_SHORT).show();
					}
				});

		// output
		AlertDialog dialogPizzaSize = dialogBuilder.create();
		dialogPizzaSize.show();
	}

	private void pizzaToppingDialog() {

		// variables
		final ArrayList arrayToppings = new ArrayList();
		dialogBuilder = new AlertDialog.Builder(this);
		final String[] strToppings = { "Chicken", "Pepperoni", "Mushrooms",
				"Onions", "Peppers", "Bacon", "Sausage", "Tomatoes", "Ham",
				"Pineapple" };

		// process
		strTopping = "\nToppings:\n";
		dialogBuilder.setTitle("Pick some toppings");
		dialogBuilder.setMultiChoiceItems(strToppings, null,
				new DialogInterface.OnMultiChoiceClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {

						if (isChecked) {
							arrayToppings.add(which);

						} else if (arrayToppings.contains(which)) {
							arrayToppings.remove(Integer.valueOf(which));
						}
					}

				});
		dialogBuilder.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

						for (int i = 0; i < arrayToppings.size(); i++) {
							int res = (Integer) arrayToppings.get(i);

							strTopping += strToppings[res] + "\t";

						}
						Display();
						Toast.makeText(getApplicationContext(),
								"Toppings has been added.", Toast.LENGTH_SHORT)
								.show();

					}
				});
		dialogBuilder.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(),
								"Toppings has not been added.",
								Toast.LENGTH_SHORT).show();

					}
				});
		// output
		AlertDialog dialogPizzaTopping = dialogBuilder.create();
		dialogPizzaTopping.show();
	}

	public void pizzaCrustDialog() {
		// variables
		SeekBar skbCrust;
		final TextView lblTemperature;
		Button btnOK;
		Button btnCancel;
		strCrust = "\nCrust: ";
		final Dialog dialogCustom = new Dialog(this);

		// process
		dialogCustom.setContentView(R.layout.customdialog);
		dialogCustom.setTitle("Crust Temperature");
		skbCrust = (SeekBar) dialogCustom.findViewById(R.id.skbCrust);
		lblTemperature = (TextView) dialogCustom
				.findViewById(R.id.lblTemperature);
		btnOK = (Button) dialogCustom.findViewById(R.id.btnOK);
		btnCancel = (Button) dialogCustom.findViewById(R.id.btnCancel);

		skbCrust.setProgress(50);
		lblTemperature.append(crustTemperature(skbCrust.getProgress()));
		btnOK.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				strCrust += lblTemperature.getText();

				Toast.makeText(getApplicationContext(),
						"Crust has been determined.", Toast.LENGTH_SHORT)
						.show();
				Display();
				dialogCustom.dismiss();

			}
		});
		btnCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Toast.makeText(getApplicationContext(),
						"Crust has not been determined.", Toast.LENGTH_SHORT)
						.show();
				dialogCustom.dismiss();

			}
		});
		skbCrust.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				lblTemperature.setText(crustTemperature(progress));
			}
		});

		// output
		dialogCustom.show();

	}

	public String crustTemperature(int intProgress) {
		// variables
		String strCrust = "";

		// process
		if (intProgress <= 30)
			strCrust = "Soft Crust - Cooked at " + intProgress + (char) 0x0000
					+ "C";
		else if (intProgress > 30 && intProgress <= 70)
			strCrust = "Crispy Crust - Cooked at " + intProgress
					+ (char) 0x0000 + "C";
		else
			strCrust = "Charred Crust - Cooked at " + intProgress
					+ (char) 0x0000 + "C";
		// ((Output
		return strCrust;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogboxes);
		Dialogboxes();
		Display();

	}

	public void Dialogboxes() {
		// TODO Auto-generated constructor stub
		btnPizzaName = (Button) findViewById(R.id.btnPizzaName);
		btnPizzaCrust = (Button) findViewById(R.id.btnPizzaCrust);
		btnPizzaSize = (Button) findViewById(R.id.btnPizzaSize);
		btnPizzaTopping = (Button) findViewById(R.id.btnPizzaTopping);

		btnPizzaName.setOnClickListener(this);
		btnPizzaCrust.setOnClickListener(this);
		btnPizzaSize.setOnClickListener(this);
		btnPizzaTopping.setOnClickListener(this);

		lblPizzaOrder = (TextView) findViewById(R.id.lblOrder);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.btnPizzaName:
			pizzaNameDialog();
			break;
		case R.id.btnPizzaSize:
			pizzaSizeDialog();
			break;
		case R.id.btnPizzaTopping:
			pizzaToppingDialog();
			break;

		case R.id.btnPizzaCrust:
			pizzaCrustDialog();
			break;
		}
	}

}
