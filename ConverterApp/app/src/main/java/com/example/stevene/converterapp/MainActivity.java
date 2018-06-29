package com.example.stevene.converterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button measure;
    public Button degree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        measure = (Button) findViewById(R.id.measure);

        degree = (Button) findViewById(R.id.degree);

        setContentView(R.layout.activity_main);
    }

    // If you want to go to the degrees side of the app
    public void toDegree (View view){
        Intent intent = new Intent (this, DegreeActivity.class);
        startActivity(intent);
    }

    // If you want to go to the measure side of the app
    public void toMeasure (View view){
        Intent intent2 = new Intent (this, MeasureActivity.class);
        startActivity(intent2);
    }
}
