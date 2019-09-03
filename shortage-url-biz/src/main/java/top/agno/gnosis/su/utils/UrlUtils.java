package top.agno.gnosis.su.utils;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 17:54 2019/9/3
 * @Modified:
 */
public class UrlUtils {

    public static String getTopAndSecondLevelDomain(String url) {
        String result;
        if (url == null || "".equals(url)) {
            return "";
        }
        if (url.startsWith("http://") || url.startsWith("https://")) {
            String[] splits = url.split("/");
            String[] domains = splits[2].split("\\.");
            result = domains[domains.length - 2] + "." + domains[domains.length - 1];
        } else if (!url.startsWith("http://") && !url.startsWith("https://")) {
            String[] splits = url.split("/");
            String[] domains = splits[0].split("\\.");
            if (domains[domains.length - 1].endsWith("/")) {
                domains[domains.length - 1] = domains[domains.length - 1].substring(0, domains[domains.length - 1].length() - 1);
            }
            result = domains[domains.length - 2] + "." + domains[domains.length - 1];
        } else {
            return "";
        }
        return result;
    }

    public static String replaceIpDotToUnderline(String ip) {
        return ip == null || "".equals(ip) ? ip : ip.replace(".", "_");
    }
}
