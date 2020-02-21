package com.xy.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetSqlSession {
    private static final Logger log = LoggerFactory.getLogger(GetSqlSession.class);

    private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();

    public static SqlSession getSqlSession() throws Exception {
        SqlSession sqlSession = tl.get();
        if (null == sqlSession) {
            sqlSession = GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
            tl.set(sqlSession);
        }
        log.info("Get SqlSession hashCode : {}.", sqlSession.hashCode());
        return sqlSession;
    }

    public static void commit() {
        SqlSession sqlSession = tl.get();
        if (null != sqlSession) {
            sqlSession.commit();
            sqlSession.close();
            tl.set(null);
            log.info("SqlSession commit.");
        }
    }

    public static void rollback() {
        SqlSession sqlSession = tl.get();
        if (null != sqlSession) {
            sqlSession.rollback();
            sqlSession.close();
            tl.set(null);
            log.info("SqlSession rollback.");
        }
    }

    public static void queryClose() {
        SqlSession sqlSession = tl.get();
        if (null != sqlSession) {
            sqlSession.close();
            tl.set(null);
            log.info("SqlSession close.");
        }
    }
}
