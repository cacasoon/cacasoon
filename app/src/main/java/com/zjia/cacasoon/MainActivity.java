package com.zjia.cacasoon;


import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.zjia.cacasoon.util.DrawUtils;
import com.zjia.cacasoon.util.GameDataUtils;
import com.zjia.cacasoon.view.MapScene;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

public class MainActivity extends Activity {
    private CCDirector director;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); // 全屏游戏

        // 得到游戏主视图，并设为默认视图入口
        CCGLSurfaceView view = new CCGLSurfaceView(this);
        setContentView(view);

        // 初始化导演
        initDirector(view);
        // 初始化游戏数据
        GameDataUtils.initGameData(this);
        // 初始化精灵
        DrawUtils.initSprits();
        // 加载初始场景，开始游戏
        startGame();


    }

    private void initDirector(CCGLSurfaceView view) {
        director = CCDirector.sharedDirector();
        director.attachInView(view);

        director.setDisplayFPS(true);
        director.setAnimationInterval(1.0f / 60);

        director.setScreenSize(960, 540);
    }

    private void startGame() {
        CCScene scene = CCScene.node();
        scene.addChild(new MapScene());
        director.runWithScene(scene);
    }

    @Override
    protected void onDestroy() {
        director.end();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        director.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        director.resume();
        super.onResume();
    }
}
