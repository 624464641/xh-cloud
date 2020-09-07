package com.xh.author.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xh.common.base.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Face up to failure
 *
 * @Author xh
 * @Date 2020/8/15- 0:20
 */
@Data
@TableName("auth_xh_user")
public class XhUser extends BaseEntity {

    private String firstName;

    private String lastName;

    private String passWord;

    private LocalDateTime birthdate;

}
