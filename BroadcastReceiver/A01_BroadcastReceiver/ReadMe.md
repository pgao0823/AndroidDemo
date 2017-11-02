#BroadcastReceiver的静态注册

###又叫：常驻型广播，当你的应用程序关闭了，如果有广播信息来，你写的广播接收器同样的能接受到，他的注册方式就是在你的应用程序中的AndroidManifast.xml进行订阅的。

1.新建广播接收者MyReceiver继承自BroadcastReceiver

	package gaopan.a01_broadcastreceiver;
	
	import android.content.BroadcastReceiver;
	import android.content.Context;
	import android.content.Intent;
	import android.widget.Toast;
	
	/**
	 * Created by gaopan on 2017/11/1.
	 */
	
	public class MyReceiver extends BroadcastReceiver {
	    private static final String TAG = "gaopan";
	    @Override
	    public void onReceive(Context context, Intent intent) {
	        Toast.makeText(context, "@_@" +intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
	    }
	}

2.静态注册：

	<?xml version="1.0" encoding="utf-8"?>
	<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="gaopan.a01_broadcastreceiver">

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
        <receiver android:name=".MyReceiver">
            <intent-filter>
                <action android:name="aaa"/>
            </intent-filter>
        </receiver>
    </application>

	</manifest>
在<receiver>的<intent-filter>中的action name虽然可以随便写一个起标识作用，但是最好用应用包名+类名的方式，如此例中最好是用gaopan.a01_broadcastreceiver.mybroadcastreceiver

android:exported ——此broadcastReceiver能否接收其他App的发出的广播，这个属性默认值有点意思，其默认值是由receiver中有无intent-filter决定的，如果有intent-filter，默认值为true，否则为false。（同样的，activity/service中的此属性默认值一样遵循此规则）同时，需要注意的是，这个值的设定是以application或者application user id为界的，而非进程为界（一个应用中可能含有多个进程）；

3.在MainActivity中添加按钮点击后发送广播
	package gaopan.a01_broadcastreceiver;
	
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
	        Intent intent = new Intent("aaa"); //intent.setAction("aaa");
	        intent.putExtra("msg","广播已收到");
	        sendBroadcast(intent);
	    }
	}
运行效果：

![](https://raw.githubusercontent.com/pgao0823/Picture/master/BroadcastReceiverDemo1.gif)