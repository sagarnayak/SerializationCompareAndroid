package com.sagar.android.serilizationofdata;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int NUMBER_OF_ITERATION_FOR_LIST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "number of iteration for list is : " + NUMBER_OF_ITERATION_FOR_LIST);
        testParcelable();
        testSerilizable();
        testGson();
    }

    private void testParcelable() {
        Intent intent = new Intent();
        intent.putExtra(
                "data",
                new PersonParcelable(
                        "Sagar",
                        "india",
                        32
                )
        );
        Calendar calendar = Calendar.getInstance();
        PersonParcelable personParcelable = intent.getParcelableExtra("data");
        Log.i(TAG, "parcelable test time : " +
                (
                        Calendar.getInstance().getTimeInMillis() - calendar.getTimeInMillis()
                )
        );

        ArrayList<PersonParcelable> personList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ITERATION_FOR_LIST; i++) {
            personList.add(
                    new PersonParcelable(
                            "Sagar",
                            "india",
                            32
                    )
            );
        }
        Intent intentTwo = new Intent();
        intentTwo.putExtra(
                "data",
                personList
        );
        Calendar calendarTwo = Calendar.getInstance();
        ArrayList<PersonParcelable> personListResult = intentTwo.getParcelableArrayListExtra("data");
        Log.i(TAG, "parcelable list test time : " +
                (
                        Calendar.getInstance().getTimeInMillis() - calendarTwo.getTimeInMillis()
                )
        );
    }

    private void testSerilizable() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(
                "data",
                new PersonSerilizable(
                        "Sagar",
                        "india",
                        32
                )
        );
        intent.putExtras(bundle);
        Calendar calendar = Calendar.getInstance();
        PersonSerilizable personSerilizable = (PersonSerilizable) intent.getSerializableExtra("data");
        Log.i(TAG, "Serilizable test time : " +
                (
                        Calendar.getInstance().getTimeInMillis() - calendar.getTimeInMillis()
                )
        );

        ArrayList<PersonSerilizable> personSerilizables = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ITERATION_FOR_LIST; i++) {
            personSerilizables.add(
                    new PersonSerilizable(
                            "Sagar",
                            "india",
                            32
                    )
            );
        }
        Intent intentTwo = new Intent();
        Bundle bundleTwo = new Bundle();
        bundleTwo.putSerializable(
                "data",
                personSerilizables
        );
        intentTwo.putExtras(bundleTwo);
        Calendar calendarTwo = Calendar.getInstance();
        ArrayList<PersonSerilizable> personSerilizablesResult = (ArrayList<PersonSerilizable>) intentTwo.getSerializableExtra("data");
        Log.i(TAG, "serializable list test time : " +
                (
                        Calendar.getInstance().getTimeInMillis() - calendarTwo.getTimeInMillis()
                )
        );
    }

    private void testGson() {
        Intent intent = new Intent();
        intent.putExtra(
                "data",
                new Gson().toJson(
                        new Person(
                                "Sagar",
                                "india",
                                32
                        )
                )
        );
        Calendar calendar = Calendar.getInstance();
        Person person = new Gson().fromJson(
                intent.getStringExtra("data"),
                Person.class
        );
        Log.i(TAG, "Gson test time : " +
                (
                        Calendar.getInstance().getTimeInMillis() - calendar.getTimeInMillis()
                )
        );

        ArrayList<Person> personArrayList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ITERATION_FOR_LIST; i++) {
            personArrayList.add(
                    new Person(
                            "Sagar",
                            "india",
                            32
                    )
            );
        }
        Intent intentTwo = new Intent();
        intentTwo.putExtra(
                "data",
                new Gson()
                        .toJson(
                                personArrayList
                        )
        );
        Calendar calendarTwo = Calendar.getInstance();
        ArrayList<Person> personArrayListResult = new Gson().fromJson(
                intentTwo.getStringExtra("data"),
                new TypeToken<ArrayList<Person>>() {
                }.getType()
        );
        Log.i(TAG, "Gson list test time : " +
                (
                        Calendar.getInstance().getTimeInMillis() - calendarTwo.getTimeInMillis()
                )
        );
    }
}
