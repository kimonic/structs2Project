package S_14_1;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class TestAction extends ActionSupport {
    private  static final long serialVersionUID=1L;
    private Map<String,Object>  request;
    private Map<String,Object>  application;
    private Map<String,Object>  session;


    @SuppressWarnings("unchecked")
    public TestAction() {
        ActionContext context=ActionContext.getContext();
        request= (Map<String, Object>) context.get("request");
        application= (Map<String, Object>) context.get("application");
        session= (Map<String, Object>) context.get("session");
    }

    @Override
    public String execute() throws Exception {
        String info="明日科技";
        request.put("info",info);
        session.put("info",info);
        application.put("info",info);
        return SUCCESS;
    }
}
