package com.ryuunoakaihitomi.QSDcpuLock;
import android.content.*;
import android.widget.*;
import java.util.*;
public class customTimeToast
{
	static Context c=overallSituationContext.get();
	boolean LONGTIME=false;
	boolean SHORTTIME=true;
	public static void show(String text, int ms)
	{
		CTTKernel(Toast.makeText(c, text, Toast.LENGTH_LONG), ms);
	}
	public static void show(String text, boolean isShort)
	{
		if (isShort)
		{
			Toast.makeText(c, text, Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(c, text, Toast.LENGTH_LONG).show();
		}
	}
	public static void show(Toast t, int ms)
	{
		CTTKernel(t, ms);
	}
	private static void CTTKernel(final Toast toast, final int cnt)
	{
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
				@Override
				public void run()
				{
					toast.show();
				}
			}, 0, 3000);
        new Timer().schedule(new TimerTask() {
				@Override
				public void run()
				{
					toast.cancel();
					timer.cancel();
				}
			}, cnt);
    }
}
