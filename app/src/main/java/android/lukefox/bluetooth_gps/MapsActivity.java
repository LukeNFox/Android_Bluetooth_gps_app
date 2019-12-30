package android.lukefox.bluetooth_gps;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap; // Google Map object resposible for the map display
    private Marker markerLocation; //Marker object to be used in the map
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("locationInfo");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        startGettingLocations();
    }

    public void onBackClick(View v) {
        finish();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                LocationData location = dataSnapshot.getValue(LocationData.class);
                LatLng latLng = new LatLng(location.latitude, location.longitude);
                mMap.addMarker(new MarkerOptions().position(latLng).title(Integer.toString(location.numLocalDevices)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latLng.latitude, latLng.longitude))
                .zoom(10)
                .build();

                if (mMap != null)
                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });


    }

    public void onLocationChanged(Location location) {
//        LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
//
//        LocationData locationData = new LocationData(latLng.latitude, latLng.longitude);
//        String key =  locationData.time;
//        myRef.child(key).setValue(locationData);
//        addMarker(latLng,locationData);
    }

//    private void addMarker(LatLng latLng, LocationData locationData) {
//        if (latLng == null) {
//            return;
//        }
//        if (markerLocation != null) {
//            markerLocation.remove();
//        }
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(latLng);
//        markerOptions.title(Integer.toString(locationData.numLocalDevices));
//        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
//        if (mMap != null)
//            markerLocation = mMap.addMarker(markerOptions);
//
//
//        CameraPosition cameraPosition = new CameraPosition.Builder()
//                .target(new LatLng(latLng.latitude, latLng.longitude))
//                .zoom(1)
//                .build();
//
//        if (mMap != null)
//            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//    }


    private void startGettingLocations() {
//
//        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        boolean isGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
//        boolean isNetwork = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//        boolean canGetLocation = true;
//        long MIN_DISTANCE_CHANGE_FOR_UPDATES = 5;// Distance in meters
//        long MIN_TIME_BW_UPDATES = 1000 * 60 * 15;// Time in milliseconds
//
//
//        if (ActivityCompat.checkSelfPermission(this,
//                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
//                        != PackageManager.PERMISSION_GRANTED) {
//
//            Toast.makeText(this, "Permission not Granted", Toast.LENGTH_SHORT).show();
//
//
//            return;
//        }
//
//        //Starts requesting location updates
//        if (canGetLocation) {
//            if (isGPS) {
//                lm.requestLocationUpdates(
//                        LocationManager.GPS_PROVIDER,
//                        MIN_TIME_BW_UPDATES,
//                        MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
//            } else if (isNetwork) {
//                // from Network Provider
//
//                lm.requestLocationUpdates(
//                        LocationManager.NETWORK_PROVIDER,
//                        MIN_TIME_BW_UPDATES,
//                        MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
//            }
//        } else {
//            Toast.makeText(this, "Can't get location", Toast.LENGTH_SHORT).show();
//        }
   }


}

