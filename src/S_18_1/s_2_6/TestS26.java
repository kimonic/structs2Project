package S_18_1.s_2_6;

/**
 * Spring4.x高级话题(七):Spring的测试
 *
 * 一. 点睛
 * 测试是开发工作中不可缺少的部分，单元测试只针对当前开发的类和方法进行测试，
 * 可以简单通过模拟依赖来实现，对运行环境没有依赖；但是仅仅单元测试是不够的，
 * 它只能验证当前类或者方法能否正常工作，而我们想要知道系统的各个部分组合在一
 * 起是否能够正常工作，这就涉及到了集成测试。
 *
 * 集成测试一般需要来自不同层的不同对象的交互，如数据库，网络连接，Ioc容器等。
 * 其实我们也经常通过运行程序，然后通过自己操作来完成类似于集成测试的流程。
 * 集成测试为我们提供了一种无须部署或运行程序来完成验证系统各部分功能是否能
 * 正常协同工作的能力。
 *
 * Spring通过Spring TestContext Framework对集成测试提供顶级支持。它不依赖特定
 * 的测试框架，即可使用Junit，也可使用TestNG。
 *
 * 基于maven构建的项目结构默认有关于测试的目录是:src/test/java(测试代码)，
 * src/test/resources(测试资源)，它们区别于src/main/java(项目源码)，
 * src/main/resource(项目资源)。
 *
 * Spring提供了一个SpringJUnit4ClassRunner类，它提供了Spring TestContext
 *
 * Framework的功能。通过@ContextConfiguration来配置Application Context，
 * 通过@ActiveProfiles确定活动的profile。
 *
 * 在使用了Spring测试后，我们前面文章中例子的”运行”部分都可以用Spring测
 * 试来检验功能能否正常运作。
 *
 * 集成测试涉及程序中的各个分层，本节只对简单配置的Application Context和
 * 在测试中注入Bean做演示。
 */
public class TestS26 {

    public static void main(String[] args){

    }
}
