package com.example.admin.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.admin.broadcastreceiver.utils.Constants;

public class MainActivity extends AppCompatActivity {

    MyDanamicReceiver myDanamicReceiver;
    private EditText etBroadcastMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBroadcastMsg = (EditText) findViewById(R.id.etBroadcastMsg);

    }

    @Override
    protected void onStart() {
        super.onStart();

        myDanamicReceiver = new MyDanamicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Constants.ACTION.ACTION1 );

        registerReceiver(myDanamicReceiver, intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(myDanamicReceiver);
    }

    public void sendBroadcast(View view) {
        String data = etBroadcastMsg.getText().toString();

        Intent intent = new Intent();
        intent.setAction(Constants.ACTION.ACTION1);
        intent.putExtra(Constants.KEYS.DATA_MAIN, data);

        sendBroadcast(intent);
    }

    public void sendBroadcastToModule(View view) {
        String data = etBroadcastMsg.getText().toString();

        Intent intent2 = new Intent();
        intent2.setAction(Constants.ACTION.ACTION2);
        intent2.putExtra(Constants.KEYS.DATA_MAIN, data);

        //sendBroadcast(intent2);

        //Limits scope of broadcast to this app only
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
    }
}
