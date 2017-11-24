package com.boot.demo.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.boot.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> getlist(@Param("name") String name, @Param("age") Integer age, @Param("text") String text);

}
