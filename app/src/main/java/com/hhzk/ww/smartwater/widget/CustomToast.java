package com.hhzk.ww.smartwater.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hhzk.ww.smartwater.R;

/**
 * User   : WangWei
 * E-maid : 13792916787@163.com
 * Date   : 2016-09-12
 * Time   : 14:06
 * FIXME
 */
public class CustomToast {

    // 自定义Toast
    public static void Toast(Context context, Object s) {
        View layout = LayoutInflater.from(context)
                .inflate(R.layout.toast, null);
        TextView text = (TextView) layout.findViewById(R.id.toast_text);
        text.setText("" + s);
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    // 积分Toast
    public static void JiFenToast(Context context, Object s) {
        View layout = LayoutInflater.from(context).inflate(
                R.layout.toast_jifen_tip, null);
        TextView text = (TextView) layout.findViewById(R.id.toast_text);
        text.setText(""+s);
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
