package com.de.securityoauthdemo.mobile;

/**
 * 短信服务接口
 */
public interface SmsSend {
    /**
     * 发送短信
     * @param mobile  手机号
     * @param content  短信内容
     * @return true  发送成功  false 发送失败
     */
    boolean sendSms(String mobile,String content);
}
