package us.data.nba.entity;

public class ResBean {
    private Integer Status;
    private String msg;
    private Object obj;

    public static ResBean bulid(){ return new ResBean(); }

    public static ResBean ok(String msg, Object obj){ return new ResBean(200,msg,obj); }

    public static ResBean ok(String msg){ return new ResBean(200,msg,null); }

    public static ResBean error(String msg, Object obj){ return new ResBean(500,msg,obj); }

    public static ResBean error(String msg){ return new ResBean(500,msg,null); }


    public ResBean() {
    }


    public ResBean(Integer status, String msg, Object obj) {
        Status = status;
        this.msg = msg;
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ResBean{" +
                "Status=" + Status +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
