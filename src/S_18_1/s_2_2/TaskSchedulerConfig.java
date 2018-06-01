package S_18_1.s_2_2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ① 通过@EnableScheduling注解开启对计划任务的支持。
 */
@Configuration
@ComponentScan("S_18_1.s_2_2")
@EnableScheduling//1
public class TaskSchedulerConfig {
}
/**
 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.scheduling.annotation.EnableScheduling;

 @Configuration
 @ComponentScan("org.light4j.sping4.senior.taskscheduler")
 @EnableScheduling //①
 public class TaskSchedulerConfig {

 }*/