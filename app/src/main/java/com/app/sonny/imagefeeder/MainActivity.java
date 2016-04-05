package com.app.sonny.imagefeeder;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String CAMERAKEY = "CAMERA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //////////////////////

    public boolean isCamera (Context context){
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            return true;
        else
            return false;
    }

    public int numOfCamera(Context context) {
        return Camera.getNumberOfCameras();
    }

    public static Camera openCamera (Context context){
        Camera camera = null;

        try {
            camera.open();
        }catch (Exception e){
            Toast toast = Toast.makeText(context, "Camera cannot be Opened!", Toast.LENGTH_SHORT);
            toast.show();
        }

        return camera;
    }

    //////////////////////////////


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
