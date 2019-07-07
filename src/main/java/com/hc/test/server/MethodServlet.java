package com.hc.test.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hc.test.runner.scanner.MethodInfo;
import com.hc.test.runner.scanner.Scanner;
import com.hc.test.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by congcong.han on 2019/7/7.
 */
public class MethodServlet  extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(TreeNodeServlet.class);
    private static final String CLASS_NAME = "class.name";
    private Scanner scanner = new Scanner();
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ResponseUtil.setJsonMeta(resp);
        ResponseUtil.setUTF_8Meta(resp);
        ResponseUtil.setUTF_8Meta(req);
        String className = req.getParameter(CLASS_NAME);
        Set<MethodInfo> methodInfos = null;
        try {
            methodInfos = scanner.scanAllMethods(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<TreeNode> treeNodes = packageNodes(methodInfos);
        String retJson = mapper.writeValueAsString(treeNodes);
        resp.getWriter().write(retJson);
        resp.getWriter().close();
    }

    private List<TreeNode> packageNodes(Set<MethodInfo> methodInfos){
        List<TreeNode> nodes = new ArrayList<>();
        for(MethodInfo methodInfo : methodInfos){
            TreeNode treeNode = new TreeNode();
            treeNode.setName(methodInfo.getName());
            List<TreeNode> childrens = new ArrayList<>();
            treeNode.setChildren(childrens);
            List<String> params = methodInfo.getParamTypes();
            for(String param : params){
                TreeNode node = new TreeNode();
                node.setName(param);
                childrens.add(node);
            }
            nodes.add(treeNode);
        }
        return nodes;
    }
}
