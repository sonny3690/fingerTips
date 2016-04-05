package com.app.sonny.imagefeeder;

/**
 * Created by Sonny on 4/3/2016.
 */
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class DynamicClick implements OnClickListener {

    int counter;
    public DynamicClick(int acounter) {
        this.counter = acounter;
    }

    public void onClick(View v) {
        Log.v("DynamicOnClickListener", "" + counter);
        Toast.makeText(v.getContext(), String.valueOf(counter), Toast.LENGTH_LONG).show();
    }

}