package com.syx.extend;

import com.syx.AbstractLogger;

/**
 * 抽象记录器的实体类
 *
 * @author syx
 * @version 1.0
 * @since 2020/9/28 11:50
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}