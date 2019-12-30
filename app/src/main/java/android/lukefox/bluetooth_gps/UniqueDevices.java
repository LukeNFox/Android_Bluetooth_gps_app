package android.lukefox.bluetooth_gps;

import android.bluetooth.BluetoothDevice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class UniqueDevices {

    public static ArrayList<BluetoothDevice> devices = new ArrayList<>();

    public static Set<String> uniqueDeviceNames = new HashSet<String>();

    public UniqueDevices(){}

    public ArrayList<BluetoothDevice> getDevices() {
        return devices;
    }

    public ArrayList<BluetoothDevice> getUniqueDevices() {

        for(BluetoothDevice tempdevice: this.getDevices()) {
            uniqueDeviceNames.add(tempdevice.getName());
        }

        ArrayList uniqueDevices = new ArrayList(uniqueDeviceNames);

        return uniqueDevices;
    }

    public void addDevice(BluetoothDevice device) {
        UniqueDevices.devices.add(device);
    }

    public void setNames(ArrayList devices){
        uniqueDeviceNames.addAll(devices);
    }


    }

