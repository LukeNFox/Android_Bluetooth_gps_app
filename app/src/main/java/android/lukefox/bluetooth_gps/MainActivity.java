package android.lukefox.bluetooth_gps;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public final int REQUEST_ENABLE_BT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// activity_main is corresponding XML file

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null ) {
            if (!bluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                Toast.makeText(this, "Bluetooth Connected", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(this, "Bluetooth Unavailable on this device", Toast.LENGTH_SHORT).show();
        }
    }

    public void onMapClick(View v) {

        Intent intent = new Intent(getBaseContext(),
                MapsActivity.class);
        startActivity(intent); // startActivity allow you to move
    }

    public void onDeviceClick(View v) {

        Intent intent = new Intent(getBaseContext(),
                ListDevicesActivity.class);
        startActivity(intent); // startActivity allow you to move
    }
}


