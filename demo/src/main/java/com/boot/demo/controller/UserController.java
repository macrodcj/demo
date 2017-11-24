package com.boot.demo.controller;

import com.boot.demo.service.UserService;
import com.boot.demo.utils.ResponseDO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户列表", httpMethod = "GET", tags = {"user"})
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userName", value = "名称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "age", value = "年龄", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "text", value = "简介", required = false, dataType = "String", paramType = "query")
    })
    @GetMapping("/getlist")
    public ResponseDO getlist(@RequestParam(value = "userName", required = false) String userName,
                              @RequestParam(value = "text", required = false) String text,
                              @RequestParam(value = "age", required = false) Integer age) {
        return new ResponseDO(userService.getlist(userName, age, text));
    }

    @ApiOperation(value = "删除用户", httpMethod = "GET", tags = {"user"})
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", value = "ID", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/delete")
    public ResponseDO deleteUser(@RequestParam(value = "userId", required = true) Integer userId) {
        return new ResponseDO(userService.delete(userId));
    }

    @ApiOperation(value = "添加用户", httpMethod = "POST", tags = {"user"})
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userName", value = "名称", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int", paramType = "form"),
            @ApiImplicitParam(name = "text", value = "简介", required = true, dataType = "String", paramType = "form")
    })
    @PostMapping("/add")
    public ResponseDO addUser(@RequestParam(value = "userName", required = true) String userName,
                              @RequestParam(value = "age", required = true) Integer age,
                              @RequestParam(value = "text", required = true) String text) {
        return new ResponseDO(userService.insert(userName, text, age));
    }


    @ApiOperation(value = "修改用户", httpMethod = "POST", tags = {"user"})
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", value = "ID", required = true, dataType = "int", paramType = "form"),
            @ApiImplicitParam(name = "userName", value = "名称", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int", paramType = "form"),
            @ApiImplicitParam(name = "text", value = "简介", required = true, dataType = "String", paramType = "form")
    })
    @PostMapping("/update")
    public ResponseDO updateUser(@RequestParam(value = "userId", required = true) Integer userId,
                                 @RequestParam(value = "userName", required = true) String userName,
                                 @RequestParam(value = "text", required = true) String text,
                                 @RequestParam(value = "age", required = true) Integer age) {
        return new ResponseDO(userService.update(userId, userName, text, age));
    }

}
