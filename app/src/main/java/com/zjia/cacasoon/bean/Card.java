package com.zjia.cacasoon.bean;

import org.cocos2d.nodes.CCSprite;

/**
 * Created by ZJIA on 2017/5/16 0016.
 */

public abstract class Card {
    // 卡片的唯一编号（通过其找对应的图片）
    protected String id;
    // 上边界
    protected int top;
    // 下边界
    protected int bottom;
    // 左边界
    protected int left;
    // 右边界
    protected int right;
    // 旋转次数
    protected int rotateTimes;

    protected String img;

    /**
     * 边界类型常量
     * GRESS : 草地
     * RODA  : 道路
     * CITY  : 城市
     * RIVER : 河流
     */
    public static final int GRESS = 0;
    public static final int ROAD = 1;
    public static final int CITY = 2;
    public static final int RIVER = 3;

    /**
     * 布尔常量
     */
    public static final int FALSE = 0;
    public static final int TRUE = 1;

    public Card() {
    }

    public Card(String id, int top, int bottom, int left, int right, int rotateTimes, String img) {
        this.id = id;
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.rotateTimes = rotateTimes;
        this.img = img;
    }

    /**
     * 旋转
     */
    public abstract void rotate();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getRotateTimes() {
        return rotateTimes;
    }

    public void setRotateTimes(int rotateTimes) {
        this.rotateTimes = rotateTimes;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", top=" + top +
                ", bottom=" + bottom +
                ", left=" + left +
                ", right=" + right +
                ", rotateTimes=" + rotateTimes +
                ", img='" + img + '\'' +
                '}';
    }
}
