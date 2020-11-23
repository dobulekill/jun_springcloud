package net.dreamlu.mica;

import net.dreamlu.mica.test.MicaBaseTest;
import net.dreamlu.mica.test.MicaBootTest;
import org.junit.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 验证码 测试
 *
 * @author Wujun
 */
@SpringBootTest(
	properties = "mica.captcha.enabled=true"
)
@MicaBootTest(appName = "captcha")
public class CaptchaApplicationTests extends MicaBaseTest {

	@SpringBootConfiguration
	public static class App {

	}

	@Test
	public void contextLoads() {

	}

}
