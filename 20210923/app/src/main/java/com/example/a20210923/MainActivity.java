package com.example.a20210923;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText fname, sname, number;
    TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.et_Name);
        sname = findViewById(R.id.et_Name_2);
        number = findViewById(R.id.et_Name_3);
        txv = findViewById(R.id.txv);

    }

    public void but(View v){
        txv.setText(sname.getText().toString()+fname.getText().toString()+"的號碼"+
                 number.getText());

    }

}