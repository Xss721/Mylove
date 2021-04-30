package com.xss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xss.pojo.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



@Mapper
@Repository
public interface logDao extends BaseMapper<user> {
    @Select(value = "select password from user where username = #{username}")
    String selectPasswordByUsername(String username);
    @Insert("insert into user(username , password) values(#{username},#{password})")
    void insertOneUser(String username,String password);
}
