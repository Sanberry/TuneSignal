package com.example.android.tunesignal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class SelectionPage extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_page);
        ImageButton samuelitoPlayList = (ImageButton) findViewById(R.id.SamuelitoSongs);
        samuelitoPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();
                Intent startSamuelioPlaylist = new Intent(SelectionPage.this, SamuelitoPlaylist.class);
                startActivity(startSamuelioPlaylist);


            }
        });
        ImageButton relaxationPlayList = (ImageButton) findViewById(R.id.AnxiousFreeSongs);
        relaxationPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();
                Intent startRelaxationPlaylist = new Intent(SelectionPage.this, RelaxationPlaylist.class);
                startActivity(startRelaxationPlaylist);
            }
        });
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}