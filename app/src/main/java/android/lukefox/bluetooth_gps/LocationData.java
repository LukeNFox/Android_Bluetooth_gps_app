package android.lukefox.bluetooth_gps;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Date;

public class LocationData {

    public double latitude;
    public double longitude;
    public int numLocalDevices;  //variable to keep track of number of bluetooth devices available at each location
    //public ArrayList<Device> localDevices = new ArrayList();
    public String time;

    public LocationData(){}

    public LocationData(double latitude, double longitude, ArrayList<Device> localDevices){
        this.latitude=latitude;
        this.longitude=longitude;
        this.time = String.valueOf(new Date().getTime());
        //this.localDevices = localDevices;
        this.numLocalDevices = localDevices.size();
    }

    public int getNumLocalDevices() {
        return numLocalDevices;
    }
}
