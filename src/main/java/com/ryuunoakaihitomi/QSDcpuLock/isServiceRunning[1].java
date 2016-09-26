package com.ryuunoakaihitomi.QSDcpuLock;
import android.app.*;
import android.content.*;
import java.util.*;
public class isServiceRunning
{
	public static boolean ask(Context c, String clsnm)
	{
		boolean isRunning = false;
		ActivityManager activityManager = (ActivityManager) c.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(30);
		if (!(serviceList.size() > 0))
		{
			return false;
		}
		for (int i = 0; i < serviceList.size(); i++)
		{
			if (serviceList.get(i).service.getClassName().equals(clsnm) == true)
			{
				isRunning = true;
				break;
			}
		}
		return isRunning;
	}
}
