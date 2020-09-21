package cn.tenfell.tools.nocontroller.utilsentity;

import java.util.List;

public class InterfaceDocChild {
    //适用的接口链接
    List<String> urlList;
    //接口名称
    String name;
    //参数列表
    List<InterfaceParams> params;
    //返回值
    String returnData;
    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InterfaceParams> getParams() {
        return params;
    }

    public void setParams(List<InterfaceParams> params) {
        this.params = params;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }
}
