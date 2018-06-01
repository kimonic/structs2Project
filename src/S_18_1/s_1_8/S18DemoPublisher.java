package S_18_1.s_1_8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * ① 注入ApplicationContext 用来发布事件。
 * ② 使用ApplicationContext 的publishEvent方法来进行发布。
 */
@Component
public class S18DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;//1

    public void publish(String msg) {
        applicationContext.publishEvent(new S18Demo(this, msg));//2
    }


}
/**
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.context.ApplicationContext;
 * import org.springframework.stereotype.Component;
 *
 * @Component public class DemoPublisher {
 * @Autowired ApplicationContext applicationContext;//①
 * <p>
 * public void publish(String msg){
 * applicationContext.publishEvent(new DemoEvent(this, msg));//②
 * }
 * <p>
 * }
 */