package com.haocheng.schedule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 并行执行定时任务
 *
 *      方式一：自定义任务调度线程池
 *
 * @Author: haocheng
 * @Date: 2019-08-27 16:31
 */
@Configuration
@EnableScheduling
public class ScheduleConfig1 implements SchedulingConfigurer {

    private final int POOL_SIZE = 10;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        // 配置线程池大小，根据任务数量定制
        scheduler.setPoolSize(POOL_SIZE);
        // 线程名称前缀
        scheduler.setThreadNamePrefix("spring-scheduler-thread-");
        // 线程池关闭前最大等待时间，确保最后一定关闭
        scheduler.setAwaitTerminationSeconds(60);
        // 线程池关闭时等待所有任务完成
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        // 任务丢弃策略
        scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        //初始化
        scheduler.initialize();

        scheduledTaskRegistrar.setTaskScheduler(scheduler);
    }
}
