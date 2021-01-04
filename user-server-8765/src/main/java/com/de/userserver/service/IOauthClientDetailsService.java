package com.de.userserver.service;

import com.de.userserver.model.OauthClientDetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.de.publicpackage.page.PageRes;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiuMinghao
 * @since 2021-01-04
 */
public interface IOauthClientDetailsService extends IService<OauthClientDetails> {
    public List<OauthClientDetails> selectList(OauthClientDetails reqModel);
    public PageRes selectPage(OauthClientDetails reqModel);
    public void insert(OauthClientDetails reqModel);
    public boolean updateById(OauthClientDetails reqModel);
    public void deleteById(String id);
    public OauthClientDetails getById(String id);
}
