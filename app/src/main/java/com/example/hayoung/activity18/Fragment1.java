package com.example.hayoung.activity18;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

/**
 * Created by hayoung on 2017. 8. 17..
 */

public class Fragment1 extends Fragment {

    EditText nameInput;
    EditText authorInput;
    EditText contentInput;
    Button button;

    OnDatabaseCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callback = (OnDatabaseCallback) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        nameInput = (EditText) rootView.findViewById(R.id.nameInput);
        authorInput = (EditText) rootView.findViewById(R.id.authorInput);
        contentInput = (EditText) rootView.findViewById(R.id.contentInput);
        button = (Button) rootView.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String author = authorInput.getText().toString();
                String content = contentInput.getText().toString();


                callback.insert(name, author, content);
                Toast.makeText(getContext(), "데이터 베이스에 저장되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
