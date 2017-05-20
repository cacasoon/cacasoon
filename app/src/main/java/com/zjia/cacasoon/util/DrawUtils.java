package com.zjia.cacasoon.util;

import com.zjia.cacasoon.bean.Position;

import org.cocos2d.layers.CCTMXTiledMap;
import org.cocos2d.nodes.CCSprite;

/**
 * Created by Administrator on 2017/5/20 0020.
 */

public class DrawUtils {

    /**
     * 初始化精灵
     */
    public static void initSprits() {
        // 初始化基础图片
        for (int i = 0;i < 24;i++){
            CCSprite sprite= CCSprite.sprite("basic_" + (char)('A' + i) + ".png");
            GameData.SPRITES.put("basic_" + (char)('A' + i),sprite);
        }
    }
    public static void drawByGameData(CCSprite nowBg,CCTMXTiledMap map) {
        map.cleanup();
        nowBg.removeAllChildren(true);

        CCSprite nowSprite = GameData.SPRITES.get(GameData.nowCard.getImg());
        nowSprite.setPosition(75,150);
        nowBg.addChild(nowSprite);

        for (Position p:GameData.OnMapCards.keySet()) {
            CCSprite sprit = GameData.SPRITES.get(GameData.OnMapCards.get(p).getImg());
            sprit.setPosition(p.getMapX(),p.getMapY());
            map.addChild(sprit);
        }

        for (Position p:GameData.CanPutList){
            CCSprite check = CCSprite.sprite("check.png");
            check.setPosition(p.getMapX(),p.getMapY());
            map.addChild(check);
        }
    }
}
