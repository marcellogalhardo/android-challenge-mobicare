package br.com.mobicare.viajabessa.utils;

public class DeviceHelper {
    private static final Device mDevice = new Device();

    public static Device getInstance() {
        return mDevice;
    }

    private DeviceHelper() {}
}