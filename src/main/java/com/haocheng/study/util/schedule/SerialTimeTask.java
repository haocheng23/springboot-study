package com.haocheng.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 串行执行定时任务
 *
 * @Author: haocheng
 * @Date: 2019-08-27 14:37
 */
@Slf4j
@Component
//@EnableScheduling
public class SerialTimeTask {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @Scheduled注解
     *
     * @Scheduled(fixedRate = 5000) ：上一次执行开始时间点之后5秒再执行
     *
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     *
     * @Scheduled(initialDelay=1000, fixedRate=5000) ： 第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次。
     *      initialDelay表示第一次调用前的延时，单位毫秒，必需配合cron、fixedDelay或者fixedRate来使用。
     *
     * @Scheduled(cron="") ：通过cron表达式定义规则，与fixedDelay类似，上次执行完毕后才进行下次调度。
     */

//    @Scheduled(cron = "0/1 * * * * *")
    public void task1(){
        log.info("=====>>>>>使用cron表达式{}", sdf.format(new Date()));
    }

//    @Scheduled(fixedRate = 5000)
    public void task2() {
        log.info("=====>>>>>使用fixedRate{}", sdf.format(new Date()));
    }

//    @Scheduled(fixedDelay = 10000)
    public void task3() {
        log.info("=====>>>>>使用fixedDelay{}", sdf.format(new Date()));
    }

}
