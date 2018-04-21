package com.example.android.tunesignal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_main, parent, false);

        }
        // Get the {@link Word} object located at this position in the list
        Word currentSong = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID song_info.
        TextView currentSongView = (TextView) listItemView.findViewById(R.id.song_info);
        ImageView currentImage = (ImageView) listItemView.findViewById(R.id.album);
        currentImage.setImageResource(currentSong.getmAlbumImage());
        // Get the current song title from the list object and set this text on
        // the songInfo TextView.
        currentSongView.setSelected(true);
        currentSongView.setText(currentSong.getmCurrentSong());
        // Return the whole list item layout  so that it can be shown in the ListView.
        return listItemView;
    }

}

