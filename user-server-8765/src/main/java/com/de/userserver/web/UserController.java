package com.de.userserver.web;

import com.de.publicpackage.page.PageRes;
import com.de.publicpackage.result.CodeMsg;
import com.de.publicpackage.result.Result;
import com.de.userserver.model.User;
import com.de.userserver.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * APP用户表 前端控制器
 * </p>
 *
 * @author LiuMinghao
 * @since 2020-12-21
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private IUserService thisService;

    @PostMapping("/selectList")
    public Result<List<User>> selectList(@RequestBody User reqModel){
        try{
            List<User> listRes = thisService.selectList(reqModel);
            return Result.success(listRes);
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(CodeMsg.FIND_LIST_ERROR);
        }
    }
    @PostMapping("/selectPage")
    public Result<PageRes>  selectPage(@RequestBody User reqModel){
        try{
            PageRes listRes = thisService.selectPage(reqModel);
            return Result.success(listRes);
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(CodeMsg.FIND_LIST_ERROR);
        }
    };
    @PostMapping("/insert")
    public void insert(@RequestBody User reqModel){
        thisService.insert(reqModel);
    }
    @PostMapping("/updateById")
    public void updateById(@RequestBody User reqModel){
        thisService.updateById(reqModel);
    }
    @PostMapping("/deleteById")
    public void deleteById(@RequestParam("id") String id){
        thisService.deleteById(id);
    }
    @GetMapping("/getById")
    public User getById(@RequestParam("id") String id){
        return thisService.getById(id);
    }
}

