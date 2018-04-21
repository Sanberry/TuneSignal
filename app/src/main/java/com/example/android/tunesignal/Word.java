package com.example.android.tunesignal;

import android.widget.Button;

public class Word {

    private String mSong;
    private int mImage;
    private int mAudioResourceId;
//create a new word object with one string, integer with image of the album and the song associated
    public Word(String currentSong, int picture, int audioResourceId) {
        mSong = currentSong;
        mImage = picture;
        mAudioResourceId = audioResourceId;
    }

    public String getmCurrentSong(){
        return mSong;
    }
    public int getmAlbumImage(){
        return mImage;
    }
    public int getmAudioResourceId(){
        return mAudioResourceId;
    }

}
