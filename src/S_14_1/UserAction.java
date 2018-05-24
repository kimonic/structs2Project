package S_14_1;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    private static final long serialVersionUID=1L;
    private  String userName;
    private String info;

    public String add(){
        info="添加用户信息";
        return "add";
    }

    public String update(){
        info="更新用户信息";
        return "update";

    }

    public String delete(){
        info="删除用户信息";
        return "delete";
    }

    public String find(){
        info="查找用户信息";
        return "find";
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
