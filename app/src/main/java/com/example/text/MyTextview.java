package com.example.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyTextview extends androidx.appcompat.widget.AppCompatTextView {
    public MyTextview(Context context) {
        super(context);
    }

    public MyTextview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            Toast.makeText(getContext(),this.getText().toString(),Toast.LENGTH_SHORT).show();
        }
        //lala
        return true;
    }
}
