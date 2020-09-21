package cn.tenfell.tools.nocontroller.utilsentity;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;

import java.util.Date;
public class PoData extends Dict{
    private static final long serialVersionUID = 1L;
    public static PoData create() {
        return new PoData();
    }
    @Override
    public PoData set(String attr, Object value) {
        super.set(attr,value);
        return this;
    }
    public PoData set(boolean flag,String attr, Object value) {
        if(!flag){
            return this;
        }
        return this.set(attr,value);
    }
    public static <T> PoData parse(T bean) {
        return create().parseBean(bean);
    }
    @Override
    public <T> PoData parseBean(T bean) {
        super.parseBean(bean);
        return this;
    }
    @Override
    public PoData clone() {
        return (PoData)super.clone();
    }
    @Override
    public PoData filter(String... keys) {
        final PoData result = PoData.create();
        for (String key : keys) {
            if (this.containsKey(key)) {
                result.put(key, this.get(key));
            }
        }
        return result;
    }
    @Override
    public <T> PoData parseBean(T bean, boolean isToUnderlineCase, boolean ignoreNullValue) {
        super.parseBean(bean,isToUnderlineCase,ignoreNullValue);
        return this;
    }
    @Override
    public PoData setIgnoreNull(String attr, Object value) {
        super.setIgnoreNull(attr,value);
        return this;
    }
    @Override
    public Date getDate(String attr){
        DateTime dt=getDateTime(attr);
        if(dt == null){
            return null;
        }else{
            return dt.toJdkDate();
        }
    }
    public DateTime getDateTime(String attr){
        Object obj = this.getObj(attr);
        if(obj == null){
            return null;
        }else if(obj instanceof DateTime){
            return (DateTime)obj;
        }else if(obj instanceof Date){
            return DateUtil.date((Date)obj);
        }else if(obj instanceof String){
            String str = (String)obj;
            if(StrUtil.isBlank(str)){
                return null;
            }
            Date date = Convert.toDate(str);
            Assert.notNull(date,"当前数据不能转化成时间:{}",str);
            return DateUtil.date(date);
        }else if(obj instanceof Long){
            Long lg = (Long)obj;
            if(lg == null){
                return null;
            }
            return DateUtil.date(lg);
        }else{
            Assert.isTrue(false,"当前数据不能转化成时间:{}",obj);
        }
        return null;
    }
}
