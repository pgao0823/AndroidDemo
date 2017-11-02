package gaopan.a02_broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //动态注册
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("gaopan.a02_broadcastreceiver.mybroadcastreceiver");
        //可以简写成IntentFilter intentFilter = new IntentFilter("gaopan.a02_broadcastreceiver.mybroadcastreceiver");
        registerReceiver(myReceiver,intentFilter);
    }
    public void send(View v){
        Intent intent = new Intent("gaopan.a02_broadcastreceiver.mybroadcastreceiver");
        intent.putExtra("msg","动态广播收到了");
        sendBroadcast(intent);
    }
//    注意，registerReceiver是android.content.ContextWrapper类中的方法，Activity和Service都继承了ContextWrapper，所以可以直接调用。
//    在实际应用中，我们在Activity或Service中注册了一个BroadcastReceiver，当这个Activity或Service被销毁时如果没有解除注册，系统会报一个异常，提示我们是否忘记解除注册了。
//    所以，记得在特定的地方执行解除注册操作：
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
        Log.d("gaopan", "onDestroy: unregisterReceiver");
    }
}
