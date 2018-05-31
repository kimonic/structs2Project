package S_18_1.s_1_3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring4.x基础配置(三):Spring AOP
 */
public class AopTest {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService service=context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService=context.getBean(DemoMethodService.class);
        service.add();
        System.out.println("-----------------------------------------------------");
        demoMethodService.add();
        context.close();
    }
}
/**


 import org.springframework.context.annotation.AnnotationConfigApplicationContext;

 public class Main {
 public static void main(String[] args) {
 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class); //1

 DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);

 DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);

 demoAnnotationService.add();

 demoMethodService.add();

 context.close();
 }
 }
 */