package com.zjia.cacasoon.util;

import android.content.Context;
import android.content.res.XmlResourceParser;

import com.zjia.cacasoon.bean.BasicCard;
import com.zjia.cacasoon.bean.Card;
import com.zjia.cacasoon.bean.Position;
import com.zjia.cacasoon.dao.DBOpenHelper;
import com.zjia.cacasoon.dao.GameDao;

import java.util.Collections;
import java.util.List;

/**
 * Created by ZJIA on 2017/5/16 0016.
 */

public class GameDataUtils {
    /**
     * 初始化游戏数据
     * @param context
     */
    public static void initGameData(Context context){
        // 获取所有的卡片信息
        GameDao dao = new GameDao(context);
        List<BasicCard> list = dao.getBasicCardList();
        /**
         * 去除第一张牌
         */
        Position basePosition = new Position(10,10);
        BasicCard base = null;
        for (BasicCard c:list) {
            if("basic_D".equals(c.getImg())){
                base = c;
                list.remove(base);
                break;
            }
        }

        /**
         * 清空未使用牌库
         * 将所有未使用的基础卡牌放入未使用牌库
         */
        GameData.UnUsedCards.clear();
        GameData.UnUsedCards.addAll(list);
        /**
         * 清空桌面牌库
         * 将第一张放到桌面
         */
        GameData.OnMapCards.clear();
        GameData.OnMapCards.put(basePosition,base);
        /**
         * 随机取出一张作为当前卡牌
         * 判断可放置位置
         */
        GameData.nowCard = pickCard();
        checkPosition();
    }

    /**
     * 随机取出未使用的一张牌
     * @return
     */
    public static Card pickCard() {
        Collections.shuffle(GameData.UnUsedCards);
        if(GameData.UnUsedCards.size() != 0){
            Card card = GameData.UnUsedCards.get(0);
            GameData.UnUsedCards.remove(0);
            return card;
        }
        return null;
    }

    /**
     * 判断可放置位置
     */
    public static void checkPosition() {
        GameData.CanPutList.clear();
        for (Position p:GameData.OnMapCards.keySet()) {
            if(!GameData.OnMapCards.containsKey(getUpPosition(p))){
                check(getUpPosition(p));
            }
            if(!GameData.OnMapCards.containsKey(getBottomPosition(p))){
                check(getBottomPosition(p));
            }
            if(!GameData.OnMapCards.containsKey(getLeftPosition(p))){
                check(getLeftPosition(p));
            }
            if(!GameData.OnMapCards.containsKey(getRightPosition(p))){
                check(getRightPosition(p));
            }
        }
    }
    private static Position getUpPosition(Position p) {
        return getPosition(new Position(p.getX(),p.getY() + 1));
    }
    private static Position getBottomPosition(Position p) {
        return getPosition(new Position(p.getX(),p.getY() - 1));
    }
    private static Position getLeftPosition(Position p) {
        return getPosition(new Position(p.getX() - 1,p.getY()));
    }
    private static Position getRightPosition(Position p) {
        return getPosition(new Position(p.getX() + 1,p.getY()));
    }

    private static Position getPosition(Position p) {
        for (Position realP: GameData.OnMapCards.keySet()) {
            if(p.equals(realP)){
                return realP;
            }
        }
        return p;
    }

    private static void check(Position p) {
        for (Position all: GameData.OnMapCards.keySet()) {
            System.out.println("地图上有的位置" + all);
        }

        Card card = GameData.nowCard;
        Card up = GameData.OnMapCards.get(getUpPosition(p));
        Card down = GameData.OnMapCards.get(getBottomPosition(p));
        Card left = GameData.OnMapCards.get(getLeftPosition(p));
        Card right = GameData.OnMapCards.get(getRightPosition(p));

        boolean canSet = true;

        System.out.println("当前卡牌为：" + card);
        System.out.println("判定位置为" + p);
        System.out.println("上侧卡牌" + up);
        System.out.println("下侧卡牌" + down);
        System.out.println("左侧卡牌" + left);
        System.out.println("右侧卡牌" + right);
        if( (up != null && up.getBottom() != card.getTop())
                || (down != null && down.getTop() != card.getBottom())
                || (left != null && left.getRight() != card.getLeft())
                || (right != null && right.getLeft() != card.getRight())
                ){
            canSet = false;
        }
        if(canSet){
            GameData.CanPutList.add(p);
        }
    }
}
