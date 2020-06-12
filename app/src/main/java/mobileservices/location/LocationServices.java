package mobileservices.location;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import mobileservices.detector.MobileServicesDetector;

public class LocationServices {
    public static FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Activity activity) {
        if (MobileServicesDetector.hasToChooseGms(activity)) {
            return new FusedLocationProviderClientGMS(com.google.android.gms.location.LocationServices.getFusedLocationProviderClient(activity));
        } else {
            return new FusedLocationProviderClientHMS(com.huawei.hms.location.LocationServices.getFusedLocationProviderClient(activity));
        }
    }

    public FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Context context) {
        if (MobileServicesDetector.hasToChooseGms(context)) {
            return new FusedLocationProviderClientGMS(com.google.android.gms.location.LocationServices.getFusedLocationProviderClient(context));
        } else {
            return new FusedLocationProviderClientHMS(com.huawei.hms.location.LocationServices.getFusedLocationProviderClient(context));
        }
    }

//    Create a new instance of  for use in a non-activity Context.
//    static GeofencingClient
//    getGeofencingClient(Activity activity)
//    Create a new instance of GeofencingClient for use in an Activity.
//    static GeofencingClient
//    getGeofencingClient(Context context)
//    Create a new instance of GeofencingClient for use in a non-activity Context.
//    static SettingsClient
//    getSettingsClient(Context context)
//    Create a new instance of SettingsClient for use in a non-activity Context.
//    static SettingsClient
//    getSettingsClient(Activity activity)
//    Create a new instance of SettingsClient for use in an Activity.
}
