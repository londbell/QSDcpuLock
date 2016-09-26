package com.ryuunoakaihitomi.QSDcpuLock;
import android.app.*;
import android.content.*;
public class overallSituationContext extends Application
{
	private static Context context;
    @Override
    public void onCreate()
	{
        context = getApplicationContext();
    }
    public static Context get()
	{
        return context;
	}
}
