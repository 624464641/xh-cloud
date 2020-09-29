package com.xh.author.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.author.mapper.user.XhUserMapper;
import com.xh.author.pojo.XhUser;
import com.xh.author.service.user.XhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xt
 * @date 2020/9/20
 */
@Service
public class UserServiceImpl extends ServiceImpl<XhUserMapper, XhUser> implements XhUserService {



    @Override
    public XhUser loadUserByUsername(String name) {
        // QueryWrapper<XhUser> sql = new QueryWrapper<XhUser>();
        // sql.eq("name" , name);
        // return this.baseMapper.selectOne(sql);
        return baseMapper.getByName(name);
    }

}
