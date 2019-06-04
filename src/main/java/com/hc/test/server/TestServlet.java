package com.hc.test.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import com.hc.test.runner.TestApi;
import com.hc.test.runner.TestParam;
import com.hc.test.runner.serialize.JsonSerialize;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * TestServlet
 *
 * @author han.congcong
 * @date 2019/6/4
 */

public class TestServlet extends HttpServlet {
    private TestApi api;

    public TestServlet(ApplicationContext context){
        api = new TestApi(new JsonSerialize<>(TestParam.class),context);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=UTF-8");
        InputStream inputStream = req.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        String json = CharStreams.toString(reader);
        try {
            Object o = api.test(json);
            resp.getWriter().write(new ObjectMapper().writeValueAsString(o));
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }

        resp.getWriter().close();
    }
}
