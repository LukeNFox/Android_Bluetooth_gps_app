package android.lukefox.bluetooth_gps;

import java.util.Date;

public class LocationData {

    public double latitude;
    public double longitude;
    public int localBluetooth;  //variable to keep track og number of bluetooth devices available at each location
    public String time;

    public LocationData(){}

    public LocationData(double latitude, double longitude){
        this.latitude=latitude;
        this.longitude=longitude;
        this.time = String.valueOf(new Date().getTime());
    }

    public void getBluetoothDevices(){} // method to count number of devices at a location
}
