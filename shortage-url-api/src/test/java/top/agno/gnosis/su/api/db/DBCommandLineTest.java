package top.agno.gnosis.su.api.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import top.agno.gnosis.su.api.ApiApplication;
import top.agno.gnosis.su.mapper.DBMapper;

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
    private DBMapper dbMapper;

    Map<String, String> suffixMap = DBCommandLine.createSuffixMap();

    @Test
    public void createTables() {
        suffixMap.keySet().stream().forEach(e -> this.dbMapper.createTable(e, suffixMap.get(e)));
    }

    @Test
    public void dropTables() {
        suffixMap.keySet().stream().forEach(e -> this.dbMapper.dropUrlTables(e));
    }

}