package gaopan.a04_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by gaopan on 2017/11/2.
 */

public class Receiver03 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //终止广播再传递
//        abortBroadcast();

        //获取按钮广播中携带的数据
        String msg = intent.getStringExtra("msg");
        Log.d("gaopan", "onReceive03: "+msg);

        //更改广播数据
        Bundle bundle = new Bundle();
        bundle.putString("msgFromReceiver03",msg+"Receiver03更改广播内容了");
        setResultExtras(bundle);
    }
}
