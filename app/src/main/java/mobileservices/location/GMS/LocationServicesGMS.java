package mobileservices.location.GMS;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import mobileservices.location.FusedLocationProviderClient;
import mobileservices.location.LocationServices;

public class LocationServicesGMS implements LocationServices {

    public FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Activity activity) {
        return new FusedLocationProviderClientGMS(com.google.android.gms.location.LocationServices.getFusedLocationProviderClient(activity));
    }

    public FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Context context) {
        return new FusedLocationProviderClientGMS(com.google.android.gms.location.LocationServices.getFusedLocationProviderClient(context));
    }
}
