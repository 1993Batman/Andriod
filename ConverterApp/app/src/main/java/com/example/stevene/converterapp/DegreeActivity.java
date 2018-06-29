package com.example.stevene.converterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by StevenE on 1/09/2016.
 */
public class DegreeActivity extends AppCompatActivity implements View.OnClickListener{
    public Button back;
    public Button convert;
    public TextView fahrenheit;
    public EditText celsius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.degree_activity);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        convert = (Button) findViewById(R.id.convert);
        convert.setOnClickListener(this);
        fahrenheit = (TextView) findViewById(R.id.fahrenheit);
        celsius = (EditText) findViewById(R.id.celsius);

        String test1;
        double test2;
        if(savedInstanceState != null){
            test2 = savedInstanceState.getDouble("celsius");
            celsius.setText(String.valueOf(test2));
            test1 = savedInstanceState.getString("fahrenheit");
            fahrenheit.setText(test1);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.convert:
                double tempCel;
                String tempCon;
                if (celsius.getText().toString().trim().length() == 0) {
                    tempCel = 0;
                } else {
                    tempCel = Double.parseDouble(celsius.getText().toString());
                }
                tempCon = String.valueOf(tempCel * 1.8 + 32);
                fahrenheit.setText(tempCon + "°F");
                break;

            case R.id.back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putDouble("celsius", Double.parseDouble(celsius.getText().toString()));
        outState.putString("fahrenheit", fahrenheit.getText().toString());
        super.onSaveInstanceState(outState);
    }

}
