package com.hc.test.server;

import org.eclipse.jetty.server.Server;

public class TestServer{

    private static final int port = 9999;

    public static void main(String[] args) throws Exception {
        new TestServer().start();
    }
    public void start() throws Exception {
        Server server = new Server(port);
        server.start();
    }
}
