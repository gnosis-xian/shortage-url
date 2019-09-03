package top.agno.gnosis.su.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 19:19 2019/9/2
 * @Modified:
 */
@Mapper
public interface DBMapper {

    void createTable(@Param("table_suffix") String table_suffix, @Param("table_comment") String table_comment);

    void dropUrlTables(@Param("table_suffix") String table_suffix);

    void createDomainTable();
}
