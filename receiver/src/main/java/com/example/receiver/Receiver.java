package com.example.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.receiver.utils.Constants;

/**
 * Created by Admin on 10/10/2017.
 */

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(action.equals(Constants.ACTION.ACTION2)){
            MainActivity.textView.setText(intent.getStringExtra(Constants.KEYS.DATA_MAIN));
        }
    }
}
