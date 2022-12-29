package cn.lu.lrp.service;

import cn.lu.lrp.entity.User;

public interface UserService {

    /**
     * 登录
     *
     * @param userName
     * @return
     */
    User selectByUsername(String userName);


}
