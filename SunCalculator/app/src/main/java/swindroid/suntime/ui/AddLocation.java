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
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class AddLocation extends Activity implements View.OnClickListener {

    EditText name;
    EditText tzone;
    NumberPicker lat;
    NumberPicker _long;
    Button button;
    CheckBox longB;
    CheckBox latB;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addlocation);
        name = (EditText) findViewById(R.id.name);
        tzone = (EditText) findViewById(R.id.timezone);
        lat = (NumberPicker) findViewById(R.id.numberPicker4);
        _long = (NumberPicker) findViewById(R.id.numberPicker3);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        latB = (CheckBox) findViewById(R.id.checkBox2);
        longB = (CheckBox) findViewById(R.id.checkBox);
        lat.setMaxValue(90);
        lat.setMinValue(0);
        _long.setMaxValue(180);
        _long.setMinValue(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, Main.class);
                int x = 0,y = 0;
                if(longB.isSelected()){
                    x = _long.getValue()/-1;
                }else {
                    x = _long.getValue();
                }
                if(latB.isSelected()){
                    y = lat.getValue()/-1;
                }else {
                    y = lat.getValue();
                }
                String FILENAME = "au_locations.txt";
                String string = name.getText()+ ","+ y + "," + x + ","+ tzone.getText();
                try {
                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                    bw.write(string);
                    bw.close();
                    Log.i("test", string);
                } catch (IOException e) {
                    Log.i("test", e.toString());
                }
                startActivity(intent);
                break;
        }
    }



}