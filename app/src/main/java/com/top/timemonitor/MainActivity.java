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
        aUnit.setTime(System.currentTimeMillis()+500);
        BUnit bUnit = new BUnit();
        bUnit.setTime(System.currentTimeMillis()+300);
        TimeManager intance = TimeManager.getIntance();
        intance.put(aUnit);
        Log.e("TTT","MainActivity->onCreate:"+System.currentTimeMillis());
        intance.put(bUnit);
        Log.e("TTT","MainActivity->onCreate:"+System.currentTimeMillis());
    }
}
