package S_18_1.s_1_6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * Spring4.x常用配置(三):Bean的初始化和销毁
 *
 * ，经常遇到在Bean之前使用之前或者之后做些必要的操作，
 * Spring对Bean的生命周期的操作提供了支持。在使用Java配置和注解配置下提供如下两种方式：
 *
 * 1. Java配置方式：使用@Bean的initMethod和destroyMethod
 * (相当于xml配置的init-method和destory-method)。
 * 2. 注解方式：利用JSR-250的@PostConstruct和@PreDestroy
 *
 * 构造函数执行后会立即执行init方法
 */
public class TestS16 {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(PrePostConfig.class);
        BeanWayService beanWayService=context.getBean(BeanWayService.class);
        JSP250Service jsp250Service=context.getBean(JSP250Service.class);
        context.close();
    }
}
