package com.de.securityoauthdemo.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * KaptchaImageCodeConfig
 *
 * @author 刘明浩
 * @Description  图形验证码配置
 *               使用第三方Kaptcha来生成图形验证码
 * @since 2020/12/26 12:02
 */
@Configuration
public class KaptchaImageCodeConfig {
    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 图片边框
        properties.setProperty(Constants.KAPTCHA_BORDER, "yes");
        // 边框颜色
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "105,179,90");
        // 图片宽
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "110");
        // 图片高
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "40");
        // 字体颜色
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "red");
        // 字体大小
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "30");
        //properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
        // 字体
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "宋体,楷体,微软雅黑");
        // 验证码长度
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        // 图片效果
        //properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.FishEyeGimpy");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
