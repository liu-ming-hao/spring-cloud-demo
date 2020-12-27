package com.de.securityoauthdemo.mobile;

import lombok.extern.slf4j.Slf4j;

/**
 * 发送短信验证码 ，第三方短信服务接口
 */
@Slf4j
public class SmsCodeSender implements SmsSend{
    /**
     *
     * @param mobile  手机号
     * @param content  短信内容(验证码)
     * @return
     */
    @Override
    public boolean sendSms(String mobile, String content) {
        String sendcontent = String.format("验证码%s,请勿泄露给别人。",content);
        //调用第三方发送sdk即可
        log.info("向手机号：" + mobile + "发送的短信为：" + sendcontent);
        return true;
    }
}
