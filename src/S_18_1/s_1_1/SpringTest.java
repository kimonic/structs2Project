package S_18_1.s_1_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring 学习教程
 * https://github.com/longjiazuo/spring4.x-project
 * spring中文开发文档
 * https://blog.csdn.net/tangtong1/article/details/51326887
 * ssh开发实战项目
 * http://how2j.cn/k/tmall-ssh/tmall-ssh-1254/1254.html
 *
 * Spring4.x基础配置(一):依赖注入
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
