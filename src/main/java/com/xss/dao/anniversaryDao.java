package com.xss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xss.pojo.anniversary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Resource;
import java.util.List;


@Mapper
public interface anniversaryDao extends BaseMapper<anniversary> {
    @Select(value = "select anniversaryid,anniversaryname,anniversarytime,anniversarytext from anniversary where userid=#{userid}")
    List<anniversary> selectanniversaryByUserId(int userid);
}
