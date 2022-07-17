package com.atguigu.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * LocalFilter
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/13 14:22
 **/
@WebFilter(filterName = "localFilter",urlPatterns = "/*")
@Slf4j
public class LocalFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("进入filter");
        chain.doFilter(request,response);
        log.info("退出filter");
    }
}
