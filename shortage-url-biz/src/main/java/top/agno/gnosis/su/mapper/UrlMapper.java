package top.agno.gnosis.su.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 19:48 2019/9/3
 * @Modified:
 */
@Mapper
public interface UrlMapper {

    int insertUrl(@Param("dbNameSuffix") String dbNameSuffix,
                  @Param("code") String code,
                  @Param("url") String url,
                  @Param("remark") String remark);

    String countUrl(@Param("dbNameSuffix") String dbNameSuffix,
                     @Param("url") String url);

    String findUrl(@Param("dbNameSuffix") String dbNameSuffix, @Param("code") String code);
}
