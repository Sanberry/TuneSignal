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
        LinearLayout clickToPlay = (LinearLayout) findViewById(R.id.samuelito_display);
        clickToPlay.setVisibility(View.VISIBLE);
        final ArrayList<Word> songs = new ArrayList<>();
        songs.add(new Word(getString(R.string.across_the_sea), R.drawable.across_the_sea, R.raw.across_the_sea));
        songs.add(new Word(getString(R.string.draconian_love), R.drawable.draconian_love, R.raw.draconian_love));
        songs.add(new Word(getString(R.string.the_bards_song), R.drawable.the_bards_song, R.raw.the_bards_song));
        songs.add(new Word(getString(R.string.love_me_in_black), R.drawable.love_me_in_black, R.raw.love_me_in_black));
        songs.add(new Word(getString(R.string.the_magic_of_the_wizards_dream), R.drawable.the_magic_of_the_wizards_dream, R.raw.the_magic_of_wizards_dream));
        songs.add(new Word(getString(R.string.hijo_de_la_luna), R.drawable.hijo_de_la_luna, R.raw.hijo_de_la_luna));
        songs.add(new Word(getString(R.string.hoy_tuca_ser_feliz), R.drawable.hoy_toca_ser_feliz, R.raw.hoy_toca_ser_feliz));
        WordAdapter adapter = new WordAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word song = songs.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(SamuelitoPlaylist.this, song.getmAudioResourceId());
                LinearLayout songDetail = (LinearLayout) findViewById(R.id.buttons);
                LinearLayout clickToPlay = (LinearLayout) findViewById(R.id.samuelito_display);
                clickToPlay.setVisibility(View.INVISIBLE);
                mMediaPlayer.start();
                ImageView playButton = (ImageView) findViewById(R.id.play);
                ImageView pauseButton = (ImageView) findViewById(R.id.pause);
                ImageView stopButton = (ImageView) findViewById(R.id.stop);
                songDetail.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.INVISIBLE);
                pauseButton.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.VISIBLE);
                playButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LinearLayout songDetail = (LinearLayout) findViewById(R.id.buttons);
                        ImageView playButton = (ImageView) findViewById(R.id.play);
                        ImageView pauseButton = (ImageView) findViewById(R.id.pause);
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        songDetail.setVisibility(View.VISIBLE);
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
                        mMediaPlayer.stop();
                        LinearLayout songDetail = (LinearLayout) findViewById(R.id.buttons);
                        songDetail.setVisibility(View.INVISIBLE);
                        LinearLayout clickToPlay = (LinearLayout) findViewById(R.id.samuelito_display);
                        clickToPlay.setVisibility(View.VISIBLE);
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        releaseMediaPlayer();
                    }
                });
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

