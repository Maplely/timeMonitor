package com.top.timemonitor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <pre>
 * <code>
 *  继承{@link IUnit}实现coastTime方法 设置方法监控时长
 *   TimeManager intance = TimeManager.getIntance();
 *   intance.put(IUnit);
 * </code>
 * </pre>
 *
 * @author HighTop
 * @since 2018年09月17日17:09:25
 */
public class TimeManager {

    private static final ConcurrentHashMap<String, IUnit> TT_MAP = new ConcurrentHashMap<>();
    /**
     * 状态 true 运行  false 没有运行
     */
    private static final AtomicBoolean STATUS = new AtomicBoolean(false);
    private static final byte[] LOCK = new byte[0];
    private static volatile long mMinTime = Long.MAX_VALUE;

    private TimeManager() {
    }

    private static class InnerClass {
        static TimeManager instance = new TimeManager();
    }

    /**
     * 单例模式
     */
    public static TimeManager getIntance() {
        return InnerClass.instance;
    }

    public void put(IUnit unit) {
        if (unit == null) {
            return;
        }
        TT_MAP.put(unit.getID(), unit);
        if (unit.coastTime() > 0) {
            //对unit过期时间设置
            long expire = unit.coastTime();
            if (mMinTime > expire) {
                //最短时间更改
                mMinTime = expire;
                synchronized (LOCK) {
                    LOCK.notifyAll();
                }
            }
            if (STATUS.compareAndSet(false, true)) {
                //开启
                new UnitThread().start();
            }
        }

    }

    class UnitThread extends Thread {
        @Override
        public void run() {
            if (!STATUS.get()) {
                return;
            }
            while (mMinTime == Long.MAX_VALUE || TT_MAP.size() > 0) {
                long millions = mMinTime - System.currentTimeMillis();

                if (millions > 0) {
                    synchronized (LOCK) {
                        try {
                            LOCK.wait(millions);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //遍历  停止过期的unit 找到下一个时间点
                long min = Long.MAX_VALUE;
                long now = System.currentTimeMillis();
                for (IUnit unit : TT_MAP.values()) {
                    if (!unit.isFinish()) {
                        //没有停止
                        long time = unit.coastTime();
                        if (time > 0) {
                            if (time - now > 0) {
                                //没有过期
                                min = Math.min(min, time);
                            } else {
                                //过期
                                unit.end();
                            }
                        }
                    } else {
                        //停止

                    }
                }
                mMinTime = min;
            }
            STATUS.set(false);
        }
    }


}
