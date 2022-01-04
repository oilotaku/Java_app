package com.example.a20211104;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements OnClickListener, View.OnLongClickListener{
        TextView txv;
        Button btn;
        int counter = 0;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            txv = findViewById(R.id.txv);
            btn = findViewById(R.id.but);
            btn.setOnClickListener(this);
            btn.setOnLongClickListener(this);
            txv.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View view) {
            txv.setText(String.valueOf(++counter));
        }

    @Override
    public boolean onLongClick(View view) {
            if (view.getId() == R.id.txv){
                counter = 0;
                txv.setText("0");
            }
            else{
                txv.setText(String.valueOf(counter+2));
            }

        return true;
    }
}
