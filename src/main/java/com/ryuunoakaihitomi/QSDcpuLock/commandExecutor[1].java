package com.ryuunoakaihitomi.QSDcpuLock;
import java.io.*;
public class commandExecutor
{
	public static void execute(String command)
	{
		CEKernel(command);
	}

	private static void CEKernel(String command)
	{
		try
		{
			Process p = Runtime.getRuntime().exec("su");
			DataOutputStream d = new DataOutputStream(p.getOutputStream());
			d.writeBytes(command + "\n");
			d.writeBytes("exit\n");
			d.flush();
			p.getErrorStream().close();
		}
		catch (IOException s)
		{
		}
	}
}
