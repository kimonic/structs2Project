package S_18_1.s_1_7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring4.x常用配置(四):Spring Profile
 *
 * Profile为在不同环境下使用不同的配置提供了支持(开发环境下的配置和生产环境的配置肯定是不同的，
 * 例如数据库的配置)。
 *
 * 1. 通过设定Environment的ActiveProfiles来设定当前context需要使用的配置环境。
 * 在开发中使用@Profile注解类或者方法，达到在不同情况下选择实例化不同的Bean。
 * 2. 通过设定jvm的spring.profiles.active参数来设置配置环境。
 * 3. Web项目设置在Servlet的context parameter中。
 */
public class TestS17 {
    public static void main(String[] args){
        /**
         * ① 先将活动的Profile设置为prod
         * ② 后置注册Bean配置类，不然会报Bean未定义的错误。
         * ③ 刷新容器
         */
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("dev");//1
        context.getEnvironment().setActiveProfiles("prod");//1
        context.register(ProfileConfig.class);//2
        context.refresh();//3

        S17Demo demo=context.getBean(S17Demo.class);
        System.out.println(demo.getContent());
        context.close();

    }
}
/**
 AnnotationConfigApplicationContext context =   new AnnotationConfigApplicationContext();

 context.getEnvironment().setActiveProfiles("dev"); //①
 context.register(ProfileConfig.class);//②
 context.refresh(); //③

 DemoBean demoBean = context.getBean(DemoBean.class);

 System.out.println(demoBean.getContent());

 context.close();
 */