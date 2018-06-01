package S_18_1.s_1_9;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring4.x高级话题(一):Spring Aware
 *
 *
 * 一. 点睛
 * Spring的依赖注入的最大亮点就是你所有的Bean对Spring容器的存在是没有意识的。
 * 即你可以将你的容器替换成别的容器，例如Goggle Guice,这时Bean之间的耦合度很低。
 *
 * 但是在实际的项目中，我们不可避免的要用到Spring容器本身的功能资源， *
 * 这时候Bean必须要意识到Spring容器的存在，才能调用Spring所提供的资源，
 * 这就是所谓的Spring Aware。其实Spring Aware本来就是Spring设计用来框架内部使用的，
 * 若使用了Spring Aware，你的Bean将会和Spring框架耦合。
 *
 * Spring提供的Aware接口如下表所示：
 * Spring提供的Aware接口
 * BeanNameAware	获得到容器中Bean的名称
 * BeanFactoryAware	获得当前bean factory，这样可以调用容器的服务
 * ApplicationContextAware*	获得当前application context，这样可以调用容器的服务
 * MessageSourceAware	获得message source这样可以获得文本信息
 * ApplicationEventPublisherAware	应用事件发布器，可以发布事件
 * ResourceLoaderAware	获得资源加载器，可以获得外部资源文件
 * Spring Aware的目的是为了让Bean获得Spring容器的服务。
 * 因为ApplicationContext接口集成了MessageSource接口，ApplicationEventPublisherAware接口
 * 和ResourceLoaderAware接口，所以Bean继承ApplicationContextAware可以获得Spring容器的所有服务
 * ，但原则上我们还是用到什么接口就实现什么接口。
 */
public class TestS19 {
    public static void main(String[] a){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService service=context.getBean(AwareService.class);
        service.outputResult();
        context.close();
    }
}
