package android.lukefox.bluetooth_gps;

import java.util.ArrayList;

class UniqueDevices {

    public static ArrayList<Device> devices = new ArrayList<>();

    public UniqueDevices(){}

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public static void addDevices(ArrayList devices) {
        UniqueDevices.devices.addAll(devices);
    }

}
