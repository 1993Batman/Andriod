package com.example.stevene.metadataviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton chocolate;
    ImageButton cookie;
    ImageButton cocopops;
    ImageButton nuggets;
    TextView date,date2,date3,date4, nuggs, choco, cook, cpop;
    String tempDate;
    Parcelable p1;
    Parcelable p2;
    Parcelable p3;
    Parcelable p4;
    ArrayList<Parcelable> metaData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.NameTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        metaData = new ArrayList<Parcelable>();
        chocolate = (ImageButton) findViewById(R.id.chocolate);
        chocolate.setOnClickListener(this);
        cookie = (ImageButton) findViewById(R.id.cookies);
        cookie.setOnClickListener(this);
        cocopops = (ImageButton) findViewById(R.id.cocopops);
        cocopops.setOnClickListener(this);
        nuggets = (ImageButton) findViewById(R.id.nuggets);
        nuggets.setOnClickListener(this);
        date = (TextView) findViewById(R.id.date1);
        date2 = (TextView) findViewById(R.id.date2);
        date3 = (TextView) findViewById(R.id.date3);
        date4 = (TextView) findViewById(R.id.date4);
        nuggs = (TextView) findViewById(R.id.nuggs);
        choco = (TextView) findViewById(R.id.choco);
        cook = (TextView) findViewById(R.id.cook);
        cpop = (TextView) findViewById(R.id.cpop);
        p1 = new Parcelable();
        p2 = new Parcelable();
        p3 = new Parcelable();
        p4 = new Parcelable();

        try{
            metaData = getIntent().getParcelableArrayListExtra("Parcel");
        } catch (Exception e){
            e.getStackTrace();
        }



        if(metaData == null) {
            tempDate = date.getText().toString();
            p1.setName(choco.getText().toString());
            p1.setLocation("www.chocolate.com");
            p1.setKeyword("Chocolate 101");
            p1.setDate(tempDate);
            p1.setShare(true);
            p1.setEmail("chocolate@cool.com");
            p1.setRating(3);

            p2.setName(cpop.getText().toString());
            p2.setLocation("www.cocopops.com");
            p2.setKeyword("Cocopops 101");
            p2.setDate(tempDate);
            p2.setShare(true);
            p2.setEmail("cocopops@cool.com");
            p2.setRating(3);

            p3.setName(cook.getText().toString());
            p3.setLocation("www.cookies.com");
            p3.setKeyword("Cookies 101");
            p3.setDate(tempDate);
            p3.setShare(true);
            p3.setEmail("cookies@cool.com");
            p3.setRating(3);

            p4.setName(nuggs.getText().toString());
            p4.setLocation("www.nuggets.com");
            p4.setKeyword("Nuggets 101");
            p4.setDate(tempDate);
            p4.setShare(true);
            p4.setEmail("nuggets@cool.com");
            p4.setRating(3);
            metaData = new ArrayList<>();
            metaData.add(p1);
            metaData.add(p2);
            metaData.add(p3);
            metaData.add(p4);
        }
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.chocolate:
                Intent intent = new Intent (this, MetaData.class);
                String send = "choc";
                intent.putParcelableArrayListExtra("Parcel", metaData);
                intent.putExtra("id", send);
                startActivity(intent);
                break;
            case R.id.cocopops:
                Intent intent2 = new Intent (this, MetaData.class);
                String send2 = "coco";
                intent2.putParcelableArrayListExtra("Parcel", metaData);
                intent2.putExtra("id", send2);
                startActivity(intent2);
                break;
            case R.id.cookies:
                Intent intent3 = new Intent (this, MetaData.class);
                String send3 = "cook";
                intent3.putParcelableArrayListExtra("Parcel", metaData);
                intent3.putExtra("id", send3);
                startActivity(intent3);
                break;
            case R.id.nuggets:
                Intent intent4 = new Intent (this, MetaData.class);
                String send4 = "nuggs";
                intent4.putParcelableArrayListExtra("Parcel", metaData);
                intent4.putExtra("id", send4);
                startActivity(intent4);
                break;
        }
    }


}
