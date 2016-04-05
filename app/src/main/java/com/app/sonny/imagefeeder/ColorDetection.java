package com.app.sonny.imagefeeder;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sonny on 4/3/2016.
 */
public class ColorDetection {
    ArrayList <Integer> sampleValues;

    int averageWidthCheck = 20;
    float[] lineWidthColVals;

    public ColorDetection(Bitmap bitmap, int screenWidth, int screenHeight) {
//        final int average = 100;
//        ArrayList<Integer> lineValues = new ArrayList<Integer>();
//         sampleValues = new ArrayList<Integer>();
//
//        lineWidthColVals = new float[screenHeight / averageWidthCheck];
//        int lineCount = 0;
//        int counter = 0;
//
//        for (int i = 0; i < screenHeight; i += 5*averageWidthCheck) {
//            float lineColVal = 0;
//            float subLineColVal = 0;
//            for (int t = 0; t < averageWidthCheck; t+= 100) {
//                for (int j = 0; j < screenWidth; j+= 100) {
//                    int pixel = bitmap.getPixel(i, j);
//                    int color = Color.red(pixel) + Color.green(pixel) + Color.blue(pixel);
//                    subLineColVal += color;
//
////                    if (isBlack(bitmap, i, j, average)) {
////                        //pixel is black
////                   /* coordsx.add(j);
////                    coordsx.add(i);*/
////
////                        if (isLine(bitmap, i, j, average)) {
////                            lineValues.add(i);
////                            lineCount++;
////                            i += 2;
////
////                        } else {
////                            i += 2;
////                        }
////                    }
//                }
//                lineColVal += subLineColVal;
//            }
//
//            lineColVal /= averageWidthCheck;
//            lineWidthColVals[counter] = lineColVal;
//            counter++;
//        }
//
//        int varriation = 300;
//
//        java.util.Arrays.sort(lineWidthColVals);
//            for(int i = 0; i < lineWidthColVals.length; i++){
//               if(i+1 <= lineWidthColVals.length){
//                   if(lineWidthColVals[i] - lineWidthColVals[i+1] <= varriation &&
//                           lineWidthColVals[i] - lineWidthColVals[i+1] >= -varriation){
//                       lineCount++;
//                   }
//            }
//
//
//        }
//
//
//
//
//        Log.w("FINAL LINE COUNT", "" + lineCount);
    }

    public boolean isBlack(Bitmap bitmap, int i, int j, int average) {
        int pixel = bitmap.getPixel(i, j);
        int color = Color.red(pixel) + Color.green(pixel) + Color.blue(pixel);
        //Log.w("color", "" + color);
        if (color <=  average) return true;
        else return false;

    }

    public boolean isLine(Bitmap bitmap, int x, int y, int average) {
        if (isBlack(bitmap, x, y+5, average) && isBlack(bitmap, x, y+10, average))
            return true;
        else
            return false;


    }

    public int sampleAverage (Bitmap bitmap){
        int sum = 0;
        Random random = new Random();



        for (int i =0; i < 20; i++){

            int pixels = bitmap.getPixel(random.nextInt(1920),random.nextInt(1080) );
            int color = Color.red(pixels) + Color.blue(pixels) +  Color.green(pixels);

            sum += color;

        }
        return sum/20;
    }


}
