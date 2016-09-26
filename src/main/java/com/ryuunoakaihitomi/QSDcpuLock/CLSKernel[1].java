package com.ryuunoakaihitomi.QSDcpuLock;
import java.util.*;
import android.content.*;
import android.os.*;
import java.lang.ref.*;
public class CLSKernel
{  
	private final static Timer timer = new Timer();  
	private static TimerTask task= new TimerTask() {  
		@Override  
		public void run()
		{  
			Message message = new Message();  
			message.what = 1;  
			handler.sendMessage(message);  
		}  
	};   
	static	Handler  handler = new Handler() {  
		@Override  
		public void handleMessage(Message msg)
		{  
			cpuCoreLock.set(Integer.valueOf(configControl.control(configControl.READ, "parameter", null)));
			super.handleMessage(msg);  
		}  
	};  
	public static void set(boolean isRun)
	{
		if (isRun)
		{
			timer.schedule(task, 2000, 25000);   
		}
		else
		{
			timer.cancel();
		}
	}
}  
