package com.study.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import com.config.*;
/**
 * 使用RibbonClient，为特定name的Ribbon Client自定义配置.
 * 使用@RibbonClient的configuration属性，指定Ribbon的配置类.
 * 可参考的示例：
 * http://spring.io/guides/gs/client-side-load-balancing/
 *
 */
@Configuration
@RibbonClient(name = "provider-user", configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
