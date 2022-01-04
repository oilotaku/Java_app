package com.example.a20211209_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login_btn = findViewById(R.id.login_butten);
        EditText ip_ac = findViewById(R.id.input_passwd);
        EditText ip_pasw = findViewById(R.id.input_passwd);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TEST", ip_ac.getText() + "/" + ip_pasw.getText() + "login_OK");
                Intent intent = new Intent(MainActivity.this, menu.class);
                Bundle bundle = new Bundle();
                bundle.putString("username", ip_ac.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}