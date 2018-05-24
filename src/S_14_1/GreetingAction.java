package S_14_1;

import com.opensymphony.xwork2.ActionSupport;

public class GreetingAction extends ActionSupport {
    private static final long serialVersionUID=1L;
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String execute() throws Exception {
        if (name==null||"".equals(name)){

            return ERROR;
        }else {
            return SUCCESS;

        }
    }
}
