package S_18_1.s_2_7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("S_18_1.s_2_7")
public class BookConfig {
    @Bean
    MyDataSource myDataSource(){
        return new MyDataSource(new DriverManagerDataSource(
                "jdbc:mysql://localhost:3306/test?serverTimezone=GMT",
                "root","dingzhixin"
        ));
    }
}
