package S_18_1.s_1_3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Aspect 需要的jar包下载地址
 * https://www.eclipse.org/aspectj/downloads.php
 * 注意下载时要下载aspectj-1.8.13.jar这个jar包,
 * 下载好后使用解压软件解压,选择lib中的jar包添加
 * 不要下载aspectj-1.8.13-src.jar,下载该jar包引入无效
 * 神坑
 */
@Aspect//1
@Component//2
public class LogAspect {
    /**
     * ①通过@Aspect注解声明该类是一个切面。
     * ②通过@Component让此切面成为Spring容器管理的Bean。
     * ③通过@Pointcut注解声明切面。
     * ④通过@After注解声明一个建言，并使用@Pointcut定义的切点。
     * ⑤通过反射可以获得注解上面的属性，然后做日志记录相关的操作，下面的相同。
     * ⑥通过@Before注解声明一个建言，此建言直接使用拦截规则作为参数。
     */
    @Pointcut("@annotation(S_18_1.s_1_3.Action)")//3
    public void annotationPointCut() {
    }

    @After("annotationPointCut()")//4
    public void after(JoinPoint joinpoint) {
        MethodSignature signature = (MethodSignature) joinpoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截:" + action.name());//5

    }

    @Before("execution(* DemoMethodService.*(..))")//6
    public void before(JoinPoint joinPoint){
        MethodSignature signature= (MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        System.out.println("方法规则式拦截:"+method.getName());
    }




}
/**
 * import java.lang.reflect.Method;
 * <p>
 * import org.aspectj.lang.JoinPoint;
 * import org.aspectj.lang.annotation.After;
 * import org.aspectj.lang.annotation.Aspect;
 * import org.aspectj.lang.annotation.Before;
 * import org.aspectj.lang.annotation.Pointcut;
 * import org.aspectj.lang.reflect.MethodSignature;
 * import org.springframework.stereotype.Component;
 *
 * @Aspect //①
 * @Component //②
 * public class LogAspect {
 * @Pointcut("@annotation(org.light4j.sping4.base.aop.Action)") //③
 * public void annotationPointCut(){};
 * @After("annotationPointCut()") //④
 * public void after(JoinPoint joinPoint) {
 * MethodSignature signature = (MethodSignature) joinPoint.getSignature();
 * Method method = signature.getMethod();
 * Action action = method.getAnnotation(Action.class);
 * System.out.println("注解式拦截 " + action.name()); //⑤
 * }
 * @Before("execution(* org.light4j.sping4.base.aop.DemoMethodService.*(..))") //⑥
 * public void before(JoinPoint joinPoint){
 * MethodSignature signature = (MethodSignature) joinPoint.getSignature();
 * Method method = signature.getMethod();
 * System.out.println("方法规则式拦截,"+method.getName());
 * <p>
 * }
 * }
 */