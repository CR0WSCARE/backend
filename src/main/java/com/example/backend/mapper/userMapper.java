package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userMapper extends BaseMapper<user> {
    @Select("SELECT * FROM admin WHERE name = #{username}")
    user selectByName(String username);
}
