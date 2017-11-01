package gaopan.a02_broadcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void send(View v){
        Intent intent = new Intent("aaa");
        //intent.setAction("aaa");
        intent.putExtra("msg","广播已经收到了");
        sendBroadcast(intent);
    }
}
