package com.ryuunoakaihitomi.QSDcpuLock;
import java.util.*;
public class cpuCoreLock
{
	public static void set(int number)
	{
		commandExecutor.execute("echo " + String.valueOf(number) + " > /sys/module/msm_thermal/core_control/cpus_offlined");
	}
	public static void setReset(boolean isReboot)
	{
		if (!isReboot)
		{
			commandExecutor.execute(" echo 0 > /sys/module/msm_thermal/core_control/cpus_offlined");
		}
		else
		{
			commandExecutor.execute("reboot");
		}
	}
}
