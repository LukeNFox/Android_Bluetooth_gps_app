package android.lukefox.bluetooth_gps;

import android.app.Service;

import android.content.Intent;

import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BluetoothService extends Service {


    /** Called when the service is being created. */
    @Override
    public void onCreate() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}
