package com.app.sonny.imagefeeder;

/**
 * Created by Sonny on 4/3/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SplashScreen extends Activity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);


        Thread timerThread = new Thread() {

            public void run() {

                try {
                    sleep(1700);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                } finally {


                    Intent intent = new Intent(getApplicationContext(), MenuClass.class);
                    startActivity(intent);


                }

            }

        };

        timerThread.start();

      /*  Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
        startActivity(intent);*/

    }


    @Override

    protected void onPause() {

        // TODO Auto-generated method stub

        super.onPause();

        finish();

    }

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