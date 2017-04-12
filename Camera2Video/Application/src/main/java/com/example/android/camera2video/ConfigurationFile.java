package com.example.android.camera2video;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationFile {

    private static final String TAG = "DEBUG";
    private static Map<String, String> map = new HashMap<>();

    public static final String AUTO_START = "AUTO_START";

    private static final String PREFS_NAME = "preferences";
    private static SharedPreferences settings;
    private static CameraActivity cameraActivity;

    public static void readConfig(){
        settings = cameraActivity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String autoStart = settings.getString(AUTO_START, null);
        Log.d(TAG, "Read " + AUTO_START + ": " + autoStart);
        map.put(AUTO_START, autoStart);
    }

    public static void init(CameraActivity newCameraActivity) {
        // Restore preferences
        cameraActivity = newCameraActivity;
        settings = cameraActivity.getSharedPreferences(PREFS_NAME, 0);
        Log.d(TAG, "Init");
        readConfig();
    }

    public static void addValue(String key, String value){
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
        return map.get(key);
    }
}
