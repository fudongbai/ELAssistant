package com.bay.elassistant;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;

public class ELAssistantBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, ELAssistantService.class));
    }
}
