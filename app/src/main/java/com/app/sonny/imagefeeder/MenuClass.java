package com.app.sonny.imagefeeder;

/**
 * Created by Sonny on 4/3/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MenuClass extends Activity implements View.OnClickListener {

    protected static final String TAG = "crazeeMessage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Button takePhotoButton = (Button) this.findViewById(R.id.takePhotoButton);
        takePhotoButton.setOnClickListener(this);
        Log.i(TAG, "onCreate");
    }

    // @Override
    public void onClick(View v) {
        Intent cameraActivityIntent = new Intent(getApplicationContext(), CameraActivity.class);

        if (v.getId() == R.id.takePhotoButton) {
            startActivity(cameraActivityIntent);
        }
    }


}
