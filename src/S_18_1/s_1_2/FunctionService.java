package S_18_1.s_1_2;

/**
 * 功能类bean
 */
public class FunctionService {
//①此处没有使用@Service声明Bean
    public String sayHello(String word){
        return "hello "+word+"!";
    }
}
