package top.agno.gnosis.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import top.agno.gnosis.api.db.DBCommandLine;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 18:57 2019/9/2
 * @Modified:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"top.agno"})
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
        DBCommandLine.createTables();
    }
}
