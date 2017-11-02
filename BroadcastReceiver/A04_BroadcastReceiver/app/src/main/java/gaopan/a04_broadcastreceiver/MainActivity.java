package gaopan.a04_broadcastreceiver;

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
        Intent intent = new Intent("gaopan.a04_broadcastreceiver");
        intent.putExtra("msg","有序广播");
        sendOrderedBroadcast(intent,"gaopan.broadcast.perssion");
    }
}
