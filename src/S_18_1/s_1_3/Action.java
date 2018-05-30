package S_18_1.s_1_3;

import java.lang.annotation.*;

/**
 * 注解本身是没有任何功能的，就和xml是一样的。注解和xml都是一种元数据，
 * 元数据即解释数据的数据，这就是所谓的配置。
 *
 *  编写拦截规则的注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
/**

 import java.lang.annotation.Documented;
 import java.lang.annotation.ElementType;
 import java.lang.annotation.Retention;
 import java.lang.annotation.RetentionPolicy;
 import java.lang.annotation.Target;

 @Target(ElementType.METHOD)
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 public @interface Action {
 String name();
 }*/