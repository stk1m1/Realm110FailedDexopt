package com.example.hsiangleekwok.realm110faileddexopt.realm;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;

/**
 * <b>Description: </b>Realm Migration operation here<br />
 * <b>Author: </b>Hsiang Leekwok <br />
 * <b>Time: </b>2016/07/13 13:49
 */
public class Migration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        // some migration
    }
}
