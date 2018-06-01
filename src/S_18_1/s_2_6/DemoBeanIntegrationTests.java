package S_18_1.s_2_6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * junit 单元测试报错：java.lang.NoClassDefFoundError: org/hamcrest/SelfDescribing
 *https://blog.csdn.net/u011954243/article/details/77962329
 *
 * 此类可以单独运行******************************************************
 *
 * ① SpringJUnit4ClassRunner 在Junit环境下提供Spring TestContext Framework的功能。
 * ② @ContextConfiguration 用来加载配置ApplicationContext，其中classes属性用来加载配置类。
 * ③ @ActiveProfiles用来声明活动的profile
 * ④ 可使用普通的@Autowired注入Bean。
 * ⑤ 测试代码，通过JUnit的Assert来校验结果是否和预期一致。
 */
@RunWith(SpringJUnit4ClassRunner.class)//1
@ContextConfiguration(classes = {TestConfig.class})//2
@ActiveProfiles("dev")//3
public class DemoBeanIntegrationTests {
    @Autowired//4
    private TestBean testBean;

    @Test//5
    public void prodBeanShouldInject(){
//        String expected="from production profile";
        String expected="from development profile";
        String actual=testBean.getContent();
        Assert.assertEquals(expected,actual);
    }
}
/**
 import org.junit.Assert;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.test.context.ActiveProfiles;
 import org.springframework.test.context.ContextConfiguration;
 import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

 @RunWith(SpringJUnit4ClassRunner.class) //①
 @ContextConfiguration(classes = {TestConfig.class}) //②
 @ActiveProfiles("prod") //③
 public class DemoBeanIntegrationTests {
 @Autowired //④
 private TestBean testBean;

 @Test //⑤
 public void prodBeanShouldInject(){
 String expected = "from production profile";
 String actual = testBean.getContent();
 Assert.assertEquals(expected, actual);
 }
 }*/