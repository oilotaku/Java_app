package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txvR, txvG, txvB;
    View colorblock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvR = findViewById(R.id.textView);
        txvG = findViewById(R.id.textView2);
        txvB = findViewById(R.id.textView3);
        colorblock = findViewById(R.id.co);
    }

    public  void change(View v){
        Random r = new Random();
        int red = r.nextInt(256);
        txvR.setText("紅：" + red);
        txvR.setTextColor(Color.rgb(red, 0, 0));
        Random g = new Random();
        int green = g.nextInt(256);
        txvG.setText("綠：" + green);
        txvG.setTextColor(Color.rgb(0, green, 0));
        Random b = new Random();
        int blue = b.nextInt(256);
        txvB.setText("藍：" + blue);
        txvB.setTextColor(Color.rgb(0, 0, blue));

        colorblock.setBackgroundColor(Color.rgb(red, green, blue));
    }

}