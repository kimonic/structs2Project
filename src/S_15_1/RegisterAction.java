package S_15_1;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
    private static final long serialVersionUID=1L;
    private String name;
    private String password;
    private int sex=1;
    private String province;
    private String[] hobby;
    private String description;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("传输进来的性别值是:"+sex);
        return SUCCESS;
    }
}
