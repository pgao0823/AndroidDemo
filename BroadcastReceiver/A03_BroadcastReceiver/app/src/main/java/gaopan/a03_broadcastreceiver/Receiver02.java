package gaopan.a03_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by gaopan on 2017/11/2.
 */

public class Receiver02 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("gaopan", "onReceive02: ");
    }
}
