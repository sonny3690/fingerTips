package com.app.sonny.imagefeeder;

/**
 * Created by Sonny on 4/3/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Lucas on 4/3/16.
 */
public class DiagramActivity extends Activity {

    protected static final String TAG = "diagramMessage";
    public static String color = "#ff00ff";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(DiagramActivity.TAG, "Playing");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagram);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.diagramlayout);
        relativeLayout.setBackgroundColor(Color.parseColor(color));

        ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.image);
        mImageView.setImageResource(R.drawable.gchord);
//        color = 0xaa23ff;
//        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
//        getWindow().getDecorView().setBackgroundColor(0xaaaaaa);

//        setContentView(R.layout.activity_diagram);
//        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
//        getWindow().getDecorView().setBackgroundColor(0xaaaaaa);
//
////        // Now get a handle to any View contained
////        // within the main layout you are using
////        View someView = findViewById(R.id.diagramlayout);
////
////        // Find the root view
////        View root = someView.getRootView();
////
////        // Set the color
////        root.setBackgroundColor(0xaa11aa);


        final Button mainMenuButton = (Button)this.findViewById(R.id.mainMenuButton);
        mainMenuButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.i(DiagramActivity.TAG, "Back to Main");
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);

                if(v.getId() == R.id.mainMenuButton) {
                    startActivity(mainActivityIntent);
                }
            }
        });

        final Button backButton = (Button)this.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.i(DiagramActivity.TAG, "Back to Notes");
                Intent notesActivityIntent = new Intent(getApplicationContext(), NoteList.class);

                if(v.getId() == R.id.backButton) {
                    startActivity(notesActivityIntent);
                }
            }
        });


        final Button takePhotoButton = (Button)this.findViewById(R.id.takePhotoButton);
        takePhotoButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.i(DiagramActivity.TAG, "Taking Photo");
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);

                if(v.getId() == R.id.takePhotoButton) {
                    startActivity(mainActivityIntent);
                }
            }
        });
    }



}
