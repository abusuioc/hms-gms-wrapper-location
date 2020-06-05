package mobileservices.location;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

public interface LocationServices {
    public FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Activity activity);

    public FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Context context);

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
