package S_18_1.s_2_8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestS28 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(TransactionConfig.class);
        TransactionExample example=context.getBean(TransactionExample.class);
        example.transcationOperation();
        context.close();
    }
}
