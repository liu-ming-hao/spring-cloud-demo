package com.de.userserver.web;

import com.de.userserver.model.OauthClientDetails;//dao
import com.de.userserver.service.IOauthClientDetailsService;//service

import com.de.publicpackage.page.PageRes;
import com.de.publicpackage.result.CodeMsg;
import com.de.publicpackage.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiuMinghao
 * @since 2021-01-04
 */
@Slf4j
@RestController
@RequestMapping("/oauthClientDetails")
public class OauthClientDetailsController {
    @Autowired
    private IOauthClientDetailsService thisService;

    @PostMapping("/selectList")
    public Result<List<OauthClientDetails>> selectList(@RequestBody OauthClientDetails reqModel){
        try{
            List<OauthClientDetails> listRes = thisService.selectList(reqModel);
            return Result.success(listRes);
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(new CodeMsg(-1,"模板默认返回"));
        }
    }
    @PostMapping("/selectPage")
    public Result<PageRes> selectPage(@RequestBody OauthClientDetails reqModel){
        try{
            PageRes listRes = thisService.selectPage(reqModel);
            return Result.success(listRes);
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(new CodeMsg(-1,"模板默认返回"));
        }
    };
    @PostMapping("/insert")
    public void insert(@RequestBody OauthClientDetails reqModel){
        try{
            thisService.insert(reqModel);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
    @PostMapping("/updateById")
    public void updateById(@RequestBody OauthClientDetails reqModel){
        try{
            thisService.updateById(reqModel);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
    @PostMapping("/deleteById")
    public void deleteById(@RequestParam("id") String id){
        try{
            thisService.deleteById(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
    @GetMapping("/getById")
    public OauthClientDetails getById(@RequestParam("id") String id){
        try{
            return thisService.getById(id);
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}

