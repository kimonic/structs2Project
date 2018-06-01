package S_18_1.s_2_7;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class TestS27 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(BookConfig.class);

        Book book=new Book();
        book.setName("spring测试2");
        book.setPrice(18.99D);
        book.setFactoryId(3);
        BookDAO bookDAO=context.getBean(BookDAO.class);
        bookDAO.insert(book);
        System.out.println("数据添加成功!");
    }
}
