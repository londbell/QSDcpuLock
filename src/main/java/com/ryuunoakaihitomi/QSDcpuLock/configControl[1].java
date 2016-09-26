package com.ryuunoakaihitomi.QSDcpuLock;
import android.content.*;
import java.io.*;
import java.util.*;
import javax.security.auth.*;
public class configControl
{
	static String CONFIG_PATH="/data/data/com.ryuunoakaihitomi.QSDcpuLock/config";
	static int WRITE=-1;
	static int SAVE=0;
	static int READ=1;
	private static Properties p=new Properties();
	static Context c=overallSituationContext.get();
	public static String control(int mode, String title, String body)
	{
		if (mode == WRITE)
		{
			write(title, body);
		}
		if (mode == SAVE)
		{
			save(c);
		}if (mode == READ)
		{
			return read(c, title);
		}
		else
		{
			return null;
		}
	}
	public static String read2(String title, String path)
	{
		Properties p0=CCKernel_loadConfig(c, path);
		return (String)p0.get(title);
	}
	private static void write(String title, String body)
	{
		p.put(title, body);
	}
	private static void save(Context context)
	{
		CCKernel_saveConfig(context, CONFIG_PATH, p);
	}
	private static String read(Context context, String title)
	{
		Properties p0=CCKernel_loadConfig(context, CONFIG_PATH);
		return (String)p0.get(title);
	}
	private static Properties CCKernel_loadConfig(Context context, String file)
	{
		Properties properties = new Properties();
		try
		{
			FileInputStream s = new FileInputStream(file);
			properties.load(s);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return properties;
	}
	private static void CCKernel_saveConfig(Context context, String file, Properties properties)
	{
		try
		{
			FileOutputStream s = new FileOutputStream(file, false);
			properties.store(s, "");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
