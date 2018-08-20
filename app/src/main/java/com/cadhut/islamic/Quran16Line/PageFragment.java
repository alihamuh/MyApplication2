package com.cadhut.islamic.Quran16Line;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PageFragment extends Fragment {

    private int imageResource;
    private Bitmap bitmap;

    private float x1,x2;
    static final int MIN_DISTANCE = 150;


    public static PageFragment getInstance(int resourceID) {
        PageFragment f = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("image_source", resourceID);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageResource = getArguments().getInt("image_source");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View view =inflater.inflate(com.cadhut.islamic.Quran16Line.R.layout.fragment_page, container, false);
        //view.setRotationY(180);

                return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = (ImageView) view.findViewById(com.cadhut.islamic.Quran16Line.R.id.imageView);

        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inSampleSize = 1;
        o.inDither = false;
        bitmap = BitmapFactory.decodeResource(getResources(), imageResource, o);
        imageView.setImageBitmap(bitmap);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        bitmap.recycle();
        bitmap = null;
    }
}