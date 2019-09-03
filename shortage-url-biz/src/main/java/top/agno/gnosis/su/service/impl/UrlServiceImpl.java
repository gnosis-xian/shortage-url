package top.agno.gnosis.su.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.agno.gnosis.su.mapper.UrlMapper;
import top.agno.gnosis.su.service.UrlService;
import top.agno.gnosis.su.utils.DBCommandLine;
import top.agno.gnosis.su.utils.Md5Encryptor;
import top.agno.gnosis.su.utils.UrlUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 19:08 2019/9/2
 * @Modified:
 */
@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlMapper urlMapper;

    Map<String, String> suffixMap = DBCommandLine.createSuffixMap();

    @Override
    public String insertUrl(String url, String header) {
        String digestStr = Md5Encryptor.encrypt(url);
        digestStr = new String(Base64.getUrlEncoder().encode(digestStr.getBytes())).substring(0, 7);
        String suffix = this.getSuffix(digestStr);
        String urlCode = this.urlMapper.countUrl(suffix, url);
        if (!StringUtils.isEmpty(urlCode)) {
            return urlCode;
        }
        this.urlMapper.insertUrl(suffix,
                digestStr,
                url,
                header);
        return this.urlMapper.countUrl(suffix, url);
    }

    private String getSuffix(String digestStr) {
        for (String e : suffixMap.keySet()) {
            if (suffixMap.get(e).contains(digestStr.toCharArray()[0] + "")) {
                return e;
            }
        }
        return "";
    }

    @Override
    public String findUrl(String code) {
        return this.urlMapper.findUrl(this.getSuffix(code), code);
    }
}
