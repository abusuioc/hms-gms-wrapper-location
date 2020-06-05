package mobileservices.location.HMS;

import android.app.PendingIntent;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;

import mobileservices.location.FusedLocationProviderClient;
import mobileservices.location.LocationAvailability;
import mobileservices.task.Continuation;
import mobileservices.task.HMS.TaskHMS;
import mobileservices.task.Task;

public class FusedLocationProviderClientHMS implements FusedLocationProviderClient {

    private final com.huawei.hms.location.FusedLocationProviderClient fusedLocationProviderClient;

    public FusedLocationProviderClientHMS(@NonNull com.huawei.hms.location.FusedLocationProviderClient fusedLocationProviderClient) {
        this.fusedLocationProviderClient = fusedLocationProviderClient;
    }

    @Override
    public Task<Void> flushLocations() {
        return new TaskHMS<>(fusedLocationProviderClient.flushLocations());
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Location> getLastLocation() {
        return new TaskHMS<>(fusedLocationProviderClient.getLastLocation());
    }

    @Override
    public Task<LocationAvailability> getLocationAvailability() {
        return new TaskHMS<>(fusedLocationProviderClient.getLocationAvailability()).continueWith(new Continuation<com.huawei.hms.location.LocationAvailability, LocationAvailability>() {
            @Override
            public LocationAvailability then(@NonNull Task<com.huawei.hms.location.LocationAvailability> task) throws Exception {
                return new LocationAvailabilityHMS(task.getResult());
            }
        });
    }

    @Override
    public Task<Void> removeLocationUpdates(PendingIntent callbackIntent) {
        return new TaskHMS<>(fusedLocationProviderClient.removeLocationUpdates(callbackIntent));
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Void> setMockLocation(Location mockLocation) {
        return new TaskHMS<>(fusedLocationProviderClient.setMockLocation(mockLocation));
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Void> setMockMode(boolean isMockMode) {
        return new TaskHMS<>(fusedLocationProviderClient.setMockMode(isMockMode));
    }
}
