package de.ema.kd.gravity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GravityActivity extends AppCompatActivity {
    private boolean isRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);
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
                    Toast.makeText(v.getContext(), "Button Start Clicked", Toast.LENGTH_LONG).show();
                }
                if(button.getId() == R.id.button_stop){
                    Toast.makeText(v.getContext(), "Button Stop Clicked", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
