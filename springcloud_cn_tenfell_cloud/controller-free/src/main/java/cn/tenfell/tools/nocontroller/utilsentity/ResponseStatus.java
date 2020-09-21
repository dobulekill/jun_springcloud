package cn.tenfell.tools.nocontroller.utilsentity;

public enum ResponseStatus {
    SUCCESS("成功"),FAILED("失败"),NOLOGIN("未登录");
    private String msg;
    public String getMsg(){
        return this.msg;
    }
    ResponseStatus(String msg) {
        this.msg = msg;
    }
}
