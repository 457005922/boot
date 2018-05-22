package application.hbg.config;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 描述:
 *
 * @author 花满楼
 * @version 0.1
 * @email huamanlou@izjjf.cn
 * @since 2017-05-11 22:44
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 86400) // http会话超时时间
public class HttpSessionConfig {
}
