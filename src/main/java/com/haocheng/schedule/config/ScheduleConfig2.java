package com.haocheng.schedule.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 并行执行定时任务
 *
 * 方式二：自定义异步调用线程池
 *
 * @Author: haocheng
 * @Date: 2019-08-27 17:31
 */
@Slf4j
@EnableAsync
@EnableScheduling
@Configuration
public class ScheduleConfig2 implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
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

    /**
     * 处理异步方法的异常
     *
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SpringAsyncExceptionHandler();
    }

    class SpringAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.error("Exception occurs in async method", throwable);
        }
    }
}
