package com.pela.elassistant;

import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Color;
import android.os.Build;
import android.os.Binder;
import android.os.IBinder;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ELAssistantService extends Service {
    LinearLayout mView;
    private static final int width = 1500;
    private static final int height = 150;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mView = new LinearLayout(this);
        mView.setBackgroundColor(Color.GRAY);
        LayoutParams params = new LayoutParams(
                width, height,
                LayoutParams.TYPE_SYSTEM_OVERLAY,
                0,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.CENTER | Gravity.BOTTOM;
        params.y = 20;

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.addView(mView, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mView != null) {
            ((WindowManager) getSystemService(WINDOW_SERVICE)).removeView(mView);
            mView = null;
        }
    }
}
