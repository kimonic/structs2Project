package S_18_1.s_2_8;

import S_18_1.s_2_7.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@ComponentScan("S_18_1.s_2_8")
public class TransactionConfig {
    @Bean
    MyTransactionTemplate myTransactionTemplate() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        return new MyTransactionTemplate(new TransactionTemplate(manager),
                manager);
    }

//    @Bean
//    DataSourceTransactionManager dataSourceTransactionManager(){
//        return new DataSourceTransactionManager();
//    }
//
//    @Bean
//    TransactionTemplate transactionTemplate(){
//        return new TransactionTemplate();
//    }

//    @Bean
//    DriverManagerDataSource driverManagerDataSource(){
//        return new DriverManagerDataSource(
//                "jdbc:mysql://localhost:3306/test?serverTimezone=GMT",
//                "root", "dingzhixin"
//        );
//    }
    @Bean
    MyDataSource myDataSource() {
        return new MyDataSource(new DriverManagerDataSource(
                "jdbc:mysql://localhost:3306/test?serverTimezone=GMT",
                "root", "dingzhixin"
        ));
    }
}
