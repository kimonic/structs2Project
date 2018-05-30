package S_18_1.s_1_1;

import org.springframework.stereotype.Service;

/**
 * 功能类bean
 */
@Service
public class FunctionService {
//①使用@Service注解声明当前FunctionService类是Spring容器管理的一个Bean。其中，
// 使用@Component,@Service,@Repository和@Controller是等效的，可以根据自己的需要选用。

    public String sayHello(String word){
        return "hello "+word+"!";
    }
}
