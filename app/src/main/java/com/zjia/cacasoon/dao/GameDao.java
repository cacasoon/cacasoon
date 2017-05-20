package com.zjia.cacasoon.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zjia.cacasoon.bean.BasicCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */

public class GameDao {
    private SQLiteDatabase db;

    public GameDao(Context context) {
        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getReadableDatabase();
    }

    public List<BasicCard> getBasicCardList() {
        int idNUm = 1;
        int num = 0;
        List<BasicCard> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT amount,img,top,bottom," +
                "left,right,rotatetimes,church," +
                "citylink,roadlink,shield " +
                "FROM BASICCARD", null);
        while (cursor.moveToNext()) {
            num++;
            int amount = cursor.getInt(0);
            for (int i = 0; i < amount; i++) {
                BasicCard bc = new BasicCard();
                bc.setId("basic_" + idNUm++);
                bc.setImg(cursor.getString(1));
                bc.setTop(cursor.getInt(2));
                bc.setBottom(cursor.getInt(3));
                bc.setLeft(cursor.getInt(4));
                bc.setRight(cursor.getInt(5));
                bc.setRotateTimes(cursor.getInt(6));
                bc.setChurch(cursor.getInt(7));
                bc.setCityLink(cursor.getInt(8));
                bc.setRoadLink(cursor.getInt(9));
                bc.setShield(cursor.getInt(10));
                list.add(bc);
            }
        }
        db.close();
        System.out.print("数据库数据：" + list.size());
        return list;
    }
}