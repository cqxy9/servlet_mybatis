package com.xy.controller;

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

            List<TempEntity> tempEntities = mapper.selectAll();

//            PageHelper.startPage(1, 2);
//            List<TempEntity> tempEntities = mapper.selectAll();
//            PageInfo<TempEntity> pageInfo = new PageInfo<TempEntity>(tempEntities);
//            pageInfo.getTotal();
//            pageInfo.getList();

            log.info(tempEntities.toString());

            if (null != tempEntities) {
                TempEntity tempEntity = tempEntities.get(count - 1);
                tempEntity.setId(tempEntity.getId() + 1);
                mapper.insert(tempEntity);
            }
        } catch (Exception e) {
            GetSqlSession.rollback();
            log.error("index", e);
        } finally {
            GetSqlSession.commit();
        }
        log.info("1测试结束啦");
    }
}
