package android.lukefox.bluetooth_gps;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;

import java.util.Arrays;
import java.util.HashSet;

public class ListDevicesActivity extends AppCompatActivity {

    ListView listView;
    String[] nameArray = {"Octopus","Rabbit","Rabbit","Pig","Sheep","Rabbit","Snake","Spider","Spider","Spider" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_devices);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListAdapter uniqueList = new ListAdapter(this, new HashSet<String>(Arrays.asList(nameArray)).toArray(new String[0]));
        listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(uniqueList);

    }

    public void onBackClick(View v) {
        finish();
    }
}
