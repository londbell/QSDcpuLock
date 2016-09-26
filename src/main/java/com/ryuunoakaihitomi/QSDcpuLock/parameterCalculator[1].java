package com.ryuunoakaihitomi.QSDcpuLock;
import android.view.inputmethod.*;
public class parameterCalculator
{
	public static int get(boolean cpu0, boolean cpu1, boolean cpu2, boolean cpu3, boolean cpu4, boolean cpu5, boolean cpu6, boolean cpu7)
	{
		return PCKernel(cpu0, cpu1, cpu2, cpu3, cpu4, cpu5, cpu6, cpu7);
	}
	private static int PCKernel(boolean n1, boolean n2, boolean n3, boolean n4, boolean n5, boolean n6, boolean n7, boolean n8)
	{
		int out=0;
		if (n1)
		{
			out = out + 1;
		}
		if (n2)
		{
			out = out + 2;
		}
		if (n3)
		{
			out = out + 4;
		}
		if (n4)
		{
			out = out + 8;
		}
		if (n5)
		{
			out = out + 16;
		}
		if (n6)
		{
			out = out + 32;
		}
		if (n7)
		{
			out = out + 64;
		}
		if (n8)
		{
			out = out + 128;
		}
		return out;
	}
}
