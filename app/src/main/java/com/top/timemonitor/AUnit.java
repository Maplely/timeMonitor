package com.top.timemonitor;

import android.util.Log;

/**
 * Created by lihaitao on 2018/9/17.
 */
public class AUnit implements IUnit {
    private static  boolean flag=false;
    long pre=0;
    long time;
    @Override
    public void start() {
        Log.e("TTT","AUnit->start:"+"开始运行");
        flag=false;
        pre=System.currentTimeMillis();
    }

    @Override
    public void end() {
        Log.e("TTT","AUnit->end:"+"结束运行"+(System.currentTimeMillis()-pre));
        flag=true;
    }

    @Override
    public boolean isFinish() {
        return flag;
    }
    public  void setTime(long l){
        time=l;
    }
    @Override
    public long coastTime() {
        return time;
    }

    @Override
    public String getID() {
        return "1";
    }
}
