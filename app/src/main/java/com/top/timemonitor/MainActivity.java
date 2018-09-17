package com.top.timemonitor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AUnit aUnit = new AUnit();
        BUnit bUnit = new BUnit();
        TimeManager intance = TimeManager.getIntance();
        intance.put(aUnit,1000);
        Log.e("TTT","aaaaaaa"+System.currentTimeMillis());
        intance.put(bUnit,200);
        Log.e("TTT","bbbbbbbbbbb"+System.currentTimeMillis());
    }
}
