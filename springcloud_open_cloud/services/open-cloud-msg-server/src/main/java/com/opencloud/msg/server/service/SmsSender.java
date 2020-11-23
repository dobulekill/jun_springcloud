package com.opencloud.msg.server.service;

import com.opencloud.msg.client.model.SmsMessage;

/**
 * @author Wujun
 */
public interface SmsSender {

	/**
	 * 发送短信
	 * @param parameter
	 * @return
	 */
	Boolean send(SmsMessage parameter);
}
