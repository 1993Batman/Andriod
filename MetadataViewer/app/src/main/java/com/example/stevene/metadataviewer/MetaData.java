package com.example.stevene.metadataviewer;

/**
 * Created by StevenE on 22/09/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

public class MetaData extends AppCompatActivity implements View.OnClickListener {

    EditText name;
    EditText location;
    EditText keywords;
    EditText date;
    CheckBox share;
    EditText email;
    EditText rating;
    ImageView image;
    ArrayList<Parcelable> metaData;
    String id;
    int i;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.metadata);
        name = (EditText) findViewById(R.id.name);
        location = (EditText) findViewById(R.id.url);
        keywords = (EditText) findViewById(R.id.keywords);
        date = (EditText) findViewById(R.id.date);
        share = (CheckBox) findViewById(R.id.shareId);
        email = (EditText) findViewById(R.id.email);
        rating = (EditText) findViewById(R.id.rating);
        image = (ImageView) findViewById(R.id.image);

        bundle = getIntent().getExtras();
        metaData = getIntent().getParcelableArrayListExtra("Parcel");
        id = bundle.getString("id");


        if(id.equals("choc")){
            image.setImageResource(R.drawable.chocolate);
            name.setText(metaData.get(0).getName());
            location.setText(metaData.get(0).getLocation());
            keywords.setText(metaData.get(0).getKeyword());
            date.setText(metaData.get(0).getDate());
            share.setChecked(metaData.get(0).getShare());
            email.setText(metaData.get(0).getEmail());
            rating.setText(String.valueOf(metaData.get(0).getRating()));
            i =0;
        } else if(id.equals("coco")){
            image.setImageResource(R.drawable.cocopops);
            name.setText(metaData.get(1).getName());
            location.setText(metaData.get(1).getLocation());
            keywords.setText(metaData.get(1).getKeyword());
            date.setText(metaData.get(1).getDate());
            share.setChecked(metaData.get(1).getShare());
            email.setText(metaData.get(1).getEmail());
            rating.setText(String.valueOf(metaData.get(1).getRating()));
            i =1;

        }else if(id.equals("cook")){
            image.setImageResource(R.drawable.choc_chip_cookies);
            name.setText(metaData.get(2).getName());
            location.setText(metaData.get(2).getLocation());
            keywords.setText(metaData.get(2).getKeyword());
            date.setText(metaData.get(2).getDate());
            share.setChecked(metaData.get(2).getShare());
            email.setText(metaData.get(2).getEmail());
            rating.setText(String.valueOf(metaData.get(2).getRating()));
            i =2;

        }else if(id.equals("nuggs")){
            image.setImageResource(R.drawable.chicken_nuggets);
            name.setText(metaData.get(3).getName());
            location.setText(metaData.get(3).getLocation());
            keywords.setText(metaData.get(3).getKeyword());
            date.setText(metaData.get(3).getDate());
            share.setChecked(metaData.get(3).getShare());
            email.setText(metaData.get(3).getEmail());
            rating.setText(String.valueOf(metaData.get(3).getRating()));
            i =3;

        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, MainActivity.class);
                metaData.get(i).setName(name.getText().toString());
                metaData.get(i).setLocation(location.getText().toString());
                metaData.get(i).setKeyword(keywords.getText().toString());
                metaData.get(i).setDate(date.getText().toString());
                metaData.get(i).setShare(share.isChecked());
                metaData.get(i).setEmail(email.getText().toString());
                metaData.get(i).setRating(Integer.parseInt(rating.getText().toString()));
                intent.putParcelableArrayListExtra("Parcel", metaData);
                String sent = "sent";
                intent.putExtra("sent", sent);
                startActivity(intent);
                break;
        }
    }
}