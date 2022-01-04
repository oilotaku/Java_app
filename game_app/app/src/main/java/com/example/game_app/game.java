package com.example.game_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class game extends AppCompatActivity
        implements View.OnClickListener {
    int j = 0;
    int i = 0;
    int point = 0;
    Button button;
    Button next;
    TextView tab_txv;
    TextView Q_txv;
    TextView a_1;
    TextView a_2;
    TextView a_3;
    String[] Q;
    String[] tab;
    String[] ans;
    String[] Q_ans = new String[3];
    String true_ans;

    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        button = findViewById(R.id.button);
        next = findViewById(R.id.next_butten);
        tab_txv = findViewById(R.id.tab);
        Q_txv = findViewById(R.id.Q_txv);
        a_1 = findViewById(R.id.a_1);
        a_2 = findViewById(R.id.a_2);
        a_3 = findViewById(R.id.a_3);

        next.setOnClickListener(this);
        button.setOnClickListener(this);
        a_1.setOnClickListener(this);
        a_2.setOnClickListener(this);
        a_3.setOnClickListener(this);
        Q = getResources().getStringArray(R.array.Q);
        tab = getResources().getStringArray(R.array.tab);
        ans = getResources().getStringArray(R.array.ans);

        if (j == Q.length) {
            j = 0;
            i = 0;
            SharedPreferences wire_point = getSharedPreferences("strings", MODE_PRIVATE);
            int read_point = getSharedPreferences("strings", MODE_PRIVATE).getInt("point", 0);
            if (read_point < point) {
                wire_point.edit()
                        .putInt("point", point)
                        .commit();
            }

            Intent play_monita = new Intent(game.this, MainActivity.class);
            startActivity(play_monita);
        } else {
            tab_txv.setText(tab[i]);
            Q_txv.setText(Q[j]);
            String[] Q_ans = new String[3];
            Q_ans[0] = ans[j * 3];
            Q_ans[1] = ans[j * 3 + 1];
            Q_ans[2] = ans[j * 3 + 2];
            true_ans = ans[j * 3];
            Collections.shuffle(Arrays.asList(Q_ans));
            a_1.setText(Q_ans[0]);
            a_2.setText(Q_ans[1]);
            a_3.setText(Q_ans[2]);
        }


    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.button) {
            j = Q.length;
            Intent play_monita = new Intent(game.this, MainActivity.class);
            startActivity(play_monita);
        } else if (v.getId() == R.id.next_butten) {
            j++;
        } else if (v.getId() == R.id.a_1) {
            chack(true_ans, a_1.getText().toString(), j);
            j++;
        } else if (v.getId() == R.id.a_2) {
            chack(true_ans, a_2.getText().toString(), j);
            j++;
        } else if (v.getId() == R.id.a_3) {
            chack(true_ans, a_3.getText().toString(), j);
            j++;
        }

        if (j % 3 == 0) {
            i++;
        }

        if (j >= 15) {
            j = 0;
            i = 0;
            SharedPreferences wire_point = getSharedPreferences("strings", MODE_PRIVATE);
            int read_point = getSharedPreferences("strings", MODE_PRIVATE).getInt("point", 0);
            if (read_point < point) {
                wire_point.edit()
                        .putInt("point", point)
                        .commit();
            }

            Intent play_monita = new Intent(game.this, MainActivity.class);
            startActivity(play_monita);
        } else {
            tab_txv.setText(tab[i]);
            Q_txv.setText(Q[j]);
            Q_ans[0] = ans[j * 3];
            Q_ans[1] = ans[j * 3 + 1];
            Q_ans[2] = ans[j * 3 + 2];
            true_ans = Q_ans[0];
            Collections.shuffle(Arrays.asList(Q_ans));
            a_1.setText(Q_ans[0]);
            a_2.setText(Q_ans[1]);
            a_3.setText(Q_ans[2]);
        }

    }

    public void chack(String ans, String ch, int i) {
        if (ch.equals(ans)) {
            if (i % 3 == 0) {
                point += 4;
            } else if (i % 3 == 1) {
                point += 6;
            } else if (i % 3 == 2) {
                point += 10;
            }
        }
    }

}