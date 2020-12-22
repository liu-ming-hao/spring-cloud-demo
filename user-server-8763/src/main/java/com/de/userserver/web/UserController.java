package com.de.userserver.web;

import com.de.userserver.model.User;//dao
import com.de.userserver.service.IUserService;//service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

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
public class UserController {
    @Autowired
    private IUserService thisService;

    @PostMapping("/findList")
    public List<User> findList(@RequestBody User reqModel){
        List<User> listRes = thisService.findList(reqModel);
        return listRes;
    }
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

