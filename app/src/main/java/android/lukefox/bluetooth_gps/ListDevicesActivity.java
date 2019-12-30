package android.lukefox.bluetooth_gps;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;


import java.util.ArrayList;


public class ListDevicesActivity extends AppCompatActivity {

    ListView listView;
    ArrayList deviceArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_devices);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        UniqueDevices x = new UniqueDevices();
        deviceArray = x.getUniqueDevices();

        String[] deviceSet = new String[deviceArray.size()];

        for(int i = 0; i < deviceArray.size(); i++){
            deviceSet[i] = (String) deviceArray.get(i);
        }

        ListAdapter uniqueList = new ListAdapter(this, deviceSet);
        listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(uniqueList);

    }

    public void onBackClick(View v) {
        finish();
    }


}
