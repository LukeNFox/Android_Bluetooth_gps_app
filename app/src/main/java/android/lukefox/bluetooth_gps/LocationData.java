package android.lukefox.bluetooth_gps;

import java.util.ArrayList;
import java.util.Date;

public class LocationData {

    public double latitude;
    public double longitude;
    public int numLocalDevices;  //variable to keep track of number of bluetooth devices available at each location
    public ArrayList localDevices;
    public String time;

    public LocationData(){}

    public LocationData(double latitude, double longitude){
        this.latitude=latitude;
        this.longitude=longitude;
        this.time = String.valueOf(new Date().getTime());
        this.numLocalDevices = localDevices.size();
    }

    public void getLocalDevices(){
        //localDevices.add()
    } // method to count number of devices at a location
}
