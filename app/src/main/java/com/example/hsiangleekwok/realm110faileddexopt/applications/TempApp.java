package com.example.hsiangleekwok.realm110faileddexopt.applications;

import android.app.Application;
import android.util.Log;

import com.example.hsiangleekwok.realm110faileddexopt.realm.Migration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * <b>Description: </b><br />
 * <b>Author: </b>Hsiang Leekwok <br />
 * <b>Time: </b>2016/07/13 13:38 <br />
 */
public class TempApp extends Application {

    private static final String TAG = "TempAPP";

    @Override
    public void onCreate() {
        super.onCreate();
        // some other place to get a name(ex. get from preference or remote server)
        // sometimes local value is different from remote, so need re-config realm here
        String name = "test.realm";// fetchingNameFromServerInTask();
        configRealmByName(name);
    }

    private void configRealmByName(String name) {
        RealmConfiguration rcf = null;
        try {
            rcf = Realm.getDefaultInstance().getConfiguration();
        } catch (Exception ignore) {
            Log.e(TAG, "No default realm instance, now create it for " + name);
        }
        if (null == rcf) {
            configDefaultRealm(name);
        }
    }

    private void configDefaultRealm(String name) {
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder(getApplicationContext())
                .schemaVersion(0)
                .migration(new Migration())
                .name(name);
        //if (getResources().getInteger(R.integer.app_database_migration_delete) > 0) {
        //builder.deleteRealmIfMigrationNeeded();
        //}
        Realm.removeDefaultConfiguration();
        Realm.setDefaultConfiguration(builder.build());
    }
}
