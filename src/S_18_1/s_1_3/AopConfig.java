package S_18_1.s_1_3;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ①使用@EnableAspectJAutoProxy注解开启Spring对AspectJ的支持。
 */
@Configuration
@ComponentScan("S_18_1.s_1_3")
@EnableAspectJAutoProxy
public class AopConfig {
}
/**

 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.EnableAspectJAutoProxy;

 @Configuration
 @ComponentScan("org.light4j.sping4.base.aop")
 @EnableAspectJAutoProxy //①
 public class AopConfig {

 }
 */