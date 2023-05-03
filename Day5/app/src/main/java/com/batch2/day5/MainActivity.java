package com.batch2.day5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	EditText number1, mesg1, web1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		number1 = findViewById(R.id.phno1);
		mesg1 = findViewById(R.id.msg1);
		web1 = findViewById(R.id.webp1);
	}

	public void callClick(View view) {
		String num1 = number1.getText().toString();
		Intent in1 = new Intent(Intent.ACTION_DIAL);
		in1.setData(Uri.parse("tel:"+num1));
		startActivity(in1);
	}

	public void smsClick(View view) {
		String num1 = number1.getText().toString();
		String msg1 = mesg1.getText().toString();
		Intent in1 = new Intent(Intent.ACTION_SENDTO);
		in1.setData(Uri.parse("sms:"+num1));
		in1.putExtra("sms_body", msg1);
		startActivity(in1);
	}

	public void timerClick(View view) {
	}

	public void alarmClick(View view) {
		String hh = "16";
		String mm = "14";
		String msg1 = "wakey wakey";
		Intent in1 = new Intent(AlarmClock.ACTION_SET_ALARM);
//		in1.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
		in1.putExtra(AlarmClock.EXTRA_HOUR, hh);
		in1.putExtra(AlarmClock.EXTRA_MINUTES, mm);
		in1.putExtra(AlarmClock.EXTRA_MESSAGE, msg1);
		startActivity(in1);

	}

	public void pageClick(View view) {
		String webpage1 = web1.getText().toString();
		Intent in1 = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage1));
		startActivity(in1);
	}

}