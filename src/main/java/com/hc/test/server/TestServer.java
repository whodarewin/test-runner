package com.hc.test.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class TestServer{

    private static final int port = 9999;

    public static void main(String[] args) throws Exception {
        new TestServer().start();
    }
    public void start() throws Exception {
        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //所有请求都要经过jetty
        context.setContextPath("/");
        server.setHandler(context);
        //配置servlet请求路径
        context.addServlet(new ServletHolder(new HelloServlet()), "/");

        server.start();
        server.join();
    }
}
