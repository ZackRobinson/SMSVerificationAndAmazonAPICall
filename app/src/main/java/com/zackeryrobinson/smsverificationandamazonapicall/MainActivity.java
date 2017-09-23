package com.zackeryrobinson.smsverificationandamazonapicall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmsReceiver.bindListener(new SmsListener() {
            @Override
            public void messageReceived(String messageText) {
                Log.d(TAG, "messageReceived: ");
                Toast.makeText(MainActivity.this, "Message: "+messageText,Toast.LENGTH_LONG).show();
            }
        });



    }
}
