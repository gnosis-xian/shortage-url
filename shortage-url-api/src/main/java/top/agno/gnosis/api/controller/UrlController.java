package top.agno.gnosis.api.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 18:59 2019/9/2
 * @Modified:
 */
@RestController
public class UrlController {

    @RequestMapping(value = "/addUrl", method = RequestMethod.GET)
    public String insertUrl(@RequestParam("url") String url) {
        return null;
    }
}
