package com.batch2.day4app;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements SensorEventListener, TextToSpeech.OnInitListener {
	CheckBox cb1;
	RadioGroup rg;
	SensorManager sm;
	Sensor s;
	Vibrator vb;
	CameraManager cm;
	TextToSpeech tts;

	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_main);
		cb1 = findViewById(R.id.cbVibrate);
		rg = findViewById(R.id.rg1);
		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		cm = (CameraManager) getSystemService(CAMERA_SERVICE);
		vb = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		s = sm.getDefaultSensor(Sensor.TYPE_LIGHT);

		if (s == null) {
			Toast.makeText(this, "Sensor is not present", Toast.LENGTH_LONG).show();
		}
		tts = new TextToSpeech(this, this);

	}

	@Override
	protected void onPause() {
		super.onPause();
		if (s != null) {
			sm.unregisterListener(this);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (s != null) {
			sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
		}
	}

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {
		tv.setText("Value: " +sensorEvent.values[0]);
		int id = rg.getCheckedRadioButtonId();
		if (id == R.id.rbLight) {
			try {
				String name = cm.getCameraIdList()[0];
				cm.setTorchMode(name, true);
			} catch (CameraAccessException e) {
				throw new RuntimeException(e);
			}
		}
		else if(id == R.id.rbSpeak){
			tts.speak("" +(int) sensorEvent.values[0], TextToSpeech.QUEUE_ADD, new HashMap<>());

		}
		if(cb1.isChecked()) {
			vb.vibrate(5000);
		}

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {

	}

	@Override
	public void onInit(int i) {

	}
}