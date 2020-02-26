package com.xy.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
  * Copyright 软件技术有限公司
  * All rights reserved
  *
  * @Description:
  *
  * @Author: XY
  * @Date: 2020/2/26
  */
public class GetSqlSessionFactory {
    private static final Logger log = LoggerFactory.getLogger(GetSqlSessionFactory.class);
    private SqlSessionFactory sqlSessionFactory;

    private static class GetSqlSessionFactoryHoler {
        private static final GetSqlSessionFactory instance = new GetSqlSessionFactory();
    }

    public static GetSqlSessionFactory getInstance() {
        return GetSqlSessionFactoryHoler.instance;
    }

    private GetSqlSessionFactory() {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            log.error("获取mybatis配置异常", e);
        }
    }

    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        if (null == sqlSessionFactory){
            throw new Exception("sqlSessionFactory为空请检查配置。");
        }
        return sqlSessionFactory;
    }
}
