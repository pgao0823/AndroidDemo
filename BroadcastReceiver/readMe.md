#BroadcastReceiver

BroadcastReceiver就是一个广播消息接收者。广播之间信息的传递是通过Intent对象来传递的

##广播的注册
广播的注册分为静态注册和动态注册，静态注册的程序，无论该程序是否启动，都会当广播到来时接收，并处理。而动态注册的程序只有在程序运行时才会收到广播消息，程序不运行了，它就收不到了。

**A01_BroadcastReceiver**这个demo讲解的是广播的静态注册，详细使用请看demo工程中的readMe文件。

**A02_BroadcastReceiver**这个demo讲解的是广播的静态注册，详细使用请看demo工程中的readMe文件。

##Android中的广播类型主要有两种：
**Normalbroadcasts**（标准广播）：通过Context.sendBroadcast方法发送。是一种完全异步执行的广播。所有该广播的接收器都是无序运行的，在广播发出之后，几乎都会在同一时刻接收到这条广播消息。这种广播效率会比较高，但同时也意味着它是无法被截断的。

**Orderedbroadcasts**（有序广播）：通过Context.sendOrderedBroadcast方法发送。是一种同步执行的广播，在广播发出之后，同一时刻只会有一个广播接收器能够收到这条广播消息，当这个广播接收器中的逻辑执行完毕后，广播才会继续传递，并且前面的广播接收器还可以截断正在传递的广播，这样后面的广播就无法收到广播消息了。
