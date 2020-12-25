package com.de.userserver.web;

import com.de.userserver.model.CldUser;//dao
import com.de.userserver.service.ICldUserService;//service

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
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/cldUser")
@Slf4j
public class CldUserController {
    @Autowired
    private ICldUserService thisService;

    @PostMapping("/selectList")
    public Result<List<CldUser>> selectList(@RequestBody CldUser reqModel){
        try{
            List<CldUser> listRes = thisService.selectList(reqModel);
            return Result.success(listRes);
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(new CodeMsg(-1,"模板默认返回"));
        }
    }
    @PostMapping("/selectPage")
    public Result<PageRes> selectPage(@RequestBody CldUser reqModel){
        try{
            PageRes listRes = thisService.selectPage(reqModel);
            return Result.success(listRes);
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(new CodeMsg(-1,"模板默认返回"));
        }
    };
    @PostMapping("/insert")
    public void insert(@RequestBody CldUser reqModel){
        try{
            thisService.insert(reqModel);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
    @PostMapping("/updateById")
    public void updateById(@RequestBody CldUser reqModel){
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
    public CldUser getById(@RequestParam("id") String id){
        try{
            return thisService.getById(id);
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}

