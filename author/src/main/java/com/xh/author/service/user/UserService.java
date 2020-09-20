package com.xh.author.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xh.author.pojo.XhUser;

/**
 * @author xt
 * @date 2020/9/20
 */

public interface UserService extends IService<XhUser> {

    XhUser loadUserByUsername(String name);

}
