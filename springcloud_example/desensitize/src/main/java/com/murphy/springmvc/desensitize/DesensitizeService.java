package com.murphy.springmvc.desensitize;

import com.murphy.springmvc.annotation.Desensitization;
import com.murphy.springmvc.enums.DesensitionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dongsufeng
 * @date 2019/12/19 11:34
 * @version 1.0
 */
public interface DesensitizeService {
	default List<String> truncateRender(String[] attachs){
		List<String> regular = new ArrayList<>();
		if (null != attachs && attachs.length >1) {
			String rule = attachs[0];
			String size = attachs[1];
			String template, result;
			if ("0".equals(rule)) {
				template = "^(\\S{%s})(\\S+)$";
				result = "$1";
			} else if ("1".equals(rule)) {
				template = "^(\\S+)(\\S{%s})$";
				result = "$2";
			} else {
				return regular;
			}
			if (Integer.parseInt(size) > 0) {
				regular.add(0, String.format(template, size));
				regular.add(1, result);
			}
		}
		return regular;
	}
	default List<String> desensitize(DesensitionType desensitionType, Desensitization desensitization){
		List<String> regular;
		switch (desensitionType) {
			case CUSTOM:
				regular = Arrays.asList(desensitization.attach());
				break;
			case TRUNCATE:
				regular = this.truncateRender(desensitization.attach());
				break;
			default:
				regular = Arrays.asList(desensitionType.getRegular());
		}
		return regular;
	}
}
