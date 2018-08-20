package com.example.android.tunesignal;

public class Word {

    private String mSong;
    private int mImage;
    private int mAudioResourceId;

    public Word(String currentSong, int picture, int audioResourceId) {
        mSong = currentSong;
        mImage = picture;
        mAudioResourceId = audioResourceId;
    }

    public String getmCurrentSong() {
        return mSong;
    }

    public int getmAlbumImage() {
        return mImage;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

}
