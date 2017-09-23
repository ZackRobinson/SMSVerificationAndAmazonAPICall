package com.zackeryrobinson.smsverificationandamazonapicall;

import android.content.Intent;

/**
 * Created by Zack on 9/23/2017.
 */

public interface SmsListener {
    public void messageReceived(String messageText);
}



