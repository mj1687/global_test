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

    private String FGRAGMENT_1 = "fragment_1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        mTestbutton1 = findViewById(R.id.button_test1);
        mTestbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "activity launched", Toast.LENGTH_SHORT).show();
                Intent backIntent = new Intent(Home.this, Test1.class);
                startActivity(backIntent);
            }
        });
        // Test card that works in the same way of the button2
        mTestcard1 = findViewById(R.id.card_test1);
        mTestcard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.container_layout);
                TestFragment fg1 = new TestFragment();
                FragmentManager fmanager = getFragmentManager();
                FragmentTransaction ftransaction = fmanager.beginTransaction();
                fmanager.beginTransaction();
                ftransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ftransaction.replace(R.id.fgcontainer, fg1, FGRAGMENT_1);
                ftransaction.addToBackStack(fg1.getClass().getName());
                ftransaction.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        FragmentManager fmanager = getFragmentManager();
        FragmentTransaction ftransaction = fmanager.beginTransaction();
        TestFragment fg1 = new TestFragment();

        if (fmanager.getBackStackEntryCount() > 0) {
            ftransaction.remove(fg1);
            ftransaction.commit();
            Intent homeIntent = new Intent(Home.this, Home.class);
            startActivity(homeIntent);
        } else {
            super.onBackPressed();
        }
    }
}