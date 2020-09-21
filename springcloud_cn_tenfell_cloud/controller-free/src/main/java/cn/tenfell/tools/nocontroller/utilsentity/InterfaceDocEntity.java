package cn.tenfell.tools.nocontroller.utilsentity;
import java.util.List;
public class InterfaceDocEntity {
    //模块名称
    String name;
    //接口集合
    List<InterfaceDocChild> list;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<InterfaceDocChild> getList() {
        return list;
    }
    public void setList(List<InterfaceDocChild> list) {
        this.list = list;
    }
}

