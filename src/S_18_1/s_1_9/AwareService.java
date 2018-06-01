package S_18_1.s_1_9;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

/**
 * ① 实现BeanNameAware,ResourceLoaderAware接口，获得Bean名称和资源加载的服务。
 * ② 实现ResourceLoaderAware需要重写setResourceLoader方法。
 * ③ 实现BeanNameAware需要重写setBeanName方法。
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware {//1
    private String beanName;
    private ResourceLoader resourceLoader;
    @Override
    public void setBeanName(String name) {//3
        this.beanName=name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {//2
        this.resourceLoader=resourceLoader;
    }

    public void outputResult(){
        System.out.println("Bean的名称为:"+beanName);
        Resource resource=resourceLoader.getResource("classpath:S_18_1/s_1_9/tests19.txt");
        try {
            System.out.println("ResourceLoader加载的文件内容为:"+
                    IOUtils.toString(resource.getInputStream(),Charset.defaultCharset()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
/**
 import java.io.IOException;

 import org.apache.commons.io.IOUtils;
 import org.springframework.beans.factory.BeanNameAware;
 import org.springframework.context.ResourceLoaderAware;
 import org.springframework.core.io.Resource;
 import org.springframework.core.io.ResourceLoader;
 import org.springframework.stereotype.Service;

 @Service
 public class AwareService implements BeanNameAware,ResourceLoaderAware{//①

 private String beanName;
 private ResourceLoader loader;

 @Override
 public void setResourceLoader(ResourceLoader resourceLoader) {//②
 this.loader = resourceLoader;
 }

 @Override
 public void setBeanName(String name) {//③
 this.beanName = name;
 }

 public void outputResult(){
 System.out.println("Bean的名称为：" + beanName);

 Resource resource =
 loader.getResource("classpath:org/light4j/sping4/senior/aware/test.txt");
 try{

 System.out.println("ResourceLoader加载的文件内容为: " + IOUtils.toString(resource.getInputStream()));

 }catch(IOException e){
 e.printStackTrace();
 }
 }
 }
 */