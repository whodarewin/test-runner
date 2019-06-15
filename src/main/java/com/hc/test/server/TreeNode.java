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

    private String text;
    private String icon;
    private String selectedIcon;
    private String color;
    private String backColor;
    private String href;
    private boolean selectable;
    private TreeState state;
    private List<TreeNode> nodes;

    public TreeNode(){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSelectedIcon() {
        return selectedIcon;
    }

    public void setSelectedIcon(String selectedIcon) {
        this.selectedIcon = selectedIcon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackColor() {
        return backColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public TreeState getState() {
        return state;
    }

    public void setState(TreeState state) {
        this.state = state;
    }

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {
        this.nodes = nodes;
    }

    public static TreeNode defaultTreeNode(){
        TreeNode treeNode = new TreeNode();
        treeNode.setBackColor(TreeNode.WHITE_COLOR);
        treeNode.setColor(TreeNode.BLACK_COLOR);
        treeNode.setIcon(TreeNode.ICON);
        treeNode.setSelectedIcon(TreeNode.SECELETED_ICON);
        treeNode.setSelectable(true);
        treeNode.setState(TreeState.defaultTreeState());
        return treeNode;
    }
}
