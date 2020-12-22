package com.de.userserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.de.userserver.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * APP用户表 Mapper 接口
 * </p>
 *
 * @author LiuMinghao
 * @since 2020-12-21
 */
@Repository
public interface UserDao extends BaseMapper<User> {
            public List<User> findList(User reqModel);
        }
