package gaopan.a01_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by gaopan on 2017/11/1.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "@_@"+intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
    }
}
