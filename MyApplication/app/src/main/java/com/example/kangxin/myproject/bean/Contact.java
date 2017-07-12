package com.example.kangxin.myproject.bean;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by kangxin on 17/7/12.
 */
public class Contact extends RealmObject {
    public String name;
    public RealmList<Email> emails;

}
