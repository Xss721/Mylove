package com.xss.service.impl;

import com.xss.dao.logDao;
import com.xss.service.loginService;
import com.xss.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    private logDao logDao;

    private PasswordUtil passwordUtil;

    public boolean selectPasswordByUsername(String username, String password) {
        String passwordByUsername = logDao.selectPasswordByUsername(username);
        return password.equals(passwordUtil.decode(passwordByUsername));//将密码解密后进行对比
    }

    public boolean AddNewUser(String username, String password) {
        if (null==username||logDao.selectByUsername(username)!=null|| password.equals(null)) return false;
        logDao.insertOneUser(username, passwordUtil.encode(password));//对密码进行加密存储
        return true;
    }
}
