package S_18_1.s_2_4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * ① 组合@Configuration元注解。
 * ② 组合@ComponentScan元注解。
 * ③ 覆盖value参数。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration//1
@ComponentScan("S_18_1.s_2_4")//2
public @interface Light4JConfiguration {
    String[] value() default {};//3
}
/**import java.lang.annotation.Documented;
 import java.lang.annotation.ElementType;
 import java.lang.annotation.Retention;
 import java.lang.annotation.RetentionPolicy;
 import java.lang.annotation.Target;

 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;

 @Target(ElementType.TYPE)
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 @Configuration //①
 @ComponentScan //②
 public @interface Light4jConfiguration {

 String[] value() default {}; //3

 }
 */