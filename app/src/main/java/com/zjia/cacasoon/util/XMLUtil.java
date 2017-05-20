package com.zjia.cacasoon.util;

import android.content.res.XmlResourceParser;
import android.util.Xml;

import com.zjia.cacasoon.MainActivity;
import com.zjia.cacasoon.bean.BasicCard;
import com.zjia.cacasoon.bean.Card;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZJIA on 2017/5/19 0019.
 */

public class XMLUtil {

    /**
     * 解析basic信息
     * @param parser
     * @return
     */
    public static Map<BasicCard,Integer> parseBasicXML(XmlResourceParser parser){
        // 卡牌信息(相同卡片数目，卡片信息)
        Map<BasicCard,Integer> basic_xml = new HashMap<>();
        try {
            BasicCard c = null;
            int amount = 0;
            for (int type = parser.getEventType(); type != XmlPullParser.END_DOCUMENT; type = parser.next()) {
                if (type == XmlPullParser.START_TAG) {
                    if ("card".equals(parser.getName())) {
                        amount = Integer.parseInt(parser.getAttributeValue(null, "amount"));
                        c = new BasicCard();
                        basic_xml.put(c, amount);
                    } else if ("img".equals(parser.getName())) {
                        c.setImg(parser.nextText());
                    } else if ("top".equals(parser.getName())) {
                        c.setTop(Integer.parseInt(parser.nextText()));
                    } else if ("bottom".equals(parser.getName())) {
                        c.setBottom(Integer.parseInt(parser.nextText()));
                    } else if ("left".equals(parser.getName())) {
                        c.setLeft(Integer.parseInt(parser.nextText()));
                    } else if ("right".equals(parser.getName())) {
                        c.setRight(Integer.parseInt(parser.nextText()));
                    } else if ("rotateTimes".equals(parser.getName())) {
                        c.setRotateTimes(Integer.parseInt(parser.nextText()));
                    } else if ("church".equals(parser.getName())) {
                        c.setChurch(Integer.parseInt(parser.nextText()));
                    } else if ("cityLink".equals(parser.getName())) {
                        c.setCityLink(Integer.parseInt(parser.nextText()));
                    } else if ("roadLink".equals(parser.getName())) {
                        c.setRoadLink(Integer.parseInt(parser.nextText()));
                    } else if ("shield".equals(parser.getName())) {
                        c.setShield(Integer.parseInt(parser.nextText()));
                    }
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return basic_xml;
    }
}
