package com.example.stevene.converterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MeasureActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText miles;
    public EditText feet;
    public EditText inches;
    public TextView distance;
    public Button calculateDistance;
    public Button goBack;
    public CheckBox checkMeters;
    public String tempValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measure_activity);
        miles = (EditText)findViewById(R.id.miles);
        feet = (EditText)findViewById(R.id.feet);
        inches = (EditText)findViewById(R.id.inches);
        distance = (TextView)findViewById(R.id.distance);
        calculateDistance = (Button)findViewById(R.id.buttonCon);
        calculateDistance.setOnClickListener(this);
        goBack = (Button)findViewById(R.id.goBack);
        goBack.setOnClickListener(this);
        checkMeters = (CheckBox)findViewById(R.id.conMeters);
        String test1;
        double test2,test3, test4;
        boolean test5 = false;

        // This is how we retrieve anything saved in the app's Instance
        if(savedInstanceState != null){
            test2 = savedInstanceState.getDouble("miles");
            miles.setText(String.valueOf(test2));
            test3 = savedInstanceState.getDouble("feet");
            feet.setText(String.valueOf(test3));
            test4 = savedInstanceState.getDouble("inches");
            inches.setText(String.valueOf(test4));
            test5 = savedInstanceState.getBoolean("convert");
            checkMeters.setChecked(test5);
            test1 = savedInstanceState.getString("distance_value");
            if(test5) {
                distance.setText(test1 + "m");
            }else{
                distance.setText(test1 + "mm");
            }
        }



    }


    public void onClick(View v){
        switch (v.getId()) {
            case R.id.buttonCon:
                miles = (EditText) findViewById(R.id.miles);
                feet = (EditText) findViewById(R.id.feet);
                inches = (EditText) findViewById(R.id.inches);
                double tempMiles, tempFeet, tempInches, tempCenMeters, tempMM;
                // This is how we get and set the values so we can convert to meters or millimeters
                // Check to make sure we don't get an empty text field and crash the app
                if(miles.getText().toString().trim().length() == 0){
                    tempMiles = 0;
                } else{
                    tempMiles = Double.parseDouble(miles.getText().toString());
                }
                if(feet.getText().toString().trim().length() == 0){
                    tempFeet = 0 + (tempMiles * 5280);
                } else{
                    tempFeet = Double.parseDouble(feet.getText().toString()) + (tempMiles * 5280);
                }
                if(inches.getText().toString().trim().length() == 0){
                    tempInches = 0 + (tempFeet * 12);
                } else{
                    tempInches = Double.parseDouble(inches.getText().toString()) + (tempFeet * 12);
                }
                tempCenMeters = tempInches * 2.54;
                tempMM = tempCenMeters *10;

                // Checking to see if we need to convert the results to meters or millimeters
                if (checkMeters.isChecked()) {
                    tempValue = String.valueOf(tempCenMeters / 100);
                    distance.setText(tempValue + "m");
                } else {
                    tempValue = String.valueOf(tempMM);
                    distance.setText(tempValue + "mm");
                }
                break;
            case R.id.goBack:
                Intent intent = new Intent (this, MainActivity.class);
                startActivity(intent);
                break;
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putDouble("miles", Double.parseDouble(miles.getText().toString()));
        outState.putDouble("feet", Double.parseDouble(feet.getText().toString()));
        outState.putDouble("inches", Double.parseDouble(inches.getText().toString()));
        if(checkMeters.isChecked()){
            outState.putBoolean("convert", true);
        } else{
            outState.putBoolean("convert", false);
        }
        if(tempValue != null){
            outState.putString("distance_value", tempValue);
        }

        super.onSaveInstanceState(outState);
    }

}
