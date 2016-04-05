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
import android.widget.RelativeLayout;

import java.util.Random;

/**
 * Created by Lucas on 4/2/16.
 */
public class NoteList extends Activity implements View.OnClickListener {

    protected static final String TAG = "notesListMessage";
    private Random random = new Random();
    int notesNumber = random.nextInt(5) + 3;
    String[] notes = new String[notesNumber];


    private void randomTest(){
        for(int i = 0; i < notes.length; i++){
            int c = random.nextInt(0xffffff);
            String hexColor = String.format("#%06X", (0xFFFFFF & c));
            notes[i] = hexColor;
            Log.i(NoteList.TAG, "" + hexColor);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(NoteList.TAG, "Playing");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.noteslayout);

        randomTest();

        for (int i = 1; i <= notesNumber; i++) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            Button note = new Button(this);
            int y = (i * 200) - 150;
            note.setY(y);
            note.setId((i + 100000));
            Log.i(NoteList.TAG, "" + note.getId());

            final int id_ = note.getId();

            note.setText("button " + id_);
            note.setBackgroundColor(Color.rgb(70, 80, 90));
            relativeLayout.addView(note, params);
            note = ((Button) findViewById(id_));

            note.setOnClickListener(new DynamicClick(i + 100000){
                public void onClick(View v){
                    Intent diagramIntent = new Intent(getApplicationContext(), DiagramActivity.class);
                    if(v.getId() == this.counter){
                        Log.i(NoteList.TAG, "" + this.counter);
                        DiagramActivity.color = notes[this.counter - 100001];
                        Log.i(NoteList.TAG, "" + notes[this.counter - 100001]);
                        startActivity(diagramIntent);
                    }
                }
            });

//                note.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent diagramActivityIntent = new Intent(getApplicationContext(), DiagramActivity.class);
//
//                        Log.i(NotesActivity.TAG, "a:"+v.getId());
//                        if(v.getId() == 100001) {
//                            startActivity(diagramActivityIntent);
//                        }
//                    }
//                });
        }

        final Button mainMenuButton = (Button)this.findViewById(R.id.mainMenuButton);
        mainMenuButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.i(NoteList.TAG, "Back to Main");
                Intent mainActivityIntent = new Intent(getApplicationContext(), MenuClass.class);

                if(v.getId() == R.id.mainMenuButton) {
                    startActivity(mainActivityIntent);
                }
            }
        });

        final Button takePhotoButton = (Button)this.findViewById(R.id.takePhotoButton);
        takePhotoButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.i(NoteList.TAG, "Taking Photo");
                Intent mainActivityIntent = new Intent(getApplicationContext(), CameraActivity.class);

                if(v.getId() == R.id.takePhotoButton) {
                    startActivity(mainActivityIntent);
                }
            }
        });



//        final Button aChordButton = (Button)this.findViewById(R.id.playAChord);
//        final MediaPlayer aChordSound = MediaPlayer.create(this, R.raw.testmusic);
//        Button gChordButton = (Button)this.findViewById(R.id.playGChord);
//        final MediaPlayer gChordSound = MediaPlayer.create(this, R.raw.testmusic);
//        Button cChordButton = (Button)this.findViewById(R.id.playCChord);
//        final MediaPlayer cChordSound = MediaPlayer.create(this, R.raw.testmusic);
//
//        aChordButton.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v) {
//                System.out.println("Playing A Chord");
//                Log.i(NoteList.TAG, "Playing A Chord tag");
//                cChordSound.pause();
//                gChordSound.pause();
//                aChordSound.seekTo(0);
//                aChordSound.start();
//                Log.i(NoteList.TAG, "Done Playing A Chord tag");
//            }
//        });
//
//        gChordButton.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v) {
//                Log.i(NoteList.TAG, "Playing G Chord tag");
//                aChordSound.pause();
//                cChordSound.pause();
//                gChordSound.seekTo(0);
//                gChordSound.start();
//                Log.i(NoteList.TAG, "Done Playing G Chord tag");
//            }
//        });
//
//        cChordButton.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v) {
//                Log.i(NoteList.TAG, "Playing C Chord tag");
//                aChordSound.pause();
//                gChordSound.pause();
//                cChordSound.seekTo(0);
//                cChordSound.start();
//                Log.i(NoteList.TAG, "Done Playing C Chord tag");
//            }
//        });
    }

    @Override
    public void onClick(View v) {

    }
}