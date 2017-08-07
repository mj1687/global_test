package com.mj.globaltest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Test1 extends Activity {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1_layout);

        mButton1 = findViewById(R.id.button_1);
        mButton2 = findViewById(R.id.button_2);
        mButton3 = findViewById(R.id.button_3);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Test1.this, "ABC", Toast.LENGTH_SHORT).show();
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Test1.this, "Welcome back", Toast.LENGTH_SHORT).show();
                Intent backIntent = new Intent(Test1.this, Home.class);
                startActivity(backIntent);
                finish();
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
