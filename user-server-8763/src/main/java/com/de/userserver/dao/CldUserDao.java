package com.de.userserver.dao;

import com.de.userserver.model.CldUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LiuMinghao
 * @since 2020-12-25
 */
@Repository
public interface CldUserDao extends BaseMapper<CldUser> {
            //public List<CldUser> findList(CldUser reqModel);
        }
