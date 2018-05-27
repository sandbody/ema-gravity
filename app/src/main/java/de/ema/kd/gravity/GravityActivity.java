package de.ema.kd.gravity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.ema.kd.gravity.event.GravityEventListener;
import de.ema.kd.gravity.service.GravityService;

public class GravityActivity extends AppCompatActivity implements GravityEventListener {


    private GravityService gravityService;
    private TextView viewX;
    private TextView viewY;
    private TextView viewZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);
        viewX = findViewById(R.id.x_gravity);
        viewY = findViewById(R.id.y_gravity);
        viewZ = findViewById(R.id.z_gravity);

        Button buttonStart = (Button) findViewById(R.id.button_start);
        Button buttonStop = (Button) findViewById(R.id.button_stop);
        addAction(buttonStart);
        addAction(buttonStop);

        gravityService = new GravityService(this);

    }



    @Override
    public void onGravityChanged(float[] gravity) {
        viewX.setText(Float.toString(gravity[0]));
        viewY.setText(Float.toString(gravity[1]));
        viewZ.setText(Float.toString(gravity[2]));
    }




    private void addAction(final Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getId() == R.id.button_start){
                    gravityService.start();
                }
                if(button.getId() == R.id.button_stop){
                    gravityService.stop();
                }
            }
        });
    }
}
