package top.agno.gnosis.su.api;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import top.agno.gnosis.su.service.DBService;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 18:57 2019/9/2
 * @Modified:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"top.agno"})
@MapperScan(value = {"top.agno.gnosis.su.mapper"})
@Slf4j
public class ApiApplication {

    private static DBService dbService;

    @Autowired
    public void setDbService(DBService dbService) {
        ApiApplication.dbService = dbService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
        log.info("初始化数据表开始");
        dbService.createUrlTables();
        dbService.createDomainTable();
        log.info("初始化数据表完成");
    }
}
