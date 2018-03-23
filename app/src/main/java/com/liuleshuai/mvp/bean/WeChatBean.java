package com.liuleshuai.mvp.bean;

/**
 * Created by LiuKuo at 2018/3/23
 */

public class WeChatBean {
    private int drawable;
    private String text;

    public WeChatBean(String text, int drawable) {
        this.text = text;
        this.drawable = drawable;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
