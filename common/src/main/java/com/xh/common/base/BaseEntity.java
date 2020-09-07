package com.xh.common.base;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xhh
 */

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -1884086136618584194L;

    private String Id;

    private int version;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }



}
