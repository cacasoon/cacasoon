package com.zjia.cacasoon.bean;


/**
 * Created by ZJIA on 2017/5/16 0016.
 */

public class BasicCard extends Card{
    // 是否有教堂
    private int church;
    // 城市是否连接
    private int cityLink;
    // 道路是否连接
    private int roadLink;
    // 是否有盾牌
    private int shield;

    public BasicCard() {
    }

    public BasicCard(String id, int top, int bottom, int left, int right, int rotateTimes, String img, int church, int cityLink, int roadLink, int shield) {
        super(id, top, bottom, left, right, rotateTimes, img);
        this.church = church;
        this.cityLink = cityLink;
        this.roadLink = roadLink;
        this.shield = shield;
    }

    @Override
    public void rotate() {
        int temp;
        switch (rotateTimes % 4){
            case 1 :
                temp = top;
                top = left;
                left = bottom;
                bottom = right;
                right = temp;
                break;
            case 2 :
                temp = top;
                top = bottom;
                bottom = top;
                temp = left;
                left = right;
                right = left;
                break;
            case 3 :
                temp = top;
                top = right;
                right = bottom;
                bottom = left;
                left = right;
                break;
        }
    }

    public int getChurch() {
        return church;
    }

    public void setChurch(int church) {
        this.church = church;
    }

    public int getCityLink() {
        return cityLink;
    }

    public void setCityLink(int cityLink) {
        this.cityLink = cityLink;
    }

    public int getRoadLink() {
        return roadLink;
    }

    public void setRoadLink(int roadLink) {
        this.roadLink = roadLink;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }


    @Override
    public String toString() {
        return "BasicCard{" +
                "church=" + church +
                ", cityLink=" + cityLink +
                ", roadLink=" + roadLink +
                ", shield=" + shield +
                "} " + super.toString();
    }
}
