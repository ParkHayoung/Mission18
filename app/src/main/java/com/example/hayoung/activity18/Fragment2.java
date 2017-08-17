package com.example.hayoung.activity18;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by hayoung on 2017. 8. 17..
 */

public class Fragment2 extends Fragment {
    ListView listView;
    OnDatabaseCallback callback;
    BookAdapter bookAdapter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callback = (OnDatabaseCallback) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);

        listView = (ListView) rootView.findViewById(R.id.listView);
        bookAdapter = new BookAdapter();

        ArrayList<BookInfo> result = callback.selectAll();
        bookAdapter.setItems(result);

        listView.setAdapter(bookAdapter);

        Button reloadBtn = (Button) rootView.findViewById(R.id.reloadBtn);
        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<BookInfo> result = callback.selectAll();
                bookAdapter.setItems(result);
                bookAdapter.notifyDataSetChanged();
            }
        });



        return rootView;
    }
}
