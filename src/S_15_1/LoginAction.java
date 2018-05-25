package S_15_1;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private static final long serialVersionUID=1L;
    private String userName;
    private String password;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
