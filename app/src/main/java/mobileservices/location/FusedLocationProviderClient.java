package mobileservices.location;

import android.location.Location;

import androidx.annotation.RequiresPermission;

import mobileservices.task.Task;

public interface FusedLocationProviderClient {

    Task<Void> flushLocations();

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    Task<Location> getLastLocation();

    Task<LocationAvailability> getLocationAvailability();

    Task<Void> removeLocationUpdates(android.app.PendingIntent callbackIntent);

    //    Task<Void> removeLocationUpdates(LocationCallback callback);
//    Task<Void> requestLocationUpdates(LocationRequest request, LocationCallback callback, android.os.Looper looper);
//    Task<Void> requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent)
    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    Task<Void> setMockLocation(Location mockLocation);

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    Task<Void> setMockMode(boolean isMockMode);
}
