package com.de.userserver.service.impl;

import com.de.userserver.model.OauthClientDetails;
import com.de.userserver.dao.OauthClientDetailsDao;
import com.de.userserver.service.IOauthClientDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.de.publicpackage.page.PageRes;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiuMinghao
 * @since 2021-01-04
 */
@Service
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsDao, OauthClientDetails> implements IOauthClientDetailsService {
    @Autowired
    OauthClientDetailsDao  thisMapper;

    @Override
    public List<OauthClientDetails> selectList(OauthClientDetails reqModel){
        List<OauthClientDetails> listRes = thisMapper.selectList(new QueryWrapper<OauthClientDetails>(reqModel));;
        return listRes;
    }
    @Override
    public PageRes selectPage(OauthClientDetails reqModel) {
        Page<OauthClientDetails> pageset = new Page<>(5,10);
        IPage<OauthClientDetails> selectPageRes = thisMapper.selectPage(pageset,new QueryWrapper<OauthClientDetails>(reqModel));
        return new PageRes(selectPageRes.getTotal(),5,10,selectPageRes.getRecords());
    }
    @Override
    public void insert(OauthClientDetails reqModel){
        thisMapper.insert(reqModel);
    }
    @Override
    public boolean updateById(OauthClientDetails reqModel){
        int updateRes = thisMapper.updateById(reqModel);
        return true;
    }
    @Override
    public void deleteById(String id){
        thisMapper.deleteById(id);
    }
    @Override
    public OauthClientDetails getById(String id) {
        OauthClientDetails getByIdRes = thisMapper.selectById(id);
        return getByIdRes;
    }
}
