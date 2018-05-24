package S_15_1;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class OGNLAction extends ActionSupport {
    private static final long serialVersionUID=1L;
    private String name;
    private Student student;
    private Map<String,Object> request;

    @SuppressWarnings("unchecked")
    public OGNLAction() {
        student=new Student();
        student.setId(1);
        student.setName("张三");
        name="tom";
        request= (Map<String, Object>) ActionContext.getContext().get("request");
    }

    @Override
    public String execute() throws Exception {
        request.put("info","request测试!");
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
