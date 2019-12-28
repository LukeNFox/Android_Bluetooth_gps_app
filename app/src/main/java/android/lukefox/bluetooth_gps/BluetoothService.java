package android.lukefox.bluetooth_gps;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;


public class BluetoothService extends Service {

    public BluetoothService() {


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){}

    @Override
    public void onStart(Intent intent, int startid) {}

    @Override
    public void onDestroy() {}


}
