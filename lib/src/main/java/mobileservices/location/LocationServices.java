package mobileservices.location;

import android.app.Activity;
import android.content.Context;

import android.support.annotation.NonNull;

import mobileservices.detector.MobileServicesDetector;

public class LocationServices {

    /**
     * Choose GMS first, then HMS, but if none is available then rollback to GMS as this is anyway the default implementation for most apps.
     */
    private static boolean hasToChooseGms(Context context) {
        if (MobileServicesDetector.isGmsAvailable(context)) return true;
        return !MobileServicesDetector.isHmsAvailable(context);
    }

    /**
     * @see com.google.android.gms.location.LocationServices#getFusedLocationProviderClient(android.app.Activity)
     * @see com.huawei.hms.location.LocationServices#getFusedLocationProviderClient(android.app.Activity)
     */
    public static FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Activity activity) {
        if (hasToChooseGms(activity)) {
            return new FusedLocationProviderClientGMS(com.google.android.gms.location.LocationServices.getFusedLocationProviderClient(activity));
        } else {
            return new FusedLocationProviderClientHMS(com.huawei.hms.location.LocationServices.getFusedLocationProviderClient(activity));
        }
    }

    /**
     * @see com.google.android.gms.location.LocationServices#getFusedLocationProviderClient(android.content.Context)
     * @see com.huawei.hms.location.LocationServices#getFusedLocationProviderClient(android.content.Context)
     */
    public static FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Context context) {
        if (hasToChooseGms(context)) {
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

    /**
     * @see com.google.android.gms.location.LocationServices#getSettingsClient(android.app.Activity)
     * @see com.huawei.hms.location.LocationServices#getSettingsClient(android.app.Activity)
     */
    public static SettingsClient getSettingsClient(Context context) {
        if (hasToChooseGms(context)) {
            return new SettingsClientGMS(com.google.android.gms.location.LocationServices.getSettingsClient(context));
        } else {
            return new SettingsClientHMS((com.huawei.hms.location.LocationServices.getSettingsClient(context)));
        }
    }

    /**
     * @see com.google.android.gms.location.LocationServices#getSettingsClient(android.app.Activity)
     * @see com.huawei.hms.location.LocationServices#getSettingsClient(android.app.Activity)
     */
    public static SettingsClient getSettingsClient(Activity activity) {
        if (hasToChooseGms(activity)) {
            return new SettingsClientGMS(com.google.android.gms.location.LocationServices.getSettingsClient(activity));
        } else {
            return new SettingsClientHMS((com.huawei.hms.location.LocationServices.getSettingsClient(activity)));
        }
    }
}
