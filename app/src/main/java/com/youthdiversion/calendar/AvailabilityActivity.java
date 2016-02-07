package com.youthdiversion.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AvailabilityActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability);

        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this.getApplicationContext());
        rv.setLayoutManager(llm);
        List<Availability> times = new ArrayList<Availability>();
        times.add(new Availability(1,2,"Available From:","2:30pm to 4:30pm","4"));
        times.add(new Availability(1,2,"Available From:","9:00am to 12:00pm","4"));
        times.add(new Availability(1,2,"Available From:","10:00am to 2:00pm","4"));
        RVAdapter adapter = new RVAdapter(times);
        rv.setAdapter(adapter);
    }
}
