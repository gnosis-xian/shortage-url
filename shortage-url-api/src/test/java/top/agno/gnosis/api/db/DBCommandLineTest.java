package top.agno.gnosis.api.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import top.agno.gnosis.api.ApiApplication;
import top.agno.gnosis.su.repository.DBRepository;

import java.util.Map;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 19:56 2019/9/2
 * @Modified:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApiApplication.class})
@Profile("dev")
public class DBCommandLineTest {

    @Autowired
    private DBRepository dbRepository;

    @Test
    public void createTables() {
        DBCommandLine.createTables();
//        Map<String, String> suffixMap = DBCommandLine.createSuffixMap();
//        for (String key : suffixMap.keySet()) {
//            this.dbRepository.createTable(key, suffixMap.get(key));
//        }
    }

}