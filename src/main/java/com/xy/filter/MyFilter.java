package com.xy.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Copyright 软件技术有限公司
 * All rights reserved
 *
 * @Description:
 * @Author: XY
 * @Date: 2020/2/26
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "noLoginPaths", value = "login.jsp;/login")
})
public class MyFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig config) throws ServletException {
        log.info("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        log.info("进入过滤器");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("过滤器销毁");
    }
}
