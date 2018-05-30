package S_18_1.s_1_3;

import org.springframework.stereotype.Service;

/**
 * 编写使用注解的被拦截类
 */
@Service
public class DemoAnnotationService {
    @Action(name="注解式拦截的add操作")
    public void add(){}
}
/**import org.springframework.stereotype.Service;

 @Service
 public class DemoAnnotationService {
 @Action(name="注解式拦截的add操作")
 public void add(){}
 }
 */