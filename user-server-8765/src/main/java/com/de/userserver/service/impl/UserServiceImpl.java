package com.de.userserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.de.publicpackage.page.PageRes;
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
    public List<User> selectList(User reqModel){
        List<User> listRes = thisMapper.selectList(new QueryWrapper<User>(reqModel));
        return listRes;
    }

    @Override
    public PageRes selectPage(User reqModel) {
        Page<User> pageset = new Page<>(5,10);
        IPage<User> selectPageRes = thisMapper.selectPage(pageset,new QueryWrapper<User>(reqModel));
        return new PageRes(selectPageRes.getTotal(),5,10,selectPageRes.getRecords());
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
