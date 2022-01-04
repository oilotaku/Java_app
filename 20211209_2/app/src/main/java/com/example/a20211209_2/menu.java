package com.example.a20211209_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);
            Button login_btn = findViewById(R.id.butt);

            TextView textViewName = findViewById(R.id.textView);
            Intent intent = getIntent();
            String username = intent.getStringExtra("username");
            textViewName.setText("Hi, " + username);
            

            login_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(menu.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }
}
