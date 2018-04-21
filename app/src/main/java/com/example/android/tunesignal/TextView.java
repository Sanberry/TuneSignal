package com.example.android.tunesignal;

import android.content.Context;

public class TextView {

        //String value
        private String mText;
        //Text color
        private int mTextColor;
        //Context of the app
        private Context mContext;

    public TextView(Context context) {
        mText = "";
        mTextColor = 0;
        mContext = context;
    }
        public void setText(String text) {
            mText = text;
        }

        /**
         * Sets the textColor of the TextView
         * @param color of the text to be display.
         */
        public void setTextColor(int color) {
            mTextColor = color;
        }
        /**
         * Gets the string value in TextView
         * @return current text in the TextView
         */
        public String getText(){
            return mText;
        }
        /**
         * Gets the text color of the TextView
         * @return current text color
         */
        public int getTextColor(){
            return mTextColor;
        }
    }

