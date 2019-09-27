package android.lukefox.bluetooth_gps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button mapButton; //
    private Button devicesButton; //


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// activity_main is corresponding XML file

    }

    public void onMapClick(View v) {

        Intent intent = new Intent(getBaseContext(),
                MapsActivity.class);
        startActivity(intent); // startActivity allow you to move
    }

    public void onDeviceClick(View v) {

        Intent intent = new Intent(getBaseContext(),
                MapsActivity.class);
        startActivity(intent); // startActivity allow you to move
    }
}


