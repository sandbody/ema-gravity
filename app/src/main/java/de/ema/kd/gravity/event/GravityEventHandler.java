package de.ema.kd.gravity.event;

import java.util.ArrayList;
import java.util.List;

public class GravityEventHandler {

    private static final GravityEventHandler instance = new GravityEventHandler();
    private List<GravityEventListener> listeners;

    private GravityEventHandler(){
        listeners = new ArrayList<>();
    }

    public static GravityEventHandler getInstance(){
        return instance;
    }

    public void addGravityEventListener(GravityEventListener gravityEventListener){
        listeners.add(gravityEventListener);
    }


    public void onGravityChanged(final float[] values) {
        for (GravityEventListener listner:listeners) {
            listner.onGravityChanged(values);
        }
    }

}
