package com.xh.export.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xt
 * @date 2020/9/7
 */
@Data
@TableName(value = "Lansen")
public class Lansen implements Serializable {

    private String id;

    private String name;

    private String zjb;

}
