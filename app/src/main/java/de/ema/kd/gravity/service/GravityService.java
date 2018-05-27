package de.ema.kd.gravity.service;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import de.ema.kd.gravity.GravityActivity;
import de.ema.kd.gravity.csv.CsvWriterService;
import de.ema.kd.gravity.event.GravityEventHandler;

public class GravityService  implements SensorEventListener{
    private GravityEventHandler gravityEventHandler;
    private CsvWriterService writer;
    private SensorManager sensorManager;
    private Sensor acceletometer ;

    public GravityService(GravityActivity activity){
        gravityEventHandler = GravityEventHandler.getInstance();
        writer = new CsvWriterService();

        sensorManager = (SensorManager)activity.getSystemService(Context.SENSOR_SERVICE);
        acceletometer = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);


        gravityEventHandler.addGravityEventListener(activity);
        gravityEventHandler.addGravityEventListener(writer);


    }



    public void start(){
        if(null != acceletometer){
            writer.doPrepare(true);
            sensorManager.registerListener(this, acceletometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    public void stop(){
        writer.doPrepare(false);
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
