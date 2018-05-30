package S_18_1.s_1_1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
@ComponentScan("S_18_1")//参数--需要扫描注解所在的包名路径,src以下
public class DiConfig {
//    ①@Configuration声明当前类是一个配置类。
//    ②使用@ComponentScan注解将会自动扫描包名下所有使用
//    @Service,@Component,@Repository和@Controller的类，并注册为Bean。
}
