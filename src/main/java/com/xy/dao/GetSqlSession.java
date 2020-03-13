package com.xy.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright 软件技术有限公司
 * All rights reserved
 *
 * @Description:数据交互
 * @Author: XY
 * @Date: 2020/2/26
 */
public class GetSqlSession {
    private static final Logger log = LoggerFactory.getLogger(GetSqlSession.class);

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    public static SqlSession getSqlSession() throws Exception {
        SqlSession sqlSession = threadLocal.get();
        if (null == sqlSession) {
            sqlSession = GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
            threadLocal.set(sqlSession);
        }
        log.info("数据session hashCode : {}.", sqlSession.hashCode());
        return sqlSession;
    }

    public static void commit() {
        SqlSession sqlSession = threadLocal.get();
        if (null != sqlSession) {
            sqlSession.commit();
            sqlSession.close();
            threadLocal.remove();
            log.info("数据commit");
        }
    }

    public static void rollback() {
        SqlSession sqlSession = threadLocal.get();
        if (null != sqlSession) {
            sqlSession.rollback();
            sqlSession.close();
            threadLocal.remove();
            log.info("数据rollback");
        }
    }

    public static void queryClose() {
        SqlSession sqlSession = threadLocal.get();
        if (null != sqlSession) {
            sqlSession.close();
            threadLocal.remove();
            log.info("获取数据流close");
        }
    }
}
