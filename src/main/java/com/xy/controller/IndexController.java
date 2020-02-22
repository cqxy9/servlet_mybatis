package com.xy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.dao.GetSqlSession;
import com.xy.entity.TempEntity;
import com.xy.mapper.TempEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
  * Copyright 软件技术有限公司
  * All rights reserved
  *
  * @Description:
  *
  * @Author: XY
  * @Date: 2020/2/22
  */
@WebServlet("/index")
public class IndexController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("1测试进来啦");
        try {
            TempEntityMapper mapper = GetSqlSession.getSqlSession().getMapper(TempEntityMapper.class);
            Integer count = mapper.selectCount();
            log.info("总条数" + count);
            PageHelper.startPage(1, 3);
            List<TempEntity> tempEntities = mapper.selectAll();
            PageInfo<TempEntity> pageInfo = new PageInfo<>(tempEntities);
            log.info("分页总条数" + pageInfo.getTotal());
            log.info("分页数据" + pageInfo.getList());

            if (null != tempEntities) {
                TempEntity tempEntity = tempEntities.get(0);
                tempEntity.setId(tempEntity.getId() + 1);
                mapper.insert(tempEntity);
            }
        } catch (Exception e) {
            GetSqlSession.rollback();
            log.error("index异常", e);
        } finally {
            GetSqlSession.commit();
        }
        log.info("1测试结束啦");
    }
}
