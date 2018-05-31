package S_18_1.s_1_8;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ① 实现ApplicationListener接口，并指定监听的事件类型。
 * ② 使用onApplicationEvent方法对消息进行接受处理。
 */
@Component
public class S18DemoListener implements ApplicationListener<S18Demo> {//1
    @Override
    public void onApplicationEvent(S18Demo s18Demo) {//2
        String msg=s18Demo.getMsg();
        System.out.println("listener接收到了bean发布的消息"+msg);

    }
}
/**
 import org.springframework.context.ApplicationListener;
 import org.springframework.stereotype.Component;

 @Component
 public class DemoListener implements ApplicationListener<DemoEvent> {//①

 public void onApplicationEvent(DemoEvent event) {//②

 String msg = event.getMsg();

 System.out.println("我(bean-demoListener)接受到了bean-demoPublisher发布的消息:"+ msg);

 }
 }

 */