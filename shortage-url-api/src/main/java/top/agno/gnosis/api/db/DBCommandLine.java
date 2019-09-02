package top.agno.gnosis.api.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.agno.gnosis.su.repository.DBRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 19:14 2019/9/2
 * @Modified:
 */
@Component
public class DBCommandLine {

    private static DBRepository dbRepository;

    @Autowired
    public void setDbRepository(DBRepository dbRepository) {
        DBCommandLine.dbRepository = dbRepository;
    }

    static String TABLE_SUFFIX = "#{table_suffix}";

    static String TABLE_COMMENT = "#{table_comment}";

    public static String SQL_TEMPLATE = "CREATE TABLE `tb_url_" + TABLE_SUFFIX + "`  (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',\n" +
            "  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短链接',\n" +
            "  `url` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原始url',\n" +
            "  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
            "  `remark` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',\n" +
            "  `extend_int` int(11) NULL DEFAULT NULL COMMENT '预留INTEGER字段',\n" +
            "  `extend_str` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留VARCHAR字段',\n" +
            "  PRIMARY KEY (`id`) USING BTREE,\n" +
            "  INDEX `code_index`(`code`) USING BTREE\n" +
            ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '" + TABLE_COMMENT + "' ROW_FORMAT = Compact;\n" +
            "\n" +
            "SET FOREIGN_KEY_CHECKS = 1;";

    public static Map<String, String> suffix_map = new HashMap<>();

    public static void createTables() {
        createSuffixMap();
//        String[] sqls = generatSqls();
//        execSQL(sqls);
        for (String key : suffix_map.keySet()) {
            dbRepository.createTable(key, suffix_map.get(key));
        }
    }

    public static Map<String, String> createSuffixMap() {
        suffix_map.put("a", "ABCDEFG");
        suffix_map.put("b", "HIJKLMN");
        suffix_map.put("c", "OPQRSTU");
        suffix_map.put("d", "VWXYZab");
        suffix_map.put("e", "cdefghi");
        suffix_map.put("f", "jklmnop");
        suffix_map.put("g", "qrstnvw");
        suffix_map.put("h", "xyz0123");
        suffix_map.put("i", "456789");
        return suffix_map;
    }

    private static String[] generatSqls() {
        String[] result = new String[suffix_map.size()];

        int index = 0;
        for (String key : suffix_map.keySet()) {
            result[index] = SQL_TEMPLATE.replace(TABLE_SUFFIX, key)
                    .replace(TABLE_COMMENT, suffix_map.get(key));
            ++index;
        }
        return result;
    }
}
