package mobileservices.location.GMS;

import android.app.PendingIntent;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;

import mobileservices.location.FusedLocationProviderClient;
import mobileservices.location.LocationAvailability;
import mobileservices.task.Continuation;
import mobileservices.task.GMS.TaskGMS;
import mobileservices.task.Task;

public class FusedLocationProviderClientGMS implements FusedLocationProviderClient {

    private final com.google.android.gms.location.FusedLocationProviderClient fusedLocationProviderClient;

    public FusedLocationProviderClientGMS(@NonNull com.google.android.gms.location.FusedLocationProviderClient fusedLocationProviderClient) {
        this.fusedLocationProviderClient = fusedLocationProviderClient;
    }

    @Override
    public Task<Void> flushLocations() {
        return new TaskGMS<>(fusedLocationProviderClient.flushLocations());
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Location> getLastLocation() {
        return new TaskGMS<>(fusedLocationProviderClient.getLastLocation());
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<LocationAvailability> getLocationAvailability() {
        return new TaskGMS<>(fusedLocationProviderClient.getLocationAvailability()).continueWith(new Continuation<com.google.android.gms.location.LocationAvailability, LocationAvailability>() {
            @Override
            public LocationAvailability then(@NonNull Task<com.google.android.gms.location.LocationAvailability> task) throws Exception {
                return new LocationAvailabilityGMS(task.getResult());
            }
        });
    }

    @Override
    public Task<Void> removeLocationUpdates(PendingIntent callbackIntent) {
        return new TaskGMS<>(fusedLocationProviderClient.removeLocationUpdates(callbackIntent));
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Void> setMockLocation(Location mockLocation) {
        return new TaskGMS<>(fusedLocationProviderClient.setMockLocation(mockLocation));
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Void> setMockMode(boolean isMockMode) {
        return new TaskGMS<>(fusedLocationProviderClient.setMockMode(isMockMode));
    }
}
