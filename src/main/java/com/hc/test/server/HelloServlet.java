package com.hc.test.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HandlerServlet
 *
 * @author han.congcong
 * @date 2019/6/4
 */

public class HelloServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=UTF-8");
        LOGGER.info("servlet init success");
        resp.getWriter().write("servlet init success");
        resp.getWriter().close();
    }
}
