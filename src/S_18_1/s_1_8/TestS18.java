package S_18_1.s_1_8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *Spring4.x常用配置(五):Spring事件
 *
 *
 * Spring的事件(Application Event)为Bean与Bean之间的消息通信提供了支持。
 * 当一个Bean处理完一个任务之后，希望另外一个Bean知道并能做相应的处理，
 * 这时我们就需要让另外一个Bean监听当前Bean所发送的事件。
 *
 * Spring的事件需要遵循如下流程：
 * 1. 自定义事件，继承ApplicationEvent
 * 2. 定义事件监听器，实现ApplicationListener
 */
public class TestS18 {
    public static void main(String[] a){
        //此处一定要使用正确的配置类
        AnnotationConfigApplicationContext context
                =new AnnotationConfigApplicationContext(EventConfig.class);
        S18DemoPublisher demoPublisher=context.getBean(S18DemoPublisher.class);
        demoPublisher.publish("hello application event");
        context.close();
    }
}
/**
 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

 DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);

 demoPublisher.publish("hello application event");

 context.close();
 */