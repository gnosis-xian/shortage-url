package top.agno.gnosis.su.repository;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import top.agno.gnosis.su.entity.UrlEntity;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 19:19 2019/9/2
 * @Modified:
 */
@Repository
public interface DBRepository extends JpaRepository<UrlEntity, Integer> {

    @Query(value = "CREATE TABLE tb_url_:table_suffix  (\n" +
            "  id int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',\n" +
            "  code varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短链接',\n" +
            "  url varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原始url',\n" +
            "  create_time datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
            "  remark varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',\n" +
            "  extend_int int(11) NULL DEFAULT NULL COMMENT '预留INTEGER字段',\n" +
            "  extend_str varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留VARCHAR字段',\n" +
            "  PRIMARY KEY (id) USING BTREE,\n" +
            "  INDEX code_index(code) USING BTREE\n" +
            ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = ':table_comment' ROW_FORMAT = Compact;\n" +
            "SET FOREIGN_KEY_CHECKS = 1;")
    void createTable(String table_suffix, String table_comment);
}
