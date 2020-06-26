package mobileservices.location;

import androidx.annotation.NonNull;

import mobileservices.task.Continuation;
import mobileservices.task.HMS.TaskHMS;
import mobileservices.task.Task;

public class SettingsClientHMS implements SettingsClient {
    private final com.huawei.hms.location.SettingsClient settingsClient;

    SettingsClientHMS(com.huawei.hms.location.SettingsClient settingsClient) {
        this.settingsClient = settingsClient;
    }

    @Override
    public Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest request) {
        return new TaskHMS<>(settingsClient.checkLocationSettings(request.hmsLocationSettingsRequest)).continueWith(
                new Continuation<com.huawei.hms.location.LocationSettingsResponse, LocationSettingsResponse>() {

                    @Override
                    public LocationSettingsResponse then(@NonNull Task<com.huawei.hms.location.LocationSettingsResponse> task) throws Exception {
                        return new LocationSettingsResponseHMS(task.getResult());
                    }
                });
    }
}
