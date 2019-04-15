package com.hc.test.server;

import org.eclipse.jetty.server.Server;

public class TestServer {

    public static void main(String[] args) throws Exception {
        new TestServer().start();
    }
    public void start() throws Exception {
        int port = 9999;
        Server server = new Server(port);
        server.start();
    }
}
