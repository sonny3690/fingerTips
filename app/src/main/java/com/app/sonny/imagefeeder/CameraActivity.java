package com.app.sonny.imagefeeder;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Sonny on 4/2/2016.
 */


public class CameraActivity extends Activity {

    Preview preview;
    Button button, xButton;
    Camera camera;
    Activity act;
    byte[] pictureBytes;
    ColorDetection colorDetection;
    FrameLayout layout;
    int dimensions;
    Camera.PictureCallback pictureCallback;

    Context ctx;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        int resId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            dimensions = getResources().getDimensionPixelSize(resId);
        }

        button = (Button) findViewById(R.id.btnCapture);
        ctx = this;
        act = this;

        layout = (FrameLayout) findViewById(R.id.layout);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);


        checkPermission();


        preview = new Preview(this, (SurfaceView) findViewById(R.id.surfaceView));
        preview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ((FrameLayout) findViewById(R.id.layout)).addView(preview);
        preview.setKeepScreenOn(true);

        pictureCallback = new Camera.PictureCallback() {
            public void onPictureTaken(byte[] data, Camera camera) {

                pictureBytes = data;
                outputImageFile(data);
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                colorDetection = new ColorDetection(bitmap, 1920, 1080);

            }
        };


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera.startPreview();
                camera.takePicture(null, null, pictureCallback);

                if (button.getText().equals("Process")) {
                } else {


                    pictureTaken();

                }
            }
        });

    }

    public void pictureTaken() {


        xButton = new Button(this);
        xButton.setText("X");
        xButton.setTextColor(Color.parseColor("#FFFFFF"));
        xButton.setBackgroundColor(Color.TRANSPARENT);
        xButton.setTextSize(30);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, 0);
        xButton.setLayoutParams(lp);
        layout.addView(xButton);
        this.button.setBackgroundColor(Color.parseColor("#F32FA2"));
        xButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera.startPreview();
                layout.removeView(xButton);
                button.setText("Take");
                button.setBackgroundColor(Color.parseColor("#399099"));

            }
        });


        this.button.setText("Process");

        camera.stopPreview();

    }

    public void checkPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA);

        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, 0
            );

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        int numCams = Camera.getNumberOfCameras();
        Log.w("CAMS", "" + numCams);
        if (numCams > 0) {
            try {
                camera = Camera.open(0);
                camera.startPreview();
                preview.setCamera(camera);

            } catch (RuntimeException ex) {
                Toast.makeText(ctx, "Camera Not Found", Toast.LENGTH_LONG).show();
            }

        }
    }

    @Override
    protected void onPause() {
        if (camera != null) {
            camera.stopPreview();
            preview.setCamera(null);
            camera.release();
            camera = null;
        }
        super.onPause();
    }

    private void refreshGallery(File file) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(Uri.fromFile(file));
        sendBroadcast(mediaScanIntent);
    }

    private ImageView outputImageFile(byte[] bytes) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(bitmap);
        Toast toast = Toast.makeText(getBaseContext(), "Image Created", Toast.LENGTH_SHORT);
        toast.show();
        Log.w("Picture", "TAKEN!!");
        /*ImageView imageView = new ImageView(this);

        imageView.setImageResource(R.drawable.sheet);*/
        transition();

        return imageView;
    }

    private void transition() {
        Intent intent = new Intent(getApplicationContext(), NoteList.class);
        startActivity(intent);


    }


}