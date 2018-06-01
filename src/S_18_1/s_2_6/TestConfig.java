package S_18_1.s_2_6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {
    @Bean
    @Profile("dev")
    public TestBean devTestbean(){
        return new TestBean("from development profile");
    }

    @Bean
    @Profile("prod")
    public TestBean prodTestBean(){
        return new TestBean("from production profile");
    }
}
/**

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.Profile;
 @Configuration
 public class TestConfig {
 @Bean
 @Profile("dev")
 public TestBean devTestBean() {
 return new TestBean("from development profile");
 }

 @Bean
 @Profile("prod")
 public TestBean prodTestBean() {
 return new TestBean("from production profile");
 }

 }
 */