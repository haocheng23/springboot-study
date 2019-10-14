package com.haocheng.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: haocheng
 * @Date: 2019-08-27 17:07
 */
@Slf4j
@Component
public class ParallelTimeTask {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0/1 * * * * ?")
    public void taskAAA() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " | taskAAA " + SDF.format(new Date()));
//        Thread.sleep(4000);
    }

    @Async
    @Scheduled(cron = "0/2 * * * * ?")
    public void taskBBB() {
        System.out.println(Thread.currentThread().getName() + " | taskBBB " + SDF.format(new Date()));
    }
}
