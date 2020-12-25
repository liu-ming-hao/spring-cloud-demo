package com.de.userserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.de.publicpackage.page.PageRes;
import com.de.userserver.dao.CldUserDao;
import com.de.userserver.model.CldUser;
import com.de.userserver.service.ICldUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiuMinghao
 * @since 2020-12-25
 */
@Service
public class CldUserServiceImpl extends ServiceImpl<CldUserDao, CldUser> implements ICldUserService {
    @Autowired
    CldUserDao  thisMapper;

    @Override
    public List<CldUser> selectList(CldUser reqModel){
        List<CldUser> listRes = thisMapper.selectList(new QueryWrapper<CldUser>(reqModel));;
        return listRes;
    }
    @Override
    public PageRes selectPage(CldUser reqModel) {
        Page<CldUser> pageset = new Page<>(5,10);
        IPage<CldUser> selectPageRes = thisMapper.selectPage(pageset,new QueryWrapper<CldUser>(reqModel));
        return new PageRes(selectPageRes.getTotal(),5,10,selectPageRes.getRecords());
    }
    @Override
    public void insert(CldUser reqModel){
        thisMapper.insert(reqModel);
    }
    @Override
    public boolean updateById(CldUser reqModel){
        int updateRes = thisMapper.updateById(reqModel);
        return true;
    }
    @Override
    public void deleteById(String id){
        thisMapper.deleteById(id);
    }
    @Override
    public CldUser getById(String id) {
        CldUser getByIdRes = thisMapper.selectById(id);
        return getByIdRes;
    }
}
