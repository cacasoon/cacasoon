package com.zjia.cacasoon.view;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGSize;

/**
 * Created by Administrator on 2017/5/14 0014.
 */

public class ModelLayer extends CCLayer {
    // 获取屏幕大小
    protected CGSize winSize = CCDirector.sharedDirector().getWinSize();
    protected String font = "hkbd.ttf";
    public ModelLayer() {
        // 激活
        setIsTouchEnabled(true);
    }
}
