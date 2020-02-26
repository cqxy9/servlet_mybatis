package com.xy.controller;

import com.xy.dao.GetSqlSession;
import com.xy.entity.EasyCodeTest;
import com.xy.mapper.EasyCodeTestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
  * Copyright 软件技术有限公司
  * All rights reserved
  * 
  * @Description: 
  * 
  * @Author: XY
  * @Date: 2020/2/26
  */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("登录进来");
        try {
            EasyCodeTestMapper easyCodeTestMapper = GetSqlSession.getSqlSession().getMapper(EasyCodeTestMapper.class);

            EasyCodeTest easyCodeTest = new EasyCodeTest();
            easyCodeTest.setId(1);
            easyCodeTest.setAbc("撒大大");
            easyCodeTest.setQwe("是的是的");
            easyCodeTestMapper.insert(easyCodeTest);
        } catch (Exception e) {
            log.error("login", e);
            GetSqlSession.rollback();
        } finally {
            GetSqlSession.commit();
        }
    }
}
