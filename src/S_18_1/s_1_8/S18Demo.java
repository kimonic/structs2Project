package S_18_1.s_1_8;

import org.springframework.context.ApplicationEvent;

public class S18Demo extends ApplicationEvent {
    private static final long serialVersionUID=1L;
    private String msg;

    public S18Demo(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
/**
 import org.springframework.context.ApplicationEvent;

 public class DemoEvent extends ApplicationEvent{
 private static final long serialVersionUID = 1L;
 private String msg;

 public DemoEvent(Object source,String msg) {
 super(source);
 this.msg = msg;
 }

 public String getMsg() {
 return msg;
 }

 public void setMsg(String msg) {
 this.msg = msg;
 }
 }
 */