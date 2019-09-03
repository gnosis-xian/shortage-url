package top.agno.gnosis.su.service;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 19:07 2019/9/2
 * @Modified:
 */
public interface UrlService {
    String insertUrl(String url, String userAgent);

    String findUrl(String code);
}
