package mobileservices.location;

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
                new ContinuationWithConversion<com.google.android.gms.location.LocationSettingsResponse, LocationSettingsResponse>() {

                    @Override
                    public LocationSettingsResponse convertResult(com.google.android.gms.location.LocationSettingsResponse locationSettingsResponse) {
                        return new LocationSettingsResponseGMS(locationSettingsResponse);
                    }
                });
    }
}
