package com.top.timemonitor;

import android.util.Log;

/**
 * Created by lihaitao on 2018/9/17.
 */
public class BUnit extends IUnit {
    @Override
    void start() {
        super.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    void end() {
        super.end();
        Log.e("TTT","BUnit->end:"+System.currentTimeMillis());
    }
}
