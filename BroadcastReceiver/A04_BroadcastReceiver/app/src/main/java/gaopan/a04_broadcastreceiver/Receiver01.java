package gaopan.a04_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by gaopan on 2017/11/2.
 */

public class Receiver01 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //获取按钮广播经过Receiver03和Receiver02再传递过来携带的数据
        String msgFromReceiver02 = getResultExtras(true).getString("msgFromReceiver02");
        Log.d("gaopan", "onReceive01: "+msgFromReceiver02);
    }
}
