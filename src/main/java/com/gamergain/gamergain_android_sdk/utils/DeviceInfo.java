package com.gamergain.gamergain_android_sdk.utils;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;

public class DeviceInfo {
    Context ctx;

    boolean isLAT = false;
    String gaid = "";

    public DeviceInfo(Context ctx) {
        this.ctx = ctx;
    }

    public String getPhoneID() {
        return ((TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    public String getAndroidID() {
        return Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.ANDROID_ID);

    }

    public String osVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    public String deviceType() {
        return android.os.Build.MODEL;
    }

    public void getIdThread() {

        AdvertisingIdClient.Info adInfo = null;
        try {
            adInfo = AdvertisingIdClient.getAdvertisingIdInfo(ctx);

        } catch (IOException e) {

        } catch (GooglePlayServicesNotAvailableException e) {
            // Google Play services is not available entirely.
        } catch (GooglePlayServicesRepairableException e) {

        }
        gaid = adInfo.getId();
        isLAT = adInfo.isLimitAdTrackingEnabled();
    }
}
