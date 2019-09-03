package top.agno.gnosis.su.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import top.agno.gnosis.su.service.UrlService;
import top.agno.gnosis.su.utils.UrlUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 18:59 2019/9/2
 * @Modified:
 */
@RestController
@Slf4j
public class UrlController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UrlService urlService;

    @Value("${system.domain}")
    private String domain;

    @RequestMapping(value = "/addUrl", method = RequestMethod.GET)
    public String insertUrl(HttpServletRequest request, @RequestParam("url") String url) {
        String redisKey = UrlUtils.replaceIpDotToUnderline(request.getRemoteAddr()) + UrlUtils.getTopAndSecondLevelDomain(url);
        if (this.redisTemplate.opsForValue().get(redisKey) != null) {
            return "To request quickly. Please wait a moment.";
        }
        this.redisTemplate.opsForValue().set(redisKey, "", 3, TimeUnit.MINUTES);

        String resultUrl = new String();
        try {
            resultUrl = this.urlService.insertUrl(url, request.getHeader(HttpHeaders.USER_AGENT));
        } catch (Exception e) {
            log.error(e.getMessage());
            return e.getMessage();
        }
        return "http://" + domain + "/" + resultUrl;
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public String findUrl(@PathVariable("code") String code) {
        if ("".equals(code)) {
            return "";
        }
        String resultUrl = new String();
        try {
            resultUrl = this.urlService.findUrl(code);
        } catch (Exception e) {
            log.error(e.getMessage());
            return e.getMessage();
        }
        return "<script language=\"javascript\">window.location=\"" + resultUrl + "\"</script>";
    }
}
