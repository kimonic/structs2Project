package S_18_1.s_1_5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring4.x常用配置(二):Spring EL和资源调用
 */
public class TestS15 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig resourceService=context.getBean(ElConfig.class);
        resourceService.outputResource();
        context.close();

    }
}
/**
 *
 *  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
 *
 *          ElConfig resourceService = context.getBean(ElConfig.class);
 *
 *          resourceService.outputResource();
 *
 *          context.close();
 */
