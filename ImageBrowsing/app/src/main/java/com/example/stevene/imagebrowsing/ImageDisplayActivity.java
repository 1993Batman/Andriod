package com.example.stevene.imagebrowsing;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by StevenE on 8/09/2016.
 */
public class ImageDisplayActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView display;
    TextView stringValue;
    Button back;
    String temptImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_display_activity);
        Intent intent = getIntent();
        display = (ImageView) findViewById(R.id.displayImage);
        stringValue = (TextView) findViewById(R.id.getString);
        back = (Button) findViewById(R.id.goBack);
        back.setOnClickListener(this);

        temptImage = intent.getStringExtra("tempImage").trim().toString();

        Log.i("test:", temptImage);
        if(temptImage.equals("chocolate")){
            display.setImageResource(R.drawable.chocolate);
            stringValue.setText(R.string.chocolate);
        }
        if(temptImage.equals("cocopops")){
            display.setImageResource(R.drawable.cocopops);
            stringValue.setText(R.string.coco_pops);
        }
        if(temptImage.equals("chicken_nuggets")){
            display.setImageResource(R.drawable.chicken_nuggets);
            stringValue.setText(R.string.chicken_nuggets);
        }
        if(temptImage.equals("choc_chip_cookies")){
            display.setImageResource(R.drawable.choc_chip_cookies);
            stringValue.setText(R.string.choc_chip);
        }

    }

    public void onClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
