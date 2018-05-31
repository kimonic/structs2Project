package S_18_1.s_1_6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * ① initMethod和destroyMethod指定BeanWayService类的init和destroy方法在构造函数之后，
 * Bean销毁之前执行。
 */
@Configuration
@Component("S_18_1.s_1_6")
public class PrePostConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }
    @Bean
    JSP250Service jsp250Service(){
        return new JSP250Service();
    }
}

/**
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;

 @Configuration
 @ComponentScan("org.light4j.sping4.usually.prepost")
 public class PrePostConfig {

 @Bean(initMethod="init",destroyMethod="destroy") //①
 BeanWayService beanWayService(){
 return new BeanWayService();
 }

 @Bean
 JSR250WayService jsr250WayService(){
 return new JSR250WayService();
 }

 }
 */