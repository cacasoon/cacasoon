package com.zjia.cacasoon.view;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.view.MotionEvent;

import com.zjia.cacasoon.util.DrawUtils;

import org.cocos2d.layers.CCTMXTiledMap;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItem;
import org.cocos2d.menus.CCMenuItemSprite;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

import java.io.File;

/**
 * 地图场景
 */
public class MapScene extends ModelLayer {

    private static int MAP_TAG = 1;
    private static int NOW_CARD_TAG = 5;

    private CCTMXTiledMap map;
    private CCSprite nowCardBg;

    public MapScene() {
        super();
        init();
    }

    private void init() {
        map = CCTMXTiledMap.tiledMap("basic_map.tmx");
        map.setAnchorPoint(0.5f, 0.5f);
        map.setPosition(winSize.getWidth() / 2, winSize.getHeight() / 2);
        this.addChild(map, MAP_TAG, MAP_TAG);

        nowCardBg = CCSprite.sprite("now_bg.png");
        nowCardBg.setAnchorPoint(1, 1);
        nowCardBg.setPosition(winSize.getWidth(), winSize.getHeight());
        this.addChild(nowCardBg, NOW_CARD_TAG, NOW_CARD_TAG);

        DrawUtils.drawByGameData(nowCardBg,map);
    }


    @Override
    public boolean ccTouchesBegan(MotionEvent event) {

        return super.ccTouchesBegan(event);
    }

    @Override
    public boolean ccTouchesMoved(MotionEvent event) {
        // 地图的拖动
        // 初始化：地图和屏幕的宽高，当前的点，事件之前的有效点，将坐标点转换为gl坐标点
        // 判断地图的x，y坐标的取值范围，纠正坐标
        map.touchMove(event, map);
        return super.ccTouchesMoved(event);
    }

    @Override
    public boolean ccTouchesEnded(MotionEvent event) {
        return super.ccTouchesEnded(event);
    }


}
