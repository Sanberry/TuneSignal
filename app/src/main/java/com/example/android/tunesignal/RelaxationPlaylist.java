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

public class RelaxationPlaylist extends AppCompatActivity {
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
        LinearLayout clickToPlay = (LinearLayout) findViewById(R.id.relax_display);
        clickToPlay.setVisibility(View.VISIBLE);
        final ArrayList<Word> songs = new ArrayList<>();
        songs.add(new Word(getString(R.string.girls_just_want_to_have_fun), R.drawable.girls_just_want_to_have_fun, R.raw.girls_just_want_to_have_fun));
        songs.add(new Word(getString(R.string.wuthering_heights), R.drawable.wuthering_heights, R.raw.wuthering_heights));
        songs.add(new Word(getString(R.string.lady_in_black), R.drawable.lady_in_black, R.raw.lady_in_black));
        songs.add(new Word(getString(R.string.whiskey_in_the_jar), R.drawable.whiskey_in_the_jar, R.raw.whiskey_in_the_jar));
        songs.add(new Word(getString(R.string.anyway_you_want_it), R.drawable.anyway_you_want_it, R.raw.anyway_you_want_it));
        songs.add(new Word(getString(R.string.miss_conception), R.drawable.miss_conception, R.raw.miss_conception));
        songs.add(new Word(getString(R.string.bohemian_rhapsody), R.drawable.bohemian_rhapsody, R.raw.bohemian_rhapsody));
        songs.add(new Word(getString(R.string.angel_of_the_morning), R.drawable.angel_of_the_morning, R.raw.angel_of_the_morning));
        WordAdapter adapter = new WordAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word song = songs.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(RelaxationPlaylist.this, song.getmAudioResourceId());
                LinearLayout songDetail = (LinearLayout) findViewById(R.id.buttons);
                LinearLayout clickToPlay = (LinearLayout) findViewById(R.id.relax_display);
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
                        LinearLayout clickToPlay = (LinearLayout) findViewById(R.id.relax_display);
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

