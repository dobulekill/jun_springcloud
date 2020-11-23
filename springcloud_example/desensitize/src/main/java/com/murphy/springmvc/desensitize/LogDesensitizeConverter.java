package com.murphy.springmvc.desensitize;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.murphy.springmvc.enums.DesensitionType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Wujun
 * @date 2019/12/19 15:06
 * @version 1.0
 */
public class LogDesensitizeConverter  extends MessageConverter {
	/**
	 * 日志脱敏开关
	 */
	private static Boolean converterCanRun = Boolean.TRUE;
	/**
	 * 日志脱敏关键字
	 */
	@Override
	public String convert(ILoggingEvent event) {
		// 获取原始日志
		String oriLogMsg = event.getFormattedMessage();
		if (!converterCanRun){
			return oriLogMsg;
		}
		// 获取脱敏后的日志
		DesensitionType[] values = DesensitionType.values();
		for (DesensitionType value : values) {
			if (value.getRegular()!=null && value.getRegular().length>0 && oriLogMsg.contains(value.getType())){
				Matcher matcher = Pattern.compile(value.getRegular()[0]).matcher(oriLogMsg);
				oriLogMsg = matcher.replaceAll(value.getRegular()[1]);
			}
		}
		return oriLogMsg;
	}

	public static void main(String[] args) {
		String str="(\\w{4})\\w{7,10}(\\w{4})";
		String oriLogMsg="===============userDTO.toString=UserDTO(identityNo=111111111111111111, name=dsf, realname=张三)";
		Matcher matcher = Pattern.compile(str).matcher(oriLogMsg);
		if (matcher.find()){
			System.out.println("-----------------------------"+matcher.group());
		}else {
			System.out.println("2222222222222222");
		}
	}
}
