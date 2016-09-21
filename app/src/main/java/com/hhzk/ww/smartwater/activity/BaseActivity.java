package com.hhzk.ww.smartwater.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hhzk.ww.smartwater.App;
import com.hhzk.ww.smartwater.util.Logger;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

     /*是否沉浸状态栏*/
    private boolean isSetStatusBar = true;
     /*是否允许全屏*/
    private boolean isAllowFullScreen = true;
    /*是否禁止旋转屏幕*/
    private boolean isAllowScreenRoate = false;
    /*当前Activity渲染的视图View*/
    private View mContextView = null;
    /*是否输出日志信息*/
    private boolean isDebug;
    private String APP_NAME;
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mContextView = LayoutInflater.from(this)
                    .inflate(bindLayout(), null);
            if(isAllowFullScreen){
                this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                requestWindowFeature(Window.FEATURE_NO_TITLE);
            }
            if (isSetStatusBar) {
                steepStatusBar();
            }
            if(!isAllowScreenRoate){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }else{
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }

            initView(mContextView);
            doBusiness(this);
            setOnClick();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 绑定布局
     *
     * @return
     */
    public abstract int bindLayout();
    /**
     * 初始化控件
     *
     * @param view
     */
    public abstract void initView(final View view);

    /**
     * 业务操作
     *
     * @param mContext
     */
    abstract void doBusiness(Context mContext);;
    /** View点击 **/
    public abstract void setOnClick();

    /**
     * 沉浸栏状态
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
    }

    /**
     * 是否允许屏幕旋转
     *
     * @param isAllowScreenRoate
     */
    public void setScreenRoate(boolean isAllowScreenRoate) {
        this.isAllowScreenRoate = isAllowScreenRoate;
    }

    /**
     * 是否允许全屏
     *
     * @param allowFullScreen
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.isAllowFullScreen = allowFullScreen;
    }

    /**
     * 日志输出
     *
     * @param msg
     */
    protected void $Log(String msg) {
        if (isDebug) {
            Logger.d(msg);
        }
    }

}
