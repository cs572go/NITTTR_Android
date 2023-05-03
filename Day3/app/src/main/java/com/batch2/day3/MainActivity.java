package com.batch2.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

	TextView tv1;
	Sensor se2;
	SensorManager sm1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv1 = findViewById(R.id.txt1);

		sm1 = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List <Sensor> lst1 = sm1.getSensorList(Sensor.TYPE_ALL);
		for(Sensor s:lst1){
			tv1.append("\n" + s.getName());
		}

//		Sensor se1 = sm1.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
//		if(se1==null){
//			Toast.makeText(this, "Magnetic field sensor absent", Toast.LENGTH_LONG).show();
//		}
//		else{
//			Toast.makeText(this, "Present", Toast.LENGTH_LONG).show();
//		}
		se2 = sm1.getDefaultSensor(Sensor.TYPE_LIGHT);
		if(se2==null){
			Toast.makeText(this, "Magnetic field sensor absent", Toast.LENGTH_LONG).show();
		}
		else{
			Toast.makeText(this, "Present", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if(se2!=null){
			sm1.unregisterListener(this);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if(se2!=null){
			sm1.registerListener(this, se2, SensorManager.SENSOR_DELAY_NORMAL);
		}
	}

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {
		tv1.setText(" " +sensorEvent.values[0]);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {

	}
}