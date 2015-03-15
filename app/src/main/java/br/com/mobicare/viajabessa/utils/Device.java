package br.com.mobicare.viajabessa.utils;

import android.os.Build;

public class Device {
    private static final String mModel = Build.MODEL;
    private static final String mManufacturer = Build.MANUFACTURER;
    private static final String mVersion = Build.VERSION.RELEASE;

    public String getVersion() {
        return mVersion;
    }

    public String getModel() {
        return mModel;
    }

    public String getManufacturer() {
        return mManufacturer;
    }

    public String toString() {
        return "/" + getVersion() + "/" + getModel() + "/" + getManufacturer();
    }
}
