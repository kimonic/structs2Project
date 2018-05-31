package S_18_1.s_1_6;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ① @PostConstruct，在构造函数执行完之后执行。
 * ② @PreDestroy，在Bean销毁之前执行。
 */
public class JSP250Service {
    @PostConstruct
    public void init() {
        System.out.println("jsr250-init-method");
    }

    public JSP250Service() {
        super();
        System.out.println("初始化构造函数--JSP250Service");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("jsr250-destroy-method");
    }
}
/**
 * import javax.annotation.PostConstruct;
 * import javax.annotation.PreDestroy;
 * <p>
 * public class JSR250WayService {
 *
 * @PostConstruct //①
 * public void init(){
 * System.out.println("jsr250-init-method");
 * }
 * public JSR250WayService() {
 * super();
 * System.out.println("初始化构造函数-JSR250WayService");
 * }
 * @PreDestroy //②
 * public void destroy(){
 * System.out.println("jsr250-destory-method");
 * }
 * }
 */