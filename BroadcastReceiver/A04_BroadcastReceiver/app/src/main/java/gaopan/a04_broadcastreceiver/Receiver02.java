package gaopan.a04_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by gaopan on 2017/11/2.
 */

public class Receiver02 extends BroadcastReceiver {

    private static final String TAG = "gaopan";
    @Override
    public void onReceive(Context context, Intent intent) {

        //获取按钮广播经过Receiver03以后再传过来携带的数据
        String msgFromReceiver03 = getResultExtras(true).getString("msgFromReceiver03");
        Log.d(TAG, "onReceive02: "+msgFromReceiver03);

        //更改广播数据
        Bundle bundle = new Bundle();
        bundle.putString("msgFromReceiver02",msgFromReceiver03+"Receiver02更改广播内容了");
        setResultExtras(bundle);
    }
}
