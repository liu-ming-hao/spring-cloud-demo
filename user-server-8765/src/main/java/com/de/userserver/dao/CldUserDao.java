package com.de.userserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.de.userserver.model.CldUser;
import org.springframework.stereotype.Repository;

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
