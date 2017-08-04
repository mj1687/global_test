package com.mj.globaltest;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.widget.CardView;

public class Home extends Activity {

    private Button mTestbutton1;
    private Button mTestbutton2;
    private CardView mTestcard1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        mTestbutton1 = (Button) findViewById(R.id.button_test1);
        mTestbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "activity launched", Toast.LENGTH_SHORT).show();
                Intent backIntent = new Intent(Home.this, Test1.class);
                startActivity(backIntent);
                finish();
            }
        });
        // Test button2 that will do the magic between the activity and the fragment
        mTestbutton2 = (Button) findViewById(R.id.button_test2);
        mTestbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.container_layout);
                TestFragment fg1 = new TestFragment();
                FragmentManager fgManager = getFragmentManager();
                FragmentTransaction fgTransaction = fgManager.beginTransaction();
                fgTransaction.add(R.id.fgcontainer, fg1);
                fgTransaction.commit();
            }
        });
        // Test card that works in the same way of the button2
        mTestcard1 = (CardView) findViewById(R.id.card_test1);
        mTestcard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.container_layout);
                TestFragment fg1 = new TestFragment();
                FragmentManager fgManager = getFragmentManager();
                FragmentTransaction fgTransaction = fgManager.beginTransaction();
                fgTransaction.add(R.id.fgcontainer, fg1);
                fgTransaction.commit();
            }
        });
    }
}
