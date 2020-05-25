package com.androidbuts.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinnerSearch;
import com.androidbuts.multispinnerfilter.SingleSpinner;
import com.androidbuts.multispinnerfilter.SingleSpinnerSearch;
import com.androidbuts.multispinnerfilter.SpinnerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    final List<Integer> listInt = Collections.emptyList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> list = Arrays.asList(getResources().getStringArray(R.array.sports_array));
        final List<Integer> list2 = Arrays.asList(R.drawable.ic_launcher,
                R.drawable.redworm,
                R.drawable.blackworm,
                R.drawable.blav,
                R.drawable.black2,
                R.drawable.kisspng,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher);


     /*   listInt.add(R.drawable.ic_launcher);
        listInt.add(R.drawable.ic_launcher);
        listInt.add(R.drawable.ic_launcher);
        listInt.add(R.drawable.ic_launcher);
        listInt.add(R.drawable.ic_launcher);
        listInt.add(R.drawable.ic_launcher);
        listInt.add(R.drawable.ic_launcher);
        listInt.add(R.drawable.ic_launcher);*/



        final List<KeyPairBoolData> listArray0 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(list.get(i));
            h.setImage(list2.get(i));
            h.setSelected(false);
            listArray0.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = findViewById(R.id.searchMultiSpinnerUnlimited);
        searchMultiSpinnerUnlimited.setEmptyTitle("Not Data Found!");
        searchMultiSpinnerUnlimited.setSearchHint("Find Data");

        searchMultiSpinnerUnlimited.setItems(listArray0, -1, new SpinnerListener() {

            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });


    }
}
