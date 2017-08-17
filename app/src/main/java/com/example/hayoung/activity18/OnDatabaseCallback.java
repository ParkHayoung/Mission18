package com.example.hayoung.activity18;

import java.util.ArrayList;

/**
 * Created by hayoung on 2017. 8. 17..
 */

public interface OnDatabaseCallback {
    public void insert(String name, String author, String content);

    public ArrayList<BookInfo> selectAll();

}
