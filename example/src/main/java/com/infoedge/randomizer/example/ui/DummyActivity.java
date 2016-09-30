package com.infoedge.randomizer.example.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.infoedge.android.arandomizer.DroidGenerator;
import com.infoedge.jrandomizer.Generator;
import com.infoedge.randomizer.example.model.Person;

import java.util.List;

/**
 * Created by gagandeep on 12/8/16.
 */

public class DummyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DroidGenerator<Person> generator = new DroidGenerator<>(Person.class);
        List<Person> persons = generator.generate(5);

        for (Person person : persons) {
            Log.e("DUMMY", person.toString());
        }
    }
}
