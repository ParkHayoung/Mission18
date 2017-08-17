package com.example.hayoung.activity18;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hayoung on 2017. 8. 17..
 */

public class BookItemView extends LinearLayout {
    TextView txtName;
    TextView txtAuthor;
    ImageView imageView;

    public BookItemView(Context context) {
        super(context);

        init(context);
    }

    public BookItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.book_item, this, true);

        txtName = (TextView) findViewById(R.id.txtName);
        txtAuthor = (TextView) findViewById(R.id.txtAuthor);
        imageView = (ImageView) findViewById(R.id.imageView);

    }

    public void setName(String name) {
        txtName.setText(name);
    }

    public void setAuthor(String author) {
        txtAuthor.setText(author);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
