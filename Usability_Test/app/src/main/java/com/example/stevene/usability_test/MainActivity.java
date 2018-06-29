package com.example.stevene.usability_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView text;
    Button next;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        next = (Button) findViewById(R.id.button);
        next.setOnClickListener(this);
        count = 0;
    }

    public void onClick(View view){
        if(count == 0){
            text.setText(R.string.larger);
            text.setTextSize(16);
            count++;
        } else  if(count == 1){
            text.setText(R.string.smaller);
            text.setTextSize(12);
            count++;
        } else  if(count == 2){
            text.setText(R.string.standard);
            text.setTextSize(14);
            count = 0;
        }
    }
}
