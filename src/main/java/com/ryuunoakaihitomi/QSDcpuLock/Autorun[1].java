package com.ryuunoakaihitomi.QSDcpuLock;
import android.content.*;
public class Autorun extends BroadcastReceiver
{
	@Override
	public void onReceive(Context p1, Intent p2)
	{
		if (p2.getAction().equals(p2.ACTION_BOOT_COMPLETED))    
        {   Intent i=new Intent(p1, AutoActivity.class);
			i.addFlags(p2.FLAG_ACTIVITY_NEW_TASK | p2.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
			p1.startActivity(i);
        }   
	}
}
