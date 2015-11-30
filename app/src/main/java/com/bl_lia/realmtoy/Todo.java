package com.bl_lia.realmtoy;

import org.apache.commons.lang3.RandomStringUtils;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by yuki_fn on 11/30/15.
 */
public class Todo extends RealmObject {

    @PrimaryKey
    private String id;
    private String name;
    private boolean isChecked;

    public Todo() {
        this.id = RandomStringUtils.randomAlphanumeric(10);
        this.name = null;
        this.isChecked = false;
    }

    public Todo(String id, String name, boolean isChecked) {
        this.id = id;
        this.name = name;
        this.isChecked = isChecked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
