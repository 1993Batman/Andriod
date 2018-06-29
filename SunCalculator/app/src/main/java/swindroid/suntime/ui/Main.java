package swindroid.suntime.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TimeZone;

import swindroid.suntime.R;
import swindroid.suntime.calc.AstronomicalCalendar;
import swindroid.suntime.calc.GeoLocation;
import swindroid.suntime.calc.Locations;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class Main extends Activity implements  OnItemSelectedListener,View.OnClickListener {

    ArrayList<Locations> locations,locations2;
    ArrayList<String> data;
    Spinner list;
    Button button;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        locations = new ArrayList<Locations>();
        locations2 = new ArrayList<Locations>();
        data = new ArrayList<String>();
        list = (Spinner) findViewById(R.id.listView);
        list.setOnItemSelectedListener(this);
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(this);
        try {
            AddLocations();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item ,data );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list.setAdapter(dataAdapter);

        initializeUI();

    }



	private void initializeUI()
	{
		DatePicker dp = (DatePicker) findViewById(R.id.datePicker);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		dp.init(year,month,day,dateChangeHandler);// setup initial values and reg. handler

		updateTime(year, month, day);
	}

	private void updateTime(int year, int monthOfYear, int dayOfMonth)
	{
        String loc;
        loc = list.getSelectedItem().toString();
        int j = 0;
        for (int i = 0; i < locations.size(); i++) {
            if(locations.get(i).get_name().equals(loc)){
                j = i;
                break;
            }
        }
		TimeZone tz = TimeZone.getTimeZone(locations.get(j).get_tzone());
		GeoLocation geolocation = new GeoLocation(locations.get(j).get_name(), locations.get(j).get_long(), locations.get(j).get_lat(), tz);
		AstronomicalCalendar ac = new AstronomicalCalendar(geolocation);
		ac.getCalendar().set(year, monthOfYear, dayOfMonth);
		Date srise = ac.getSunrise();
		Date sset = ac.getSunset();

        String str=locations.get(j).get_tzone();
        String[] split = str.split("/");

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        TextView heading = (TextView) findViewById(R.id.locationTV);
		TextView sunriseTV = (TextView) findViewById(R.id.sunriseTimeTV);
		TextView sunsetTV = (TextView) findViewById(R.id.sunsetTimeTV);
		Log.d("SUNRISE Unformatted", srise+"");

        heading.setText(split[1] + ", " + split[0]);
		sunriseTV.setText(sdf.format(srise));
		sunsetTV.setText(sdf.format(sset));
	}

	OnDateChangedListener dateChangeHandler = new OnDateChangedListener()
	{
		public void onDateChanged(DatePicker dp, int year, int monthOfYear, int dayOfMonth)
		{
			updateTime(year, monthOfYear, dayOfMonth);
		}
	};



    public void AddLocations() throws IOException {
        String str="";
        String[] split;
        int i =0;

        InputStream is = this.getResources().openRawResource(R.raw.au_locations);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null) {
            while ((str = reader.readLine()) != null) {
                split = str.split(",");
                locations.add( new Locations(split[0],  Float.parseFloat(split[1]), Float.parseFloat(split[2]), split[3]));
                data.add(split[0]);
            }
        }
        is.close();

        try{
            BufferedReader test = new BufferedReader(new InputStreamReader(  openFileInput("au_locations.txt")));
            while ((str = test.readLine()) != null) {

                split = str.split(",");

                if(!locations.contains(new Locations(split[0],  Float.parseFloat(split[1]), Float.parseFloat(split[2]), split[3]))){
                    locations.add(new Locations(split[0],  Float.parseFloat(split[1]), Float.parseFloat(split[2]), split[3]));
                    data.add(split[0]);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        initializeUI();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button3:
                Intent intent = new Intent(this, AddLocation.class);
                startActivity(intent);
                break;
        }
    }

    private boolean checkParcel(){
        ArrayList p = getIntent().getParcelableArrayListExtra("Parcel");
        if(p.size() > 0){
            return true;
        }
        return false;
    }


}