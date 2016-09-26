package com.ryuunoakaihitomi.QSDcpuLock;
import java.io.*;
import java.util.regex.*;
public class cpuCoreCounter
{
	public static int getResult()
	{
		return CCCKernel();
	}
	private static int CCCKernel()
	{
		class CpuFilter implements FileFilter {
			@Override
			public boolean accept(File pathname)
			{
				if (Pattern.matches("cpu[0-9]", pathname.getName()))
				{
					return true;
				}
				return false;
			}      
		}
		try
		{
			File dir = new File("/sys/devices/system/cpu/");
			File[] files = dir.listFiles(new CpuFilter());
			return files.length;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 1;
		}
	}
}
