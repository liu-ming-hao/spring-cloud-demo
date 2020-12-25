package com.de.userserver.service;

import com.de.userserver.model.CldUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.de.publicpackage.page.PageRes;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiuMinghao
 * @since 2020-12-25
 */
public interface ICldUserService extends IService<CldUser> {
    public List<CldUser> selectList(CldUser reqModel);
    public PageRes selectPage(CldUser reqModel);
    public void insert(CldUser reqModel);
    public boolean updateById(CldUser reqModel);
    public void deleteById(String id);
    public CldUser getById(String id);
}
