package mobileservices.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;

import mobileservices.tasks.Continuation;
import mobileservices.tasks.GMS.TaskGMS;
import mobileservices.tasks.Task;

public class FusedLocationProviderClientGMS implements FusedLocationProviderClient {

    private final com.google.android.gms.location.FusedLocationProviderClient fusedLocationProviderClient;

    public FusedLocationProviderClientGMS(@NonNull com.google.android.gms.location.FusedLocationProviderClient fusedLocationProviderClient) {
        this.fusedLocationProviderClient = fusedLocationProviderClient;
    }

    @Override
    public Task<Void> flushLocations() {
        return new TaskGMS<>(fusedLocationProviderClient.flushLocations()).continueWith(new ContinuationIdentity<Void>());
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Location> getLastLocation() {
        return new TaskGMS<>(fusedLocationProviderClient.getLastLocation()).continueWith(new ContinuationIdentity<Location>());
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<LocationAvailability> getLocationAvailability() {
        return new TaskGMS<>(fusedLocationProviderClient.getLocationAvailability()).continueWith(new Continuation<com.google.android.gms.location.LocationAvailability, LocationAvailability>() {
            @Override
            public LocationAvailability then(@NonNull Task<com.google.android.gms.location.LocationAvailability> task) throws Exception {
                return new LocationAvailability(task.getResult(), null);
            }
        }).continueWith(new ContinuationIdentity<LocationAvailability>());
    }

    @Override
    public Task<Void> removeLocationUpdates(PendingIntent callbackIntent) {
        return new TaskGMS<>(fusedLocationProviderClient.removeLocationUpdates(callbackIntent))
                .continueWith(new ContinuationIdentity<Void>());
    }

    @Override
    public Task<Void> removeLocationUpdates(final LocationCallback callback) {
        if (callback == null || callback.gmsLocationCallback == null) {
            com.google.android.gms.tasks.TaskCompletionSource<Void> taskCompletionSource = new com.google.android.gms.tasks.TaskCompletionSource<>();
            taskCompletionSource.setResult(null);
            return new TaskGMS<>(taskCompletionSource.getTask());
        }
        return new TaskGMS<>(
                fusedLocationProviderClient.removeLocationUpdates(callback.gmsLocationCallback)
        ).continueWith(new ContinuationIdentity<Void>());
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Void> requestLocationUpdates(LocationRequest request, final LocationCallback callback, Looper looper) {
        com.google.android.gms.location.LocationCallback gmsLocationCallback = new com.google.android.gms.location.LocationCallback() {
            @Override
            public void onLocationAvailability(com.google.android.gms.location.LocationAvailability locationAvailability) {
                callback.onLocationAvailability(new LocationAvailability(locationAvailability, null));
            }

            @Override
            public void onLocationResult(com.google.android.gms.location.LocationResult locationResult) {
                callback.onLocationResult(new LocationResult(locationResult, null));
            }
        };

        callback.gmsLocationCallback = gmsLocationCallback;

        return new TaskGMS<>(
                fusedLocationProviderClient.requestLocationUpdates(
                        request.gmsLocationRequest,
                        gmsLocationCallback,
                        looper
                )
        ).continueWith(new ContinuationIdentity<Void>());
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Void> requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        return new TaskGMS<>(
                fusedLocationProviderClient.requestLocationUpdates(
                        request.gmsLocationRequest,
                        callbackIntent
                )
        ).continueWith(new ContinuationIdentity<Void>());
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Void> setMockLocation(Location mockLocation) {
        return new TaskGMS<>(fusedLocationProviderClient.setMockLocation(mockLocation)).continueWith(new ContinuationIdentity<Void>());
    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}
    )
    @Override
    public Task<Void> setMockMode(boolean isMockMode) {
        return new TaskGMS<>(fusedLocationProviderClient.setMockMode(isMockMode)).continueWith(new ContinuationIdentity<Void>());
    }
}
