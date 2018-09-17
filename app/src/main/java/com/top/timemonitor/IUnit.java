package com.top.timemonitor;

/**
 * Created by lihaitao on 2018/9/17.
 */
public abstract class IUnit {
    public long expireTime;
    private boolean flag=false;
    /**
     * 开始执行
     */
    void start() {
        flag=false;
    }

    /**
     * 结束动作
     */
    void end() {
        flag=true;
    }

    /**
     * 是否结束
     *
     * @return true 已经结束 false 没有结束
     */
    boolean isFinish() {
        return flag;
    }

}
