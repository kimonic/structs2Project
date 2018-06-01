package S_18_1.s_2_1;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * ① 通过@Async注解表明该方法是个异步方法，如果注解在类级别，
 * 则表明该类所有的方法都是异步方法，
 * 而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor。
 */
@Service
public class AsyncTaskService {

    @Async//1
    public void executeAsyncTask(int i){
        System.out.println("执行异步任务:"+i);
    }

    @Async
    public void executeAsyncTaskPlus(int i){
        System.out.println("执行异步任务+1:"+(i+1));
    }
}
/**
 import org.springframework.scheduling.annotation.Async;
 import org.springframework.stereotype.Service;
 @Service
 public class AsyncTaskService {

 @Async //①
 public void executeAsyncTask(Integer i){
 System.out.println("执行异步任务: "+i);
 }

 @Async
 public void executeAsyncTaskPlus(Integer i){
 System.out.println("执行异步任务+1: "+(i+1));
 }
 }
 */