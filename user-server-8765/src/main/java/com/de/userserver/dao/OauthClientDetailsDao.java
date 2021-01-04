package com.de.userserver.dao;

import com.de.userserver.model.OauthClientDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LiuMinghao
 * @since 2021-01-04
 */
@Repository
public interface OauthClientDetailsDao extends BaseMapper<OauthClientDetails> {
            //public List<OauthClientDetails> findList(OauthClientDetails reqModel);
        }
