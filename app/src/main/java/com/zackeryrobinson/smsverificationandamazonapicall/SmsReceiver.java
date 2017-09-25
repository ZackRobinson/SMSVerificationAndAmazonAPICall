package com.zackeryrobinson.smsverificationandamazonapicall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

    private static final String TAG = "SMSReceiverTag";
    private static SmsListener mListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        Bundle data = intent.getExtras();

        Object[] pdus = (Object[]) data.get("pdus");

        for (int i = 0; i < pdus.length; i++) {
            SmsMessage smsMessage = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }

            String sender = smsMessage.getMessageBody();
            //You must check if the sender is your provider and not another one with same text.
            Log.d(TAG, "onReceive: Got MessageBody");
            String messageBody = smsMessage.getMessageBody();

            //Pass on the text to our listener.
            mListener.messageReceived(messageBody);

        }



    }

    public static void bindListener(SmsListener listener) {
        mListener = listener;
    }
}
