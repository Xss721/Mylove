package com.xss.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Mapper
@Repository
public interface logDao {
    String getpasswordByusername(String username);
}
