package com.de.userserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.de.userserver.model.User;

import java.util.List;

/**
 * <p>
 * APP用户表 服务类
 * </p>
 *
 * @author LiuMinghao
 * @since 2020-12-21
 */
public interface IUserService extends IService<User> {
    public List<User> findList(User reqModel);
    public void insert(User reqModel);
    public boolean updateById(User reqModel);
    public void deleteById(String id);
    public User getById(String id);
}
