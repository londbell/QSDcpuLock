package com.ryuunoakaihitomi.QSDcpuLock;
import android.app.*;
import android.os.*;
import android.content.*;
public class AutoActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.auto);
		if (Boolean.valueOf(configControl.control(configControl.READ, "autorun", null)))
		{
			serviceNotificationLayout.AUTO_STATE = true;
			serviceNotificationLayout.set((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
			serviceNotificationLayout.AUTO_STATE = false;
			cpuCoreLock.set(Integer.valueOf(configControl.control(configControl.READ, "parameter", null)));
			if (Boolean.valueOf(configControl.control(configControl.READ, "service", null)))
			{
				startService(new Intent(getApplicationContext(), cpuLockService.class));
			}
		}
		finish();
	}
}
