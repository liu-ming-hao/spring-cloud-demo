package com.de.userserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.de.userserver.dao.UserDao;
import com.de.userserver.model.User;
import com.de.userserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * APP用户表 服务实现类
 * </p>
 *
 * @author LiuMinghao
 * @since 2020-12-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Autowired
    UserDao  thisMapper;
    @Override
    public List<User> findList(User reqModel){
        List<User> listRes = thisMapper.findList(reqModel);
        return listRes;
    }
    @Override
    public void insert(User reqModel){
        thisMapper.insert(reqModel);
    }
    @Override
    public boolean updateById(User reqModel){
        int updateRes = thisMapper.updateById(reqModel);
        return true;
    }
    @Override
    public void deleteById(String id){
        thisMapper.deleteById(id);
    }
    @Override
    public User getById(String id) {
        User getByIdRes = thisMapper.selectById(id);
        return getByIdRes;
    }
}
