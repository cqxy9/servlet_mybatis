package com.xy.controller;

import com.xy.entity.SysUserEntity;
import com.xy.mapper.SysUserEntityMapper;
import com.xy.dao.GetSqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index2")
public class Index2Controller extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(Index2Controller.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("2测试进来啦");
        try {
            SysUserEntityMapper mapper = GetSqlSession.getSqlSession().getMapper(SysUserEntityMapper.class);
            SysUserEntity sue = new SysUserEntity();
            sue.setId(12);
            sue.setName("sfsf测试");
            mapper.insert(sue);
        } catch (Exception e) {
            GetSqlSession.rollback();
        } finally {
            GetSqlSession.commit();
        }
        log.info("2测试结束啦");
    }
}
