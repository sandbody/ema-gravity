package de.ema.kd.gravity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class GravityService implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor acceletometer ;
    private TextView viewX;
    private TextView viewY;
    private TextView viewZ;

    public GravityService(GravityActivity activity){
        viewX = activity.findViewById(R.id.x_gravity);
        viewY = activity.findViewById(R.id.y_gravity);
        viewZ = activity.findViewById(R.id.z_gravity);

        sensorManager = (SensorManager)activity.getSystemService(Context.SENSOR_SERVICE);
        acceletometer = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        //Mit der Kopie der gelieferten Daten arbeiten
        float[] values = event.values.clone();
        viewX.setText(Float.toString(values[0]));
        viewY.setText(Float.toString(values[1]));
        viewZ.setText(Float.toString(values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void start(){
        if(null != acceletometer){
            sensorManager.registerListener(this, acceletometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    public void stop(){
        sensorManager.unregisterListener(this);
    }
}
