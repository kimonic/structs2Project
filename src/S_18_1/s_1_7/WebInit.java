package S_18_1.s_1_7;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("spring.profiles.default","dev");
    }
}
/**
 import javax.servlet.ServletContext;

 import org.springframework.web.WebApplicationInitializer;

 public class WebInit implements WebApplicationInitializer{

@Override
public void onStartup(ServletContext container) throws ServletException {
container.setInitParameter("spring.profiles.default","dev");
}
}

 */