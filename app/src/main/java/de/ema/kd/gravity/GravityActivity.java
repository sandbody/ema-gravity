package de.ema.kd.gravity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GravityActivity extends AppCompatActivity {
    private boolean isRunning = false;
    private GravityService gravityService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);
        gravityService = new GravityService(this);
        Button buttonStart = (Button) findViewById(R.id.button_start);
        Button buttonStop = (Button) findViewById(R.id.button_stop);
        addAction(buttonStart);
        addAction(buttonStop);
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
