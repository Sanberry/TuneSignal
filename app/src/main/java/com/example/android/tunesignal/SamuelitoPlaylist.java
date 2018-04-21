package com.example.android.tunesignal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.AdapterView;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class SamuelitoPlaylist extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        final ArrayList<Word> songs = new ArrayList<>();
        songs.add(new Word("Uriah Heep - Lady in Black", R.drawable.lady_in_black, R.raw.lady_in_black));
        songs.add(new Word("Kate Bush - Wuthering Heights", R.drawable.wuthering_heights, R.raw.wuthering_heights));
        songs.add(new Word("Blind Guardian - The Bard's Song", R.drawable.the_bards_song, R.raw.the_bards_song));
        songs.add(new Word("Rhapsody - The Magic of the Wizard's Dream", R.drawable.the_magic_of_the_wizards_dream, R.raw.the_magic_of_wizards_dream));
        songs.add(new Word("Journey - Anyway You Want It", R.drawable.anyway_you_want_it, R.raw.anyway_you_want_it));
        songs.add(new Word("Stravaganzza - Hijo De La Luna", R.drawable.hijo_de_la_luna, R.raw.hijo_de_la_luna));
        songs.add(new Word("Mägo de Oz - Hoy toca ser feliz", R.drawable.hoy_toca_ser_feliz, R.raw.hoy_toca_ser_feliz));
        songs.add(new Word("Juice Newton - Angel of the Morning", R.drawable.angel_of_the_morning, R.raw.angel_of_the_morning));
        WordAdapter adapter = new WordAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word song = songs.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(SamuelitoPlaylist.this, song.getmAudioResourceId());
                LinearLayout songDetail  = (LinearLayout) findViewById(R.id.buttons);
                songDetail.setVisibility(position);
                mMediaPlayer.start();
                ImageView playButton = (ImageView) findViewById(R.id.play);
                ImageView pauseButton = (ImageView) findViewById(R.id.pause);
                ImageView stopButton = (ImageView) findViewById(R.id.stop);
                playButton.setVisibility(View.INVISIBLE);
                playButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView playButton = (ImageView) findViewById(R.id.play);
                        ImageView pauseButton = (ImageView) findViewById(R.id.pause);
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        playButton.setVisibility(View.INVISIBLE);
                        pauseButton.setVisibility(View.VISIBLE);

                    }
        });
                pauseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView playButton = (ImageView) findViewById(R.id.play);
                        ImageView pauseButton = (ImageView) findViewById(R.id.pause);
                        mMediaPlayer.pause();
                        pauseButton.setVisibility(View.INVISIBLE);
                        playButton.setVisibility(View.VISIBLE);
                    }
                });
                stopButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView playButton = (ImageView) findViewById(R.id.play);
                        ImageView pauseButton = (ImageView) findViewById(R.id.pause);
                        mMediaPlayer.stop();
                        pauseButton.setVisibility(View.VISIBLE);
                        playButton.setVisibility(View.VISIBLE);
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        releaseMediaPlayer();
                    }
                });
            }
        });

    }

    public void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}

