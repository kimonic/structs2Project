package S_15_1;

import com.opensymphony.xwork2.ActionSupport;

public class SleepAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        Thread.sleep(1000);
        return SUCCESS;
    }
}
