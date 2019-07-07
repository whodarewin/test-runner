package com.hc.test.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hc.test.runner.scanner.Scanner;
import com.hc.test.util.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by congcong.han on 2019/6/15.
 */
public class TreeNodeServlet  extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(TreeNodeServlet.class);
    private static final String PATH = "path";
    private ThreadLocal<Integer> ids = new ThreadLocal<Integer>() {
        protected Integer initialValue () {
            return 0;
        }
    };
    private Scanner scanner = new Scanner();
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ResponseUtil.setJsonMeta(resp);
        ResponseUtil.setUTF_8Meta(resp);
        ResponseUtil.setUTF_8Meta(req);
        ids.set(0);
        String path = req.getParameter(PATH);
        Set<String> classes = scanner.scanAllClasses(path);
        List<TreeNode> treeNodes = packageNodes(classes);
        String retJson = mapper.writeValueAsString(treeNodes);
        resp.getWriter().write(retJson);
        resp.getWriter().close();
    }

    private List<TreeNode> packageNodes(Set<String> classes){
        Map<Character, List<String>> prefix2Classes = new TreeMap<>();
        for(String className : classes){
            String[] splits = StringUtils.split(className,'.');
            Character prefix = splits[splits.length-1].charAt(0);
            prefix2Classes.compute(prefix,(k,v) -> {
                if(v == null){
                    v = new ArrayList<>();
                }
                v.add(className);
                return v;
            });
        }
        List<TreeNode> ret = new ArrayList<>();
        for (Map.Entry<Character,List<String>> entry :  prefix2Classes.entrySet()){
            ret.add(packageOneNode(entry.getKey(),entry.getValue()));
        }
        return ret;
    }

    private TreeNode packageOneNode(Character key, List<String> value) {
        Collections.sort(value);
        TreeNode treeNode = new TreeNode();
        treeNode.setName(key.toString());
        List<TreeNode> subNodes = new ArrayList<>();
        for(String className : value){
            TreeNode subNode = new TreeNode();
            subNode.setName(className);
            subNodes.add(subNode);
        }
        treeNode.setChildren(subNodes);
        return treeNode;
    }
}
