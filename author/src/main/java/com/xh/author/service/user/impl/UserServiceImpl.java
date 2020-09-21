package com.xh.author.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.author.mapper.user.XhUserMapper;
import com.xh.author.pojo.XhUser;
import com.xh.author.service.user.XhUserService;
import org.springframework.stereotype.Service;

/**
 * @author xt
 * @date 2020/9/20
 */
@Service
public class UserServiceImpl extends ServiceImpl<XhUserMapper, XhUser> implements XhUserService {

    // private final XhUserMapper xhUserMapper;
    //
    // public UserServiceImpl(XhUserMapper xhUserMapper){
    //     this.xhUserMapper = xhUserMapper;
    // }

    @Override
    public XhUser loadUserByUsername(String name) {
        QueryWrapper<XhUser> sql = new QueryWrapper<XhUser>();
        sql.eq("name" , name);
        return this.baseMapper.selectOne(sql);
        // return baseMapper.getByName(name);
    }

}
