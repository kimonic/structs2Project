package S_18_1.s_1_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用功能类bean
 */
public class UseFunctionService {

    //①此处没有使用@Service声明Bean
    //②此处没有使用@Autowired注解注入Bean
     private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
