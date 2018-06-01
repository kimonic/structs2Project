package S_18_1.s_2_5;

import S_18_1.s_2_2.TaskSchedulerConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.TaskManagementConfigUtils;

/**
 * 通过观察这些@Enable*注解的源码，发现所有的注解都有一个@Import注解，
 * @ Import是用来导入配置类的，这也就意味着这些自动开
 * 启的实现其实是导入了一些自动配置的Bean。这些导入的配置主要分为以下三种类型：
 */
@Configuration
public class SchedulingConfigruation {
    @Bean(name = TaskManagementConfigUtils.SCHEDULED_ANNOTATION_PROCESSOR_BEAN_NAME)
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public ScheduledAnnotationBeanPostProcessor scheduledAnnotationBeanPostProcessor(){
        return new ScheduledAnnotationBeanPostProcessor();
    }
}
/**
 *   @Bean(name = TaskManagementConfigUtils.SCHEDULED_ANNOTATION_PROCESSOR_BEAN_NAME)
 *     @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
 *     public ScheduledAnnotationBeanPostProcessor scheduledAnnotationProcessor() {
 *         return new ScheduledAnnotationBeanPostProcessor();
 *     }
 */