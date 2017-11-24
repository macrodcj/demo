package com.boot.demo.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.boot.demo.domain.User;
import com.boot.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adminstrator on 2017/11/24.
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {


    /**
     * 添加
     * ID设为自增长
     */
    public boolean insert(String userName, String text, Integer age) {
        User user = new User();
        user.setName(userName);
        user.setText(text);
        user.setAge(age);
        return insert(user);
    }

    /**
     * 根据主键ID，修改对象
     */
    public boolean update(Integer id, String userName, String text, Integer age) {
        User user = selectById(id);
        if (user != null) {
            user.setName(userName);
            user.setText(text);
            user.setAge(age);
            return updateById(user);
        }
        return false;
    }

    /**
     * 根据主键ID，删除对象
     *
     * @param id
     * @return
     */
    public boolean delete(Integer id) {
        return deleteById(id);
    }

    /**
     * 获取列表
     *
     * @return
     */
    public List<User> getlist(String name, Integer age, String text) {
        return baseMapper.getlist(name, age, text);
    }

}