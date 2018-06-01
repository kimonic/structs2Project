package S_18_1.s_2_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring4.x高级话题(二):多线程
 * <p>
 * Spring通过任务执行器(TaskExecutor)来实现多线程和并发编程。使用ThreadPoolTaskExecutor可
 * 实现一个基于线程池的TaskExecutor。而实际开发中任务一般是非阻碍的，即异步的，所以我们要
 * 在配置类中通过@EnableAsync开启对异步任务的支持，并通过在实际执行的Bean的方法中使用
 *
 * @Async注解来声明其是一个异步任务。
 */
public class TestS21 {
    public static void main(String[] a) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService service = context.getBean(AsyncTaskService.class);

        for (int i = 0; i < 10; i++) {
            service.executeAsyncTask(i);
            service.executeAsyncTaskPlus(i);
        }
//输出结果表明是并发执行而不是顺序执行的，
        context.close();

    }
}


/**
 * AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
 * <p>
 * AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
 * <p>
 * for(int i =0 ;i<10;i++){
 * asyncTaskService.executeAsyncTask(i);
 * asyncTaskService.executeAsyncTaskPlus(i);
 * }
 * context.close();
 */
