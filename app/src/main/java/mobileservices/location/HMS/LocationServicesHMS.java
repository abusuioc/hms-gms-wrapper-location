package mobileservices.location.HMS;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import mobileservices.location.FusedLocationProviderClient;
import mobileservices.location.LocationServices;

public class LocationServicesHMS implements LocationServices {

    public FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Activity activity) {
        return new FusedLocationProviderClientHMS(com.huawei.hms.location.LocationServices.getFusedLocationProviderClient(activity));
    }

    public FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Context context) {
        return new FusedLocationProviderClientHMS(com.huawei.hms.location.LocationServices.getFusedLocationProviderClient(context));
    }
}
