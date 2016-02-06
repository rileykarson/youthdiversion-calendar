package com.youthdiversion.calendar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    public final String FIRSTNAME = "firstnamekey";
    public final String LASTNAME = "lastnamekey";
    public final String EMAIL = "emailkey";
    public final String ID = "idkey";
    public final String PHONE = "phonekey";
    public final String PASSWORD = "passwordkey";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    DatabaseHandler db;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //fragment shit
        fragmentManager = getFragmentManager();
        CalendarView calendarView=(CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                startNextFragment();

            }
        });
        //-------------end fragment shit


        db = new DatabaseHandler(getApplicationContext());

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String name = sharedpreferences.getString(FIRSTNAME, "");
        if (name == "") {
            Intent intent = new Intent(this, CreateAccount.class);
            startActivity(intent);
            finish();
        }

        
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.remove(FIRSTNAME);
                editor.remove(LASTNAME);
                editor.remove(EMAIL);
                editor.remove(ID);
                editor.remove(PHONE);
                editor.remove(PASSWORD);
                editor.commit();
            }
        });
    }

    public static String format(GregorianCalendar calendar){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fmt.setCalendar(calendar);
        String dateFormatted = fmt.format(calendar.getTime());
        return dateFormatted;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startNextFragment()
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AddInfo_Fragment addInfo_fragment = new AddInfo_Fragment();
        fragmentTransaction.replace(R.id.calendarView, addInfo_fragment, "addinfo");
    }

}
