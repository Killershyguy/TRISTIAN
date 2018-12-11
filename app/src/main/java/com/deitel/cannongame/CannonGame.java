package com.deitel.cannongame;

import android.app.Activity;
import android.os.Bundle;

import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class CannonGame extends Activity {

    private GestureDetector gestureDetector;
    private CannonView cannonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        cannonView = (CannonView) findViewById(R.id.cannonView);

        gestureDetector=new GestureDetector(this,gestureListener);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void onPause() {
        super.onPause();
        cannonView.stopGame();
    }

    public void onDestroy() {
        super.onDestroy();
        cannonView.releaseResources();
    }

    SimpleOnGestureListener gestureListener = new SimpleOnGestureListener() {
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            cannonView.fireCannonball(e);
            return true;
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int action = e.getAction();
        if(action==MotionEvent.ACTION_DOWN || action==MotionEvent.ACTION_MOVE)
            cannonView.alignCannon(e);
        return gestureDetector.onTouchEvent(e);
    }
}
