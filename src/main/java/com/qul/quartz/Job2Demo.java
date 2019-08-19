package com.qul.quartz;


import java.util.Date;


public class Job2Demo {
    public void sayHello() {
        String property = System.getProperty("os.name");
        System.out.println(new Date() + " -> Hello, 我是任务 2 "+property);
    }
}
