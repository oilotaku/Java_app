package com.example.game_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play_butten = findViewById(R.id.play_butten);
        Button clear_butten = findViewById(R.id.button2);
        TextView point_text = findViewById(R.id.point_text);

        int read_point = getSharedPreferences("strings", MODE_PRIVATE).getInt("point", 0);

        point_text.setText("歷史最高得分:" + Integer.parseInt(String.valueOf(read_point)));

        play_butten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play_monita = new Intent(MainActivity.this, game.class);
                startActivity(play_monita);

            }
        });

        clear_butten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences wire_point = getSharedPreferences("strings", MODE_PRIVATE);
                int point = 0;
                wire_point.edit()
                        .putInt("point", point)
                        .commit();
                int read_point = getSharedPreferences("strings", MODE_PRIVATE).getInt("point", 0);
                point_text.setText("歷史最高得分:" + Integer.parseInt(String.valueOf(read_point)));
            }
        });


    }
}