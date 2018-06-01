package S_18_1.s_2_3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * ① 通过@Conditional注解，符合Windows条件则实例化windowsListService。
 * ② 通过@Conditional注解，符合Linux条件则实例化linuxListService。
 */
@Configuration
@ComponentScan("S_18_1.s_2_3")
public class ConditionConfig {
    @Bean
    @Conditional(WindowCondition.class)//1
    public ListService windowListService(){
        return new WindowListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)//2
    public ListService linuxListService(){
        return new LinuxListService();
    }

}
/**

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Conditional;
 import org.springframework.context.annotation.Configuration;

 @Configuration
 public class ConditionConifg {
 @Bean
 @Conditional(WindowsCondition.class) //①
 public ListService windowsListService() {
 return new WindowsListService();
 }

 @Bean
 @Conditional(LinuxCondition.class) //②
 public ListService linuxListService() {
 return new LinuxListService();
 }
 }*/