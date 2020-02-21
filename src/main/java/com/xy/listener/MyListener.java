package com.xy.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("启动成功");
        log.info("日志打印地址-" + System.getProperty("catalina.base"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("销毁成功");
    }
}


