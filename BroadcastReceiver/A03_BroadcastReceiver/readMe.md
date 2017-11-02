#普通广播

普通广播是指大家等级都是一样的，当广播到来时，都能一块接收到，并没有接收的先后顺序。由于是一同接收到的，所以一个接收者是没有办法阻止另一个接收者接收这个广播的。

普通广播是完全异步的，可以在同一时刻（逻辑上）被所有广播接收者接收到，消息传递的效率比较高，但缺点是：接收者不能将处理结果传递给下一个接收者，并且无法终止广播Intent的传播；

1.定义三个广播接收者Receiver01、Receiver01、Receiver01都继承BroadcastReceiver

	package gaopan.a03_broadcastreceiver;
	
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
	        Log.d("gaopan", "onReceive01: ");
	    }
	}
2.在MainActivity中写一个按钮发送广播，然后再分别给三个广播接收者注册

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

运行效果
![](https://raw.githubusercontent.com/pgao0823/Picture/master/BroadcastReceiverDemo3.gif)