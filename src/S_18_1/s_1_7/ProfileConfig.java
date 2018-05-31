package S_18_1.s_1_7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * ① Profile为dev时实例化devDemoBean
 * ② Profile为prod时实例化prodDemoBean
 */
@Configuration
public class ProfileConfig {
    @Bean
    @Profile("dev")//1
    public S17Demo devBean(){
        return new S17Demo("from development profile");
    }
    @Bean
    @Profile("prod")///2
    public S17Demo prodBean(){
        return new S17Demo("from production profile");
    }
}
/**
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.Profile;

 @Configuration
 public class ProfileConfig {
 @Bean
 @Profile("dev") //①
 public DemoBean devDemoBean() {
 return new DemoBean("from development profile");
 }

 @Bean
 @Profile("prod") //②
 public DemoBean prodDemoBean() {
 return new DemoBean("from production profile");
 }
 }
 */