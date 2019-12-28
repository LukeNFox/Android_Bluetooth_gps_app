package android.lukefox.bluetooth_gps;

import java.util.ArrayList;
import java.util.Date;

public class LocationData {

    public double latitude;
    public double longitude;
    public int numLocalDevices;  //variable to keep track of number of bluetooth devices available at each location
    public ArrayList<Device> localDevices = new ArrayList();
    public String time;

    public LocationData(){}

    public LocationData(double latitude, double longitude){
        this.latitude=latitude;
        this.longitude=longitude;
        this.time = String.valueOf(new Date().getTime());
        this.numLocalDevices = localDevices.size();
        addLocalDevices(new Device("Luke"));
        addLocalDevices(new Device("Sam"));
    }

    // add device to the list of devices for this location
    public void addLocalDevices(Device device){
        localDevices.add(device);
        this.numLocalDevices = localDevices.size();
    }
}
