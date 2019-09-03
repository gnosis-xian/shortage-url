package top.agno.gnosis.su.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 19:14 2019/9/2
 * @Modified:
 */
public class DBCommandLine {

    public static Map<String, String> SUFFIX_MAP = new HashMap<>();

    public static String SUFFIX_KEY = "abcdefghijklmnopqrstuvwxyz";

    public static String KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static Map<String, String> createSuffixMap() {
        SUFFIX_MAP.put("a", "ABCDEFG");
        SUFFIX_MAP.put("b", "HIJKLMN");
        SUFFIX_MAP.put("c", "OPQRSTU");
        SUFFIX_MAP.put("d", "VWXYZab");
        SUFFIX_MAP.put("e", "cdefghi");
        SUFFIX_MAP.put("f", "jklmnop");
        SUFFIX_MAP.put("g", "qrstnvw");
        SUFFIX_MAP.put("h", "xyz0123");
        SUFFIX_MAP.put("i", "456789");
        return SUFFIX_MAP;
    }

}
