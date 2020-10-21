package com.syx.extend;

import com.syx.AbstractLogger;

/**
 * 抽象记录器的实体类
 *
 * @author syx
 * @version 1.0
 * @since 2020/9/28 11:49
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}