package com.ryuunoakaihitomi.QSDcpuLock;
import android.app.*;
import android.os.*;
import android.content.*;
import com.ryuunoakaihitomi.QSDcpuLock.CLSKernel;
public class cpuLockService extends Service
{
	@Override  
    public void onCreate()
	{  
		super.onCreate(); 
		serviceNotificationLayout.set((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
		customTimeToast.show("服务开始启动", 550);
		CLSKernel.set(true);
    }  
	@Override
	public IBinder onBind(Intent p1)
	{
		return null;
	}
	@Override  
    public void onDestroy()
	{  
        super.onDestroy();  
		NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nm.cancelAll();
		customTimeToast.show("服务停止", 550);
		CLSKernel.set(false);
    }  
	@Override  
    public int onStartCommand(Intent intent, int flags, int startId)
	{
        return START_STICKY;  
    }  
}
