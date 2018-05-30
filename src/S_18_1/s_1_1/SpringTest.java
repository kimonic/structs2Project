package S_18_1.s_1_1;

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
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("world"));
        context.close();
    }
}
