package S_18_1.s_2_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 从Spring3.1开始，计划任务在Spring中的实现变得异常的简单。
 * 首先通过在配置类注解@EnableScheduling来开启计划任务的支持，
 * 然后在要执行计划任务的方法上注解@Scheduled来声明这是一个计划任务。
 *
 * Spring通过@Scheduled支持多种类型的计划任务，包含cron,fixDelay,fixRate等。
 */
public class TestS22 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context
                =new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
