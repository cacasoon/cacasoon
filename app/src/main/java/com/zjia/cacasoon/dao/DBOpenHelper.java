package com.zjia.cacasoon.dao;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zjia.cacasoon.R;
import com.zjia.cacasoon.bean.BasicCard;
import com.zjia.cacasoon.util.XMLUtil;

import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    private XmlResourceParser basicParser;

    public DBOpenHelper(Context context) {
        super(context, "cacasoon.db", null, 1);
        basicParser = context.getResources().getXml(R.xml.basic_card);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE BASICCARD(" +
                "       id Integer PRIMARY KEY AUTOINCREMENT," +
                "       amount Integer," +
                "       img varchar(20)," +
                "       top Integer," +
                "       bottom Integer," +
                "       left Integer," +
                "       right Integer," +
                "       rotatetimes Integer," +
                "       church Integer," +
                "       citylink Integer," +
                "       roadlink Integer," +
                "       shield Integer" +
                ")");
        initDB(db);
    }

    /**
     * 初始化数据库
     * @param db
     */
    private void initDB(SQLiteDatabase db) {
        Map<BasicCard, Integer> basic_card = XMLUtil.parseBasicXML(basicParser);
        // 数据库初始化语句
        Set<BasicCard> cards = basic_card.keySet();
        for (BasicCard c : cards) {
            db.execSQL("insert into BASICCARD(amount," +
                    "img,top,bottom,left,right,rotatetimes," +
                    "church,citylink,roadlink,shield) values(" +
                    basic_card.get(c) + ",'" +
                    c.getImg() + "'," +
                    c.getTop() + "," +
                    c.getBottom() + "," +
                    c.getLeft() + "," +
                    c.getRight() + "," +
                    c.getRotateTimes() + "," +
                    c.getChurch() + "," +
                    c.getCityLink() + "," +
                    c.getRoadLink() + "," +
                    c.getShield() +
                    ")");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
