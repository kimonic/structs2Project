package S_18_1.s_2_4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring4.x高级话题(五):组合注解与元注解
 *
 * 从Spring2开始，为了响应JDK1.5推出的注解功能，Spring开始大量加入注解来替代xml配置。
 * Spring的注解主要用来配置和注入Bean，
 * 以及AOP相关配置(@Transaction)。随着注解的大量使用，尤其相同的多个注解用到各个类或方法中，
 * 会相当繁琐。这就是所谓的样板代码(boilerplate code)，是Spring设计原则中要消除的代码。
 *
 * 所谓元注解其实就是可以注解到别的注解上面的注解，被注解的注解称之为组合注解(可能有点拗口，
 * 体会含义最重要)，组合注解具备注解其上的元注解的功能。Spring的很多注解都可以作为元注解，
 * 而且Spring本身已经有很多组合注解，如@Configuration就是一个组合@Component注解，
 * 表明这个类其实也是一个Bean。
 *
 * 在之前介绍的相关文章里面，大量使用@Configuration和@ComponentScan注解到配置类上，
 * 其实这样相对有些繁琐，下面将这两个元注解组成一个组合注解，这样我们只需要写一个
 * 注解就可以表示两个注解。
 */
public class TestS24 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(CombinationConfig.class);
        S24Service s24Service=context.getBean(S24Service.class);
        s24Service.outputResult();
        context.close();
    }
}
/**
 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

 DemoService demoService =  context.getBean(DemoService.class);

 demoService.outputResult();

 context.close();
 */