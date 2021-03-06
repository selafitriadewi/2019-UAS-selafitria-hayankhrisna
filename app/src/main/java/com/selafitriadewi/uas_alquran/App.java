package com.selafitriadewi.uas_alquran;

import android.app.Application;
import android.content.res.Resources;


import com.selafitriadewi.uas_alquran.database.DatabaseHelper;
import com.selafitriadewi.uas_alquran.utils.PreferenceApp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App extends Application {

    private static Resources resources;

    @Override
    public void onCreate() {
        super.onCreate();

        resources = getResources();
        DatabaseHelper.initDatabase(this);
        PreferenceApp.initPreferences(this);
    }

    public static BufferedReader getRawResources(int res){
        InputStream streamReader = resources.openRawResource(res);
        return new BufferedReader(new InputStreamReader(streamReader));
    }

}