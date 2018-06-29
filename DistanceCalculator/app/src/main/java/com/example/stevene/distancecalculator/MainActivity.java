package com.example.stevene.distancecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText miles;
    public EditText feet;
    public EditText inches;
    public TextView distance;
    public Button calculateDistance;
    public CheckBox checkMeters;
    public String tempValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miles = (EditText)findViewById(R.id.miles);
        feet = (EditText)findViewById(R.id.feet);
        inches = (EditText)findViewById(R.id.inches);
        distance = (TextView)findViewById(R.id.distance);
        calculateDistance = (Button)findViewById(R.id.button);
        calculateDistance.setOnClickListener(this);
        checkMeters = (CheckBox)findViewById(R.id.conMeters);
        String test1;
        double test2,test3, test4;
        boolean test5 = false;
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
            if(test5 && test1 != null) {
                distance.setText(test1 + "m");
            }else if(!test5 && test1 != null){
                distance.setText(test1 + "cm");
            }
        }


    }


    public void onClick(View view){
        miles = (EditText)findViewById(R.id.miles);
        feet = (EditText)findViewById(R.id.feet);
        inches = (EditText)findViewById(R.id.inches);

        double tempMiles = Double.parseDouble(miles.getText().toString());
        double tempFeet = Double.parseDouble(feet.getText().toString())+ (tempMiles * 5280);
        double tempInches = Double.parseDouble(inches.getText().toString()) + (tempFeet * 12);
        double tempCenMeters = 0;
        tempCenMeters = tempInches * 2.54;
        if(checkMeters.isChecked()){
            tempValue = String.valueOf(tempCenMeters / 100);
            distance.setText(tempValue + "m");
        } else{
            tempValue = String.valueOf(tempCenMeters);
            distance.setText(tempValue + "cm");
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
        outState.putString("distance_value", tempValue);
        super.onSaveInstanceState(outState);
    }
}
