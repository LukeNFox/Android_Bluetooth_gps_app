package android.lukefox.bluetooth_gps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class UniqueDevices {

    public static ArrayList<Device> devices = new ArrayList<>();

    public UniqueDevices(){}

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public ArrayList<Device> getUniqueDevices() {

        Set<String> uniqueDeviceNames = new HashSet<String>();

        for(Device tempdevice: this.getDevices()) {
            uniqueDeviceNames.add(tempdevice.getName());
        }

        ArrayList uniqueDevices = new ArrayList(uniqueDeviceNames);

        return uniqueDevices;
    }

    public void addDevice(Device device) {
            UniqueDevices.devices.add(device);
        }


    }

