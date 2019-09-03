package top.agno.gnosis.su.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.agno.gnosis.su.mapper.DBMapper;
import top.agno.gnosis.su.service.DBService;
import top.agno.gnosis.su.utils.DBCommandLine;

import java.util.Map;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 19:16 2019/9/2
 * @Modified:
 */
@Service
public class DBServiceImpl implements DBService {

    Map<String, String> suffixMap = DBCommandLine.createSuffixMap();

    @Autowired
    private DBMapper dbMapper;

    @Override
    public void createUrlTables() {
        suffixMap.keySet().stream().forEach(e -> this.dbMapper.createTable(e, suffixMap.get(e)));
    }

    @Override
    public void createDomainTable() {
        this.dbMapper.createDomainTable();
    }
}
