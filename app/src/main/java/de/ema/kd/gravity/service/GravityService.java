package de.ema.kd.gravity.service;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import de.ema.kd.gravity.GravityActivity;
import de.ema.kd.gravity.event.GravityEventHandler;

public class GravityService  implements SensorEventListener{
    private GravityEventHandler gravityEventHandler;
    private SensorManager sensorManager;
    private Sensor acceletometer ;

    public GravityService(GravityActivity activity){

        sensorManager = (SensorManager)activity.getSystemService(Context.SENSOR_SERVICE);
        acceletometer = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        gravityEventHandler = GravityEventHandler.getInstance();
    }



    public void start(){
        if(null != acceletometer){
            sensorManager.registerListener(this, acceletometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    public void stop(){
        sensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        gravityEventHandler.onGravityChanged(event.values);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
