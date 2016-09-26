package com.ryuunoakaihitomi.QSDcpuLock;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.ryuunoakaihitomi.QSDcpuLock.*;
import android.view.View.*;
import android.net.*;
import android.content.*;
public class MainActivity extends Activity 
{
	public void saveConfig()
	{
		CheckBox cpu0=(CheckBox) findViewById(R.id.mainCheckBox1);
		CheckBox cpu1=(CheckBox) findViewById(R.id.mainCheckBox2);
		CheckBox cpu2=(CheckBox) findViewById(R.id.mainCheckBox3);
		CheckBox cpu3=(CheckBox) findViewById(R.id.mainCheckBox4);
		CheckBox cpu4=(CheckBox) findViewById(R.id.mainCheckBox5);
		CheckBox cpu5=(CheckBox) findViewById(R.id.mainCheckBox6);
		CheckBox cpu6=(CheckBox) findViewById(R.id.mainCheckBox7);
		CheckBox cpu7=(CheckBox) findViewById(R.id.mainCheckBox8);
		TextView para =(TextView) findViewById(R.id.mainTextView4);
		Switch service=(Switch) findViewById(R.id.mainSwitch1);
		Switch autorun=(Switch) findViewById(R.id.mainSwitch2);
		configControl.control(configControl.WRITE, "cpu0", String.valueOf(cpu0.isChecked()));
		configControl.control(configControl.WRITE, "cpu1", String.valueOf(cpu1.isChecked()));
		configControl.control(configControl.WRITE, "cpu2", String.valueOf(cpu2.isChecked()));
		configControl.control(configControl.WRITE, "cpu3", String.valueOf(cpu3.isChecked()));
		configControl.control(configControl.WRITE, "cpu4", String.valueOf(cpu4.isChecked()));
		configControl.control(configControl.WRITE, "cpu5", String.valueOf(cpu5.isChecked()));
		configControl.control(configControl.WRITE, "cpu6", String.valueOf(cpu6.isChecked()));
		configControl.control(configControl.WRITE, "cpu7", String.valueOf(cpu7.isChecked()));
		configControl.control(configControl.WRITE, "parameter", (String) para.getText());
		configControl.control(configControl.WRITE, "service", String.valueOf(service.isChecked()));
		configControl.control(configControl.WRITE, "autorun", String.valueOf(autorun.isChecked()));
		configControl.control(configControl.SAVE, null, null);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			saveConfig();
			customTimeToast.show("主活动已经保存配置并退出", true);
		}
		return super.onKeyDown(keyCode, event);
	}
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		TextView head=(TextView) findViewById(R.id.mainTextView1);
		TextView readme=(TextView) findViewById(R.id.mainTextView2);
		TextView root=(TextView) findViewById(R.id.mainTextView3);
		final TextView para=(TextView) findViewById(R.id.mainTextView4);
		final CheckBox cpu0=(CheckBox) findViewById(R.id.mainCheckBox1);
		final CheckBox cpu1=(CheckBox) findViewById(R.id.mainCheckBox2);
		final CheckBox cpu2=(CheckBox) findViewById(R.id.mainCheckBox3);
		final CheckBox cpu3=(CheckBox) findViewById(R.id.mainCheckBox4);
		final CheckBox cpu4=(CheckBox) findViewById(R.id.mainCheckBox5);
		final CheckBox cpu5=(CheckBox) findViewById(R.id.mainCheckBox6);
		final CheckBox cpu6=(CheckBox) findViewById(R.id.mainCheckBox7);
		final CheckBox cpu7=(CheckBox) findViewById(R.id.mainCheckBox8);
		Button exe=(Button) findViewById(R.id.mainButton1);
		Button reset= (Button) findViewById(R.id.mainButton2);
		final Switch service=(Switch) findViewById(R.id.mainSwitch1);
		final Switch autorun=(Switch) findViewById(R.id.mainSwitch2);
		cpu0.setChecked(Boolean.valueOf(configControl.control(configControl.READ, "cpu0", null)));
		cpu1.setChecked(Boolean.valueOf(configControl.control(configControl.READ, "cpu1", null)));
		cpu2.setChecked(Boolean.valueOf(configControl.control(configControl.READ, "cpu2", null)));
		cpu3.setChecked(Boolean.valueOf(configControl.control(configControl.READ, "cpu3", null)));
		cpu4.setChecked(Boolean.valueOf(configControl.control(configControl.READ, "cpu4", null)));
		cpu5.setChecked(Boolean.valueOf(configControl.control(configControl.READ, "cpu5", null)));
		cpu6.setChecked(Boolean.valueOf(configControl.control(configControl.READ, "cpu6", null)));
		cpu7.setChecked(Boolean.valueOf(configControl.control(configControl.READ, "cpu7", null)));
		service.setChecked(Boolean.valueOf(configControl.control(configControl.READ, "service", null)));
		autorun.setChecked(Boolean.valueOf(configControl.control(configControl.READ, "autorun", null)));
		para.setText(configControl.control(configControl.READ, "parameter", null));
		cpu0.setVisibility(View.GONE);
		cpu1.setVisibility(View.GONE);
		cpu2.setVisibility(View.GONE);
		cpu3.setVisibility(View.GONE);
		cpu4.setVisibility(View.GONE);
		cpu5.setVisibility(View.GONE);
		cpu6.setVisibility(View.GONE);
		cpu7.setVisibility(View.GONE);
		para.setVisibility(View.GONE);
		if (service.isChecked() && !isServiceRunning.ask(this, "com.ryuunoakaihitomi.QSDcpuLock.cpuLockService"))
		{
			startService(new Intent(this, cpuLockService.class));
		}
		if (!service.isChecked() && isServiceRunning.ask(this, "com.ryuunoakaihitomi.QSDcpuLock.cpuLockService"))
		{
			stopService(new Intent(this, cpuLockService.class));
		}
		int cpuCore=cpuCoreCounter.getResult();
		head.setText((String) head.getText() + "（CPU核心数：" + String.valueOf(cpuCore) + "）");
		if (cpuCore != 0)
		{
			cpuCore--;
			cpu0.setVisibility(View.VISIBLE);
			if (cpuCore != 0)
			{
				cpuCore--;
				cpu1.setVisibility(View.VISIBLE);
				if (cpuCore != 0)
				{
					cpuCore--;
					cpu2.setVisibility(View.VISIBLE);
					if (cpuCore != 0)
					{
						cpuCore--;
						cpu3.setVisibility(View.VISIBLE);
						if (cpuCore != 0)
						{
							cpuCore--;
							cpu4.setVisibility(View.VISIBLE);
							if (cpuCore != 0)
							{
								cpuCore--;
								cpu5.setVisibility(View.VISIBLE);
								if (cpuCore != 0)
								{
									cpuCore--;
									cpu6.setVisibility(View.VISIBLE);
									if (cpuCore != 0)
									{
										cpuCore--;
										cpu7.setVisibility(View.VISIBLE);
									}
								}
							}
						}
					}
				}
			}
		}
		root.setOnLongClickListener(new OnLongClickListener(){
				@Override
				public boolean onLongClick(View p1)
				{
					Uri link=Uri.parse("http://www.coolapk.com/album/1899819");
					Intent i=new Intent("android.intent.action.VIEW", link);
					startActivity(i);
					return true;
				}
			});
		exe.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					para.setText(String.valueOf(parameterCalculator.get(cpu0.isChecked(), cpu1.isChecked(), cpu2.isChecked(), cpu3.isChecked(), cpu4.isChecked(), cpu5.isChecked(), cpu6.isChecked(), cpu7.isChecked())));
					cpuCoreLock.set(Integer.valueOf((String) para.getText()));
					saveConfig();
					customTimeToast.show("命令执行完成", 550);
				}
			});
		reset.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					stopService(new Intent(getApplicationContext(), cpuLockService.class));
					service.setChecked(false);
					cpuCoreLock.setReset(false);
					customTimeToast.show("恢复完成", 550);
				}
			});
		reset.setOnLongClickListener(new OnLongClickListener(){
				@Override
				public boolean onLongClick(View p1)
				{
					cpuCoreLock.setReset(true);
					return true;
				}
			});
		readme.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					customTimeToast.show(getString(R.string.help), 10000);
				}
			});
		readme.setOnLongClickListener(new OnLongClickListener(){
				@Override
				public boolean onLongClick(View p1)
				{
					Toast t = Toast.makeText(getApplicationContext(), getString(R.string.about), Toast.LENGTH_LONG);
					customTimeToast.show(t, 5000);
					return true;
				}
			});
		service.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					if (service.isChecked())
					{
						Intent i=new Intent(getApplicationContext(), cpuLockService.class);
						startService(i);
					}
					else
					{
						Intent i=new Intent(getApplicationContext(), cpuLockService.class);
						stopService(i);
					}
				}
			});
		autorun.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					customTimeToast.show("开机服务状态：" + String.valueOf(autorun.isChecked()) + " 返回键退出保存", 800);
				}
			});
	}
}
