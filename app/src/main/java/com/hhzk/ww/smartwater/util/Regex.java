package com.hhzk.ww.smartwater.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


import com.hhzk.ww.smartwater.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    /**
     * 检测网络是否可用
     *
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }

    // 验证用户昵称 括字母、数字、下划线或中文
    public static boolean checkNickName(String nickName) {
        Pattern p = Pattern.compile("^[A-Za-z0-9\u4e00-\u9fa5]+$");// 复杂匹配
        Matcher m = p.matcher(nickName);
        return m.matches();
    }

    // 验证昵称 括字母，中文
    public static boolean checkBabyNickName(String passWord) {
        Pattern p = Pattern.compile("^[A-Za-z\u4e00-\u9fa5]+$");// 复杂匹配
        Matcher m = p.matcher(passWord);
        return m.matches();
    }

    // 验证用户昵称 括字母、数字、下划线
    public static boolean checkPassWord(String nickName) {
        Pattern p = Pattern.compile(" ^[0-9a-zA-Z_]+$");// 复杂匹配
        Matcher m = p.matcher(nickName);
        return m.matches();
    }



    // 无网络提示
    public static void netTip(Context context) {
        View layout = LayoutInflater.from(context).inflate(
                R.layout.toast_net_tip, null);
        TextView text = (TextView) layout.findViewById(R.id.toast_text);
        text.setText("  你的网络不给力哦  ");
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 判断手机号是否合法
     */
    public static boolean checkMobile(String mobile) {
        final String regex = "^1((3\\d)|(4[57])|(5[^4\\D])|(7[06-8])|(8\\d))\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    /**
     * 判断邮箱是否合法
     * @return true 合法
     */
    public static boolean isEmail(String email){
        if (null==email || "".equals(email)) return false;
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
