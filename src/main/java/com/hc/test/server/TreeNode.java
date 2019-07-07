package com.hc.test.server;

import java.util.List;

/**
 * Created by congcong.han on 2019/6/15.
 */
public class TreeNode {
    public static final String ICON = "glyphicon glyphicon-play-circle";
    public static final String SECELETED_ICON = "glyphicon glyphicon-ok";
    public static final String RED_COLOR = "#ff0000";
    public static final String BLUE_COLOR = "#1606ec";
    public static final String WHITE_COLOR = "#000000";
    public static final String BLACK_COLOR = "#ffffff";

    private String name;
    private List<TreeNode> children;

    public TreeNode(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
