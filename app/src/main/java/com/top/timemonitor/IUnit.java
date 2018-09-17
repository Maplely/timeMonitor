package com.top.timemonitor;

/**
 * Created by lihaitao on 2018/9/17.
 */
public interface IUnit {
    /**
     * 开始执行
     */
    void start();

    /**
     * 结束动作
     */
    void end();

    /**
     * 是否结束
     * @return true 已经结束 false 没有结束
     */
    boolean isFinish();

    /**
     * 过期时间
     * @return 过期的时间 单位ms
     */
    long coastTime();

    /**
     * 唯一标识
     * @return unitID
     */
    String getID();
}
