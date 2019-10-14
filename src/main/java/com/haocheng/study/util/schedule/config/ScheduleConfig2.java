package com.haocheng.study.util.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 方式二：Bean注解的TaskScheduler或TaskExecutor即可
 *
 * @Author: haocheng
 * @Date: 2019-08-27 17:58
 */
@EnableAsync
@Configuration
public class ScheduleConfig2 {

    @Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        // 配置线程池大小，根据任务数量定制
        scheduler.setPoolSize(10);
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

        return scheduler;
    }


    @Bean
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(20);
        // 配置最大线程数
        executor.setMaxPoolSize(50);
        // 配置缓存队列大小
        executor.setQueueCapacity(100);
        // 空闲线程存活时间
        executor.setKeepAliveSeconds(15);
        // 线程名称前缀
        executor.setThreadNamePrefix("spring-executor-thread-");
        /*
            线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，
            当线程池没有处理能力的时候，该策略会直接在execute方法的调用线程中运行被拒绝的任务；
            如果执行程序已关闭，则会丢弃该任务
        */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是被没有完成的任务阻塞
        executor.setAwaitTerminationSeconds(60);
        // 初始化
        executor.initialize();
        return executor;
    }
}
