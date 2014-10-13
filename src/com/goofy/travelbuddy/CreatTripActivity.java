package com.goofy.travelbuddy;

import org.apache.http.NameValuePair;

import com.goofy.travelbuddy.connection.ClientManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatTripActivity extends Activity implements View.OnClickListener{
	private Button createBtn;
	private Button cancelBtn;
	private EditText nameInput;
	private EditText descriptionInput;
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_trip_activity);
		this.createBtn = (Button)findViewById(R.id.btn_create_trip);
		createBtn.setOnClickListener(this);
		this.cancelBtn = (Button)findViewById(R.id.btn_cancel_create_trip);
		cancelBtn.setOnClickListener(this);
		this.descriptionInput = (EditText)findViewById(R.id.et_trip_description);
		this.nameInput = (EditText)findViewById(R.id.et_trip_name);
		this.context = this;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == this.createBtn.getId()) {
			String description = this.descriptionInput.getText().toString();
			String name = this.nameInput.getText().toString();
			boolean validState = true;
			
			if (description == null || description == "") {
				Toast.makeText(getBaseContext(), "Plese enter a description", Toast.LENGTH_LONG).show();
				validState = false;
			}
			else if(name == null || name == ""){
				Toast.makeText(getBaseContext(), "Plese enter a name", Toast.LENGTH_LONG).show();
				validState = false;
			}
			
			if (validState) {
				new CreateTripTask().execute(description, name);
			}
		}
		else if(v.getId() == this.cancelBtn.getId()){
			Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
		}
	}

	private class CreateTripTask extends AsyncTask<String, Void, NameValuePair> {

		@Override
		protected NameValuePair doInBackground(String... data) {
			String name = data[1];
			String description = data[0];
			ClientManager manager = new ClientManager(context);
    		NameValuePair responce = manager.addTrip(name, description);
        	return responce;
		}

		@Override
		protected void onPostExecute(NameValuePair result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
	}
}