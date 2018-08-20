package com.cadhut.islamic.Quran16Line;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

public class SuraContents extends AppCompatActivity {
    //LinearLayout surahscrllLayout;
    // Array of strings...
    private String[] engArray;
    private String[] arbArray;
    private String[] srNumArray;
    ListView suraList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.cadhut.islamic.Quran16Line.R.layout.activity_sura_contents);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(com.cadhut.islamic.Quran16Line.R.id.sura_toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Surah Index");
        toolbar.setNavigationIcon(com.cadhut.islamic.Quran16Line.R.drawable.ic_chevron_left_black_24dp);

        //surahscrllLayout = (LinearLayout)findViewById(R.id.suraScrlLayout);

///////////////////////////////////////////////////////////////////////////
        engArray = new String[114];
        arbArray = new String[114];
        srNumArray= new String[114];
        int page_no;

        for(int index=0; index<114; index++){
            page_no=index+1;

            engArray[index]= getStringResourceByName("sura"+page_no);
            arbArray[index]= getStringResourceByName("sura"+page_no+"_a");
            srNumArray[index] = "sura"+page_no;

        }

        suraList =(ListView)findViewById(com.cadhut.islamic.Quran16Line.R.id.suraListView);
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, engArray, arbArray,srNumArray);
        suraList.setAdapter(adapter);

/////////////////////////////////////////////////////////////////////



    }

    private String getStringResourceByName(String aString) {
        int resId = getResources().getIdentifier(aString, "string", getApplicationContext().getPackageName());
        return getString(resId);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);



    }

}
