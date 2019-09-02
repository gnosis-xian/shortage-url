package top.agno.gnosis.su.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description:
 * @Author: gaojing [01381583@yto.net.cn]
 * @Date: Created in 19:34 2019/9/2
 * @Modified:
 */
@Entity
public class UrlEntity {

    @Id
    private Integer id;

    private String code;

    private String url;

    private Date createTime;

    private String remark;

    private Integer extendInt;

    private String extendStr;
}
