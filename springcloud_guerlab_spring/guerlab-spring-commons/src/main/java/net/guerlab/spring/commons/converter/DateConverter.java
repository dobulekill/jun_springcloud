package net.guerlab.spring.commons.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import net.guerlab.commons.time.TimeHelper;

/**
 * 日期转换
 *
 * @author Wujun
 *
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        return TimeHelper.parse(source);
    }

}