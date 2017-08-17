package com.example.hayoung.activity18;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by hayoung on 2017. 8. 17..
 */

public class BookAdapter extends BaseAdapter {
    ArrayList<BookInfo> items = new ArrayList<>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(BookInfo item) {
        items.add(item);
    }

    public void setItems(ArrayList<BookInfo> items) {
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookItemView bookItemView = new BookItemView(parent.getContext());

        BookInfo item = items.get(position);
        bookItemView.setName(item.getName());
        bookItemView.setAuthor(item.getAuthor());

        return bookItemView;

    }
}
