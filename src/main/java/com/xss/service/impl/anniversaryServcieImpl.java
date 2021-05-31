package com.xss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xss.dao.anniversaryDao;
import com.xss.pojo.anniversary;
import com.xss.service.anniversaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class anniversaryServcieImpl  implements anniversaryService {
    @Autowired
    private anniversaryDao anniversaryDao;

    public List<anniversary> selectanniversaryByUserId(int userid){
        return anniversaryDao.selectanniversaryByUserId(userid);
    }
    public IPage<anniversary> selectByUserId(int userid,int pagNum){
//        anniversaryDao.selectPage(new Page<>())
        return anniversaryDao.selectPage(new Page<>(pagNum,3),
                new QueryWrapper<anniversary>().eq("userid",userid));
    }
}
