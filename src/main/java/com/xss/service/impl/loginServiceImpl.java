package com.xss.service.impl;

import com.xss.dao.logDao;
import com.xss.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    private logDao logDao;

    @Override
    public String login(String username) {
        return logDao.getpasswordByusername(username);
    }
}
