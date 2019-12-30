package android.lukefox.bluetooth_gps;

import android.app.IntentService;
import android.app.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BluetoothService extends IntentService {

    public static int SERVICE_ID = 1;
    private LocationManager lm = null;
    long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0;// Distance in meters
    long MIN_TIME_BW_UPDATES = 1000;// Time in milliseconds
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("locationInfo");
    DatabaseReference unique = database.getReference("devices");
    LocationListener mLocationListener = new LocationListener(LocationManager.PASSIVE_PROVIDER);


    public BluetoothService() {
        super("BluetoothService");
    }


    /** Called when the service is being created. */
    @Override
    public void onCreate() {
        getLocations();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        getLocations();
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (lm != null) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            lm.removeUpdates(mLocationListener);
            }
        }

    public ArrayList<Device> getLocalDevices(){
        ArrayList localDevices = new ArrayList<Device>();
        localDevices.add(new Device("Brian"));
        localDevices.add(new Device("Jim"));
        localDevices.add(new Device("Luke"));
        localDevices.add(new Device("John"));
        return localDevices;
    }


    private class LocationListener implements android.location.LocationListener {
        Location mLastLocation;

        public LocationListener(String provider) {
            mLastLocation = new Location(provider);
        }

        @Override
        public void onLocationChanged(Location location){
            LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());

            LocationData locationData = new LocationData(latLng.latitude, latLng.longitude, getLocalDevices());
            String key =  locationData.time;
            myRef.child(key).setValue(locationData);

            UniqueDevices devices = new UniqueDevices();
            for(Device i: getLocalDevices()) {
                devices.addDevice(i);
            }
            unique.setValue(devices.getUniqueDevices());
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
    }

    public void getLocations(){
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean isGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetwork = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        boolean canGetLocation = true;


        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "Permission not Granted", Toast.LENGTH_SHORT).show();


            return;
        }

        //Starts requesting location updates
        if (canGetLocation) {
            if (isGPS) {
                lm.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES,
                        MIN_TIME_BW_UPDATES, mLocationListener);
            } else if (isNetwork) {
                // from Network Provider

                lm.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES,
                        MIN_TIME_BW_UPDATES, mLocationListener);
            }
        } else {
            Toast.makeText(this, "Can't get location", Toast.LENGTH_SHORT).show();
        }
    }



}


