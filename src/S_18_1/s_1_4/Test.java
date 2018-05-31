package S_18_1.s_1_4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring4.x常用配置(一):Bean的Scope
 */
public class Test {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSingletonService singletonService1=context.getBean(DemoSingletonService.class);
        DemoSingletonService singletonService2=context.getBean(DemoSingletonService.class);

        DemoPrototypeService service1=new DemoPrototypeService();
        DemoPrototypeService service2=new DemoPrototypeService();
        System.out.println("singletonService1和singletonService2是否相等"+singletonService1.equals(singletonService2));
        System.out.println("service1和service2是否相等"+service1.equals(service2));
        System.out.println("service1和service2是否相等"+(service1==service2));
        System.out.println("singletonService1和singletonService2是否相等"+(singletonService1==singletonService2));

        context.close();

    }
}
/**
 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
 DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
 DemoSingletonService s2 = context.getBean(DemoSingletonService.class);

 DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
 DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);

 System.out.println("s1与s2是否相等："+s1.equals(s2));
 System.out.println("p1与p2是否相等："+p1.equals(p2));

 context.close();

 */