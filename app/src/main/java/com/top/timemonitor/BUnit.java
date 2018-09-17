package com.top.timemonitor;

import android.util.Log;

/**
 * Created by lihaitao on 2018/9/17.
 */
public class BUnit implements IUnit {
    private static boolean flag = false;
    long pre=0L;
    long mTime=0L;
    @Override
    public void start() {
        Log.e("TTT", "BUnit->start:" + "开始运行");
        flag = false;
        pre=System.currentTimeMillis();
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void end() {
        long l = System.currentTimeMillis() - pre;
        Log.e("TTT", "BUnit->end:" + "结束运行"+l);
        flag = true;
    }

    @Override
    public boolean isFinish() {
        return flag;
    }
    public void setTime(long t){
        mTime=t;
    }
    @Override
    public long coastTime() {
        return mTime;
    }

    @Override
    public String getID() {
        return "2";
    }
}
