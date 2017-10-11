package com.example.admin.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyStaticReceiver extends BroadcastReceiver {

    public static final String TAG ="myStaticReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        //Toast.makeText(context, "Airplane Mode Switched", Toast.LENGTH_LONG).show();
    }
}
