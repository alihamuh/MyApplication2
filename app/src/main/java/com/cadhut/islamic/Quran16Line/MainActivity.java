package com.cadhut.islamic.Quran16Line;

import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    public ArrayList<Integer> images;
    private BitmapFactory.Options options;
    private ViewPager viewPager;
    private View btnNext, btnPrev;
    private FragmentStatePagerAdapter adapter;
    //private LinearLayout thumbnailsContainer;
    private int[] resourceIDs;


    private float x1,x2;
    static int ITEM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.cadhut.islamic.Quran16Line.R.layout.activity_main);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(com.cadhut.islamic.Quran16Line.R.id.my_toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        images = new ArrayList<>();

         idCatcher();



        //find view by id
        viewPager = (ViewPager) findViewById(com.cadhut.islamic.Quran16Line.R.id.view_pager);
        //thumbnailsContainer = (LinearLayout) findViewById(R.id.container);
        //btnNext = findViewById(R.id.next);
        //btnPrev = findViewById(R.id.prev);

        //btnPrev.setOnClickListener(onClickListener(0));
        //btnNext.setOnClickListener(onClickListener(1));

        setImagesData();


        // init viewpager adapter and attach
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), images);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(ITEM);
        //viewPager.setRotationY(180);




/*
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getApplicationContext(),"onpage selected",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {
                Toast.makeText(getApplicationContext(),"onPage scrolled",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int pos) {
                Toast.makeText(getApplicationContext(),"onPage scrolle changed",Toast.LENGTH_SHORT).show();

            }
        });

*/



        //inflateThumbnails();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    private View.OnClickListener onClickListener(final int i) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i > 0) {
                    //next page
                    if (viewPager.getCurrentItem() < viewPager.getAdapter().getCount() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    }
                } else {
                    //previous page
                    if (viewPager.getCurrentItem() > 0) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                    }
                }
            }
        };
    }

    private void setImagesData() {
        for (int i = 0; i < resourceIDs.length; i++) {
            images.add(resourceIDs[i]);
        }
    }

    /*
    private void inflateThumbnails() {
        for (int i = 0; i < images.size(); i++) {
            View imageLayout = getLayoutInflater().inflate(R.layout.item_image, null);
            ImageView imageView = (ImageView) imageLayout.findViewById(R.id.img_thumb);
            imageView.setOnClickListener(onChagePageClickListener(i));
            options = new BitmapFactory.Options();
            options.inSampleSize = 3;
            options.inDither = false;
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), images.get(i), options );
            imageView.setImageBitmap(bitmap);
            //set to image view
            imageView.setImageBitmap(bitmap);
            //add imageview
            thumbnailsContainer.addView(imageLayout);
        }
    }

    */

    private View.OnClickListener onChagePageClickListener(final int i) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(i);
            }
        };
    }

    void idCatcher(){

     resourceIDs = new int[557];

                for(int i=0;i<557; i++){

                   int index=557-i;
                resourceIDs[i] = getResources().getIdentifier("page_" + index, "drawable", getPackageName());

                }

    }


    @Override
    protected void onStop() {
        super.onStop();


        SharedPreferences pref = getApplicationContext().getSharedPreferences("Page_No", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("resume",viewPager.getCurrentItem());
        editor.apply();

    }





}

