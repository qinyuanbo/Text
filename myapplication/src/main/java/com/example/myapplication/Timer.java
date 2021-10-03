package com.example.myapplication;

import android.os.Handler;

public class Timer implements Runnable{
    int timer;
    TimeConnect timeConnect;
    Handler handler;
    public Timer(int timer, TimeConnect timeConnect) {
        this.timer = timer;
        this.timeConnect = timeConnect;

        handler = new Handler();
    }
    public void start(){
        handler.post(this);
    }

    @Override
    public void run() {
        timer--;
        if (timer==0){
            timeConnect.filash();
            handler.removeCallbacks(this);
        }else {
            timeConnect.down(timer);
            handler.postDelayed(this,1000);
        }

    }
    interface TimeConnect{
        void filash();
        void down(int t);
    }
}
