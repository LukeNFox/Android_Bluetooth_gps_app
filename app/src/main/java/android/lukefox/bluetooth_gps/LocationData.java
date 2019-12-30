package android.lukefox.bluetooth_gps;

import android.bluetooth.BluetoothDevice;
import android.security.keystore.UserNotAuthenticatedException;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LocationData {

    public double latitude;
    public double longitude;
    public int numLocalDevices;  //variable to keep track of number of bluetooth devices available at each location
    public ArrayList<String> localDevices = new ArrayList<>();
    public String time;

    public LocationData(){}

    public LocationData(double latitude, double longitude, ArrayList<BluetoothDevice> allLocalDevices){
        this.latitude=latitude;
        this.longitude=longitude;
        this.time = String.valueOf(new Date().getTime());
        getUniqueDeviceCountAtLocation(allLocalDevices);

    }

    public void getUniqueDeviceCountAtLocation(ArrayList<BluetoothDevice> allLocalDevices){

        Set<String> uniqueDeviceNames = new HashSet<String>();

        for(BluetoothDevice tempdevice: allLocalDevices) {
            uniqueDeviceNames.add(tempdevice.getName());
        }

        localDevices = new ArrayList(uniqueDeviceNames);

        numLocalDevices = localDevices.size();
    }

}
