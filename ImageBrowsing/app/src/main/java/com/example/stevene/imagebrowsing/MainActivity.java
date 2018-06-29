package com.example.stevene.imagebrowsing;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton chocolate;
    ImageButton cookie;
    ImageButton cocopops;
    ImageButton nuggets;
    String tempImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chocolate = (ImageButton) findViewById(R.id.chocolate);
        chocolate.setOnClickListener(this);
        cookie = (ImageButton) findViewById(R.id.choc_chip_cookies);
        cookie.setOnClickListener(this);
        cocopops = (ImageButton) findViewById(R.id.cocopops);
        cocopops.setOnClickListener(this);
        nuggets = (ImageButton) findViewById(R.id.chicken_nuggets);
        nuggets.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.chocolate:
                Intent intent = new Intent(this, ImageDisplayActivity.class);
                tempImage = "chocolate";
                intent.putExtra("tempImage", tempImage);
                startActivity(intent);
                break;

            case R.id.choc_chip_cookies:
                Intent intent2 = new Intent(this, ImageDisplayActivity.class);
                tempImage = "choc_chip_cookies";
                intent2.putExtra("tempImage", tempImage);
                startActivity(intent2);
                break;
            case R.id.cocopops:
                Intent intent3 = new Intent(this, ImageDisplayActivity.class);
                tempImage = "cocopops";
                intent3.putExtra("tempImage", tempImage);
                startActivity(intent3);
                break;
            case R.id.chicken_nuggets:
                Intent intent4 = new Intent(this, ImageDisplayActivity.class);
                tempImage = "chicken_nuggets";
                intent4.putExtra("tempImage", tempImage);
                startActivity(intent4);
                break;
        }
    }
}
