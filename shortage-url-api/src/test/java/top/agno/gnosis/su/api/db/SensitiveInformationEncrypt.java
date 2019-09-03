package top.agno.gnosis.su.api.db;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import top.agno.gnosis.su.api.ApiApplication;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 15:56 2019/9/3
 * @Modified:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApiApplication.class})
@ActiveProfiles("dev")
@Slf4j
public class SensitiveInformationEncrypt {

    @Autowired
    private Environment environment;

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void getEncryptDbUserAndPwd() {
        String url = this.environment.getProperty("spring.datasource.url");
        String username = this.environment.getProperty("spring.datasource.username");
        String password = this.environment.getProperty("spring.datasource.password");

        log.info(url);
        log.info(username);
        log.info(password);

        log.info(stringEncryptor.encrypt(url));
        log.info(stringEncryptor.encrypt(username));
        log.info(stringEncryptor.encrypt(password));
    }
}
