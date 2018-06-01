package S_18_1.s_2_1;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;


/**
 * ① 利用@EnableAsync注解开启异步任务支持。
 * ② 配置类实现AsyncConfigurer接口并重写getAsyncExecutor方法，
 * 并返回ThreadPoolTaskExecutor ，这样就获得了一个基于线程池的TaskExecutor。
 */

@Configuration
@ComponentScan("S_18_1.s_2_1")
@EnableAsync//1
public class TaskExecutorConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {//2
        ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
/**

 import java.util.concurrent.Executor;

 import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.scheduling.annotation.AsyncConfigurer;
 import org.springframework.scheduling.annotation.EnableAsync;
 import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
 @Configuration
 @ComponentScan("org.light4j.sping4.senior.taskExecutor")
 @EnableAsync //①
 public class TaskExecutorConfig implements AsyncConfigurer{//②

 @Override
 public Executor getAsyncExecutor() {//②
 ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
 taskExecutor.setCorePoolSize(5);
 taskExecutor.setMaxPoolSize(10);
 taskExecutor.setQueueCapacity(25);
 taskExecutor.initialize();
 return taskExecutor;
 }

 @Override
 public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
 return null;
 }

 }
 */