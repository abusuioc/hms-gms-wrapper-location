package mobileservices.location;

import androidx.annotation.NonNull;

import mobileservices.task.Continuation;
import mobileservices.task.GMS.TaskGMS;
import mobileservices.task.Task;

public class SettingsClientGMS implements SettingsClient {
    private final com.google.android.gms.location.SettingsClient settingsClient;

    SettingsClientGMS(com.google.android.gms.location.SettingsClient settingsClient) {
        this.settingsClient = settingsClient;
    }

    @Override
    public Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest request) {
        return new TaskGMS<>(settingsClient.checkLocationSettings(request.gmsLocationSettingsRequest)).continueWith(
                new Continuation<com.google.android.gms.location.LocationSettingsResponse, LocationSettingsResponse>() {

                    @Override
                    public LocationSettingsResponse then(@NonNull Task<com.google.android.gms.location.LocationSettingsResponse> task) throws Exception {
                        return new LocationSettingsResponseGMS(task.getResult());
                    }
                });
    }
}
