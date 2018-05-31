package S_18_1.s_1_5;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.nio.charset.Charset;

@Configuration
@ComponentScan("S_18_1.s_1_5")
@PropertySource("classpath:S_18_1/s_1_5/test.properties")//可以通过Eviroment获取文件属性,必须配置
//classpath:org/light4j/sping4/usually/el/test.properties"
public class ElConfig {
    /**
     * ①注入普通字符
     * ②注入操作系统属性
     * ③注入表达式运算结果
     * ④注入其他Bean的属性
     * ⑤注入文件内容
     * ⑥注入网址内容
     * ⑦注入属性文件
     *
     * 注入配置文件需要使用@PropertySource指定文件地址，若使用@Value注入，则要配置一个PropertySourcesPlaceholderConfigurer的Bean。
     * 注意：@Value("${book.name}")使用的是”$”，而不是”#”。
     * 注入Properties还可以从Environment中获得
     */
    @Value("I Love You!")//1
    private String normal;

    @Value("#{systemProperties['os.name']}")//2
    private String osName;

    @Value("#{T(java.lang.Math).random()*100.0}")//3
    private double randomNumber;

    @Value("#{demoService.another}")//4
    private String fromAnother;

    @Value("classpath:S_18_1/s_1_5/test.txt")//5
    private Resource testFile;

    @Value("https://www.baidu.com")//6
    private Resource  testUrl;

    @Value("${book.name}")//
    private String bookName;

    @Autowired
    private Environment environment;

    @Bean//7
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println(IOUtils.toString(testFile.getInputStream(),Charset.defaultCharset()));
            System.out.println(IOUtils.toString(testUrl.getInputStream(),"utf-8"));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
/**

 import org.apache.commons.io.IOUtils;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.PropertySource;
 import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
 import org.springframework.core.env.Environment;
 import org.springframework.core.io.Resource;

 @Configuration
 @ComponentScan("org.light4j.sping4.usually.el")
 @PropertySource("classpath:org/light4j/sping4/usually/el/test.properties")//⑦
 public class ElConfig {

 @Value("I Love You!") //①
 private String normal;

 @Value("#{systemProperties['os.name']}") //②
 private String osName;

 @Value("#{ T(java.lang.Math).random() * 100.0 }") //③
 private double randomNumber;

 @Value("#{demoService.another}") //④
 private String fromAnother;

 @Value("classpath:org/light4j/sping4/usually/el/test.txt") //⑤
 private Resource testFile;

 @Value("http://www.baidu.com") //⑥
 private Resource testUrl;

 @Value("${book.name}") //⑦
 private String bookName;

 @Autowired
 private Environment environment; //⑦

 @Bean //7
 public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
 return new PropertySourcesPlaceholderConfigurer();
 }

 public void outputResource() {
 try {
 System.out.println(normal);
 System.out.println(osName);
 System.out.println(randomNumber);
 System.out.println(fromAnother);

 System.out.println(IOUtils.toString(testFile.getInputStream()));
 System.out.println(IOUtils.toString(testUrl.getInputStream()));
 System.out.println(bookName);
 System.out.println(environment.getProperty("book.author"));
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 }

 */