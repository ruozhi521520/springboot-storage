package cn.lu.lrp.service.impl;

import cn.lu.lrp.dto.UserMapper;
import cn.lu.lrp.entity.User;
import cn.lu.lrp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    /**
     * 登录
     *
     * @param userName
     * @return
     */
    @Override
    public User selectByUsername(String userName) {
        return userMapper.selectByUsername(userName);
    }
}
