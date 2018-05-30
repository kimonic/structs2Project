package S_18_1.s_1_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用功能类bean
 */
@Service
public class UseFunctionService {
    @Autowired
     private FunctionService functionService;

//    ①使用@Service注解声明当前UseFunctionService 类是Spring容器管理的一个Bean。
//    ②使用@Autowired将FunctionService的实体Bean注入到UseFunctionService
//    中，让UseFunctionService
//    具备FunctionService的功能，此处使用JSR-330的
//    @Inject注解或者JSR-250的@Resource注解是等效的。
    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
