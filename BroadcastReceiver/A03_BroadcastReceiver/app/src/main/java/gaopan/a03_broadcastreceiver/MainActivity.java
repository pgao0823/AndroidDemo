package gaopan.a03_broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Receiver01 receiver01 = new Receiver01();
        Receiver02 receiver02 = new Receiver02();
        Receiver03 receiver03 = new Receiver03();
        IntentFilter intentFilter = new IntentFilter("gaopan.a03_broadcastreceiver");
        registerReceiver(receiver01,intentFilter);
        registerReceiver(receiver03,intentFilter);
        registerReceiver(receiver02,intentFilter);
    }
    //点击按钮发动广播
    public void send(View v){
        Intent intent = new Intent("gaopan.a03_broadcastreceiver");
        intent.putExtra("msg","广播已接收");
        sendBroadcast(intent);
    }
}
