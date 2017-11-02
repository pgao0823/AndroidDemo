#有序广播
有序广播比较特殊，它每次只发送到优先级较高的接收者那里，然后由优先级高的接受者再传播到优先级低的接收者那里，优先级高的接收者有能力终止这个广播。

1.定义三个广播接收者Receiver01、Receiver02、Receiver03都继承BroadcastReceiver

Receiver03. 用getStringExtra()来获取点击按钮发送广播中携带的数据，再用setResultExtras(bundle)来对广播中携带的信息进行修改

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
Receiver02. 用getResultExtras(true).getString("msgFromReceiver03")来获取点击按钮发送广播经过Receiver03修改后携带的数据，再用setResultExtras(bundle)来对广播中携带的信息进行修改

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
Receiver01.用getResultExtras(true).getString("msgFromReceiver02")来获取点击按钮发送广播经过Receiver02修改后携带的数据

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

2.在manifest中进行注册（静态），通过<intent-filter android:priority="1000">来设置广播接收的优先级

	<?xml version="1.0" encoding="utf-8"?>
	<manifest xmlns:android="http://schemas.android.com/apk/res/android"
	    package="gaopan.a04_broadcastreceiver">
	
	    <permission
	        android:name="gaopan.broadcast.perssion"
	        android:protectionLevel="normal"></permission>
	
	    <application
	        android:allowBackup="true"
	        android:icon="@mipmap/ic_launcher"
	        android:label="@string/app_name"
	        android:roundIcon="@mipmap/ic_launcher_round"
	        android:supportsRtl="true"
	        android:theme="@style/AppTheme">
	        <activity android:name=".MainActivity">
	            <intent-filter>
	                <action android:name="android.intent.action.MAIN" />
	
	                <category android:name="android.intent.category.LAUNCHER" />
	            </intent-filter>
	        </activity>
	
	        <receiver android:name=".Receiver01">
	            <intent-filter android:priority="998">
	                <action android:name="gaopan.a04_broadcastreceiver" />
	            </intent-filter>
	        </receiver>
	        <receiver android:name=".Receiver02">
	            <intent-filter android:priority="999">
	                <action android:name="gaopan.a04_broadcastreceiver" />
	            </intent-filter>
	        </receiver>
	        <receiver android:name=".Receiver03">
	            <intent-filter android:priority="1000">
	                <action android:name="gaopan.a04_broadcastreceiver" />
	            </intent-filter>
	        </receiver>
	    </application>
	
	    <uses-permission android:name="gaopan.broadcast.perssion" />
	</manifest>

3.在MainActivity中按钮点击发送广播

sendOrderedBroadcast(intent, null);  其中第二个参数是指定接收者必须拥有的接收权限，如果设为NUll，就是不需要接收权限，所有匹配的Receiver都能接收到。如果第二个参数不为null，则需要在manifest文件中添加<permission和<uses-permission

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
运行效果：
![](https://raw.githubusercontent.com/pgao0823/Picture/master/BroadcastReceiverDemo4.gif)
