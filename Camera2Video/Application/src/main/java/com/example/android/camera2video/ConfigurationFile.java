package com.example.android.camera2video;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationFile {

    private static final String TAG = "DEBUG";
    private static final String PREFS_NAME = "preferences";
    public static final String FILE_NAME = "FILE_NAME";
    public static final String AUTO_START = "AUTO_START";
    public static final String FILE_SIZE = "FILE_SIZE";
    public static final String MAX_DURATION = "MAX_DURATION";
    public static final String INTRO = "INTRO";

    private static Map<String, String> map = new HashMap<>();

    private static SharedPreferences settings;
    private static CameraActivity cameraActivity;

    public static void readConfig(){
        settings = cameraActivity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String autoStart = settings.getString(AUTO_START, null);
        Log.d(TAG, "Read " + AUTO_START + ": " + autoStart);
        map.put(AUTO_START, autoStart);

        String fileName = settings.getString(FILE_NAME, null);
        Log.d(TAG, "Read " + FILE_NAME + ": " + fileName);
        map.put(FILE_NAME, fileName);

        String fileSize = settings.getString(FILE_SIZE, null);
        Log.d(TAG, "Read " + FILE_SIZE + ": " + fileSize);
        map.put(FILE_SIZE, fileSize);

        String maxDuration = settings.getString(MAX_DURATION, null);
        Log.d(TAG, "Read " + MAX_DURATION + ": " + maxDuration);
        map.put(MAX_DURATION, maxDuration);

        String intro = settings.getString(INTRO, null);
        Log.d(TAG, "Read " + INTRO + ": " + intro);
        map.put(INTRO, intro);
    }

    public static void init(CameraActivity newCameraActivity) {
        // Restore preferences
        cameraActivity = newCameraActivity;
        settings = cameraActivity.getSharedPreferences(PREFS_NAME, 0);
        Log.d(TAG, "Init");
        readConfig();
    }

    public static void addValue(String key, String value){
        Log.d(TAG, "Write " + key + ": " + value);
        map.put(key, value);
    }

    public static void saveAll() {
        settings = cameraActivity.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        for(String key : map.keySet()){
            Log.d(TAG, "Write " + key + " with value " + map.get(key));
            editor.putString(key, map.get(key));
        }

        Log.d(TAG, "Close");
        // Commit the edits!
        editor.commit();
    }

    public static String getValue(String key) {

        String value = map.get(key);
        if(value == null){
            return "";
        }

        return value;
    }
}
