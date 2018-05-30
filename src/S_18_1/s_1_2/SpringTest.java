package S_18_1.s_1_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring 学习教程
 * https://github.com/longjiazuo/spring4.x-project
 */
public class SpringTest {
    public static void main(String[] args) {

        useFunctionService();

    }

    private static void useFunctionService() {
//①使用AnnotationConfigApplicationContext作为Spring容器，接受输入一个配置类作为参数。
//②获得声明配置的UseFunctionService的Bean。
        //Java配置是Spring4.x推荐的配置方式，可以完全替代xml配置；
        // Java配置也是Spring Boot推荐的配置方式。
        //Java配置是通过@Configuration和@Bean来实现的。
        //
        //@Configuration声明当前类是一个配置类，相当于一个Spring配置的xml文件。
        //@Bean注解在方法上，声明当前方法的返回值为一个Bean。
        //
        //那么到底何时使用Java配置或者注解配置呢？我个人主要的原则是：
        // 全局配置使用Java配置(例如数据库相关配置，MVC相关配置)，
        // 业务Bean的配置使用注解配置(@Component,@Service,@Repository,@Controller)。
        //下面来演示下简单的Java配置。
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("java"));
        context.close();
    }
}
