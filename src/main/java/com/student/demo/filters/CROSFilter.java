package com.aai.firstproject.filters;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CROSFilter extends GenericFilterBean implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");// http://localhost
        response.setHeader("Access-Control-Allow-Methods", "*");//POST, PUT, GET, OPTIONS, DELETE
        response.setHeader("Access-Control-Allow-Headers", "*");//x-requested-with
        response.setHeader("Access-Control-Allow-Credentials", "false");//true
        response.setHeader("Access-Control-Max-Age", "3600");
        chain.doFilter(req, res);
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}