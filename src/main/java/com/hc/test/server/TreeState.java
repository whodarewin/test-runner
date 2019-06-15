package com.hc.test.server;

/**
 * Created by congcong.han on 2019/6/15.
 */
public class TreeState {
    private boolean checked;
    private boolean expanded;
    private boolean selected;
    private boolean disabled;

    public TreeState(){}

    public TreeState(boolean checked, boolean expanded, boolean selected, boolean disabled) {
        this.checked = checked;
        this.expanded = expanded;
        this.selected = selected;
        this.disabled = disabled;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public static TreeState defaultTreeState(){
        return new TreeState(false,false,false,false);
    }
}
