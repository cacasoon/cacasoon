package com.zjia.cacasoon.util;

import com.zjia.cacasoon.bean.Card;
import com.zjia.cacasoon.bean.Position;

import org.cocos2d.nodes.CCSprite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class GameData {
    // 屏幕宽
    public static final Integer WIN_WIDTH = 960;
    // 屏幕高
    public static final Integer WIN_HIGHT = 640;
    // 每个卡片的宽
    public static final Integer CARD_WIDTH = 100;
    // 每个卡片的高
    public static final Integer CARD_HIGHT = 100;
    // 当前卡牌
    public static Card nowCard = null;
    // 在地图上的卡牌
    public static final Map<Position,Card> OnMapCards = new HashMap<>();
    // 当前可放置位置
    public static final List<Position> CanPutList = new ArrayList<>();
    // 未使用的卡牌
    public static final List<Card> UnUsedCards = new ArrayList<>();
    // 所有精灵
    public static final Map<String,CCSprite> SPRITES = new HashMap<>();
}
