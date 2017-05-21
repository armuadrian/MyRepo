package com.example.android.camera2video;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class Intro extends AppIntro {
    private Resources resources;
    private static final String TAG = "DEBUG";
    private static final boolean DEBUG = true;
    @Override
    public void init(Bundle savedInstanceState) {
        resources = this.getResources();
        if (DEBUG) Log.i(TAG, "Init");
        addSlide(AppIntroFragment.newInstance
                 (resources.getString(R.string.intro_slide_1_title),
                  resources.getString(R.string.intro_slide_1_text), R.mipmap.start,
                  0xFF3f51b5));
        addSlide(AppIntroFragment.newInstance
                 (resources.getString(R.string.intro_slide_2_title),
                  resources.getString(R.string.intro_slide_2_text),
                  R.mipmap.map_info,
                  0xFFf44336));
        addSlide(AppIntroFragment.newInstance
                 (resources.getString(R.string.intro_slide_3_title),
                  resources.getString(R.string.intro_slide_3_text),
                  R.mipmap.video_status,
                  0xFF263238));
        addSlide(AppIntroFragment.newInstance
                 (resources.getString(R.string.intro_slide_4_title),
                  resources.getString(R.string.intro_slide_4_text),
                  R.mipmap.settings,
                  0xFF9c27b0));
        addSlide(AppIntroFragment.newInstance
                 (resources.getString(R.string.intro_slide_5_title),
                  resources.getString(R.string.intro_slide_5_text),
                  R.mipmap.start_stop,
                  0xFFffb300));
    }

    @Override
    public void onSkipPressed() {
        // Do something when users tap on Skip button.
        finish();
    }

    @Override
    public void onDonePressed() {
        // Do something when users tap on Done button.
        finish();
    }

    public void onSlideChanged() {
        // Do something when the slide changes.
    }
}
