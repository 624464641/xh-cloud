package com.xh.author.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xh.author.pojo.XhUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xt
 * @date 2020/9/20
 */
@Mapper
public interface XhUserMapper extends BaseMapper<XhUser> {

    /**
     * 根据用户名获取信息
     * @param name 用户名
     * @return XhUser
     */
    XhUser getByName(@Param("name") String name);
}
