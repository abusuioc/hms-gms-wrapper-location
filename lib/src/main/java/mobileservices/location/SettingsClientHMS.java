package mobileservices.location;

import mobileservices.tasks.HMS.TaskHMS;
import mobileservices.tasks.Task;

public class SettingsClientHMS implements SettingsClient {
    private final com.huawei.hms.location.SettingsClient settingsClient;

    SettingsClientHMS(com.huawei.hms.location.SettingsClient settingsClient) {
        this.settingsClient = settingsClient;
    }

    @Override
    public Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest request) {
        return new TaskHMS<>(settingsClient.checkLocationSettings(request.hmsLocationSettingsRequest)).continueWith(
                new ContinuationWithConversion<com.huawei.hms.location.LocationSettingsResponse, LocationSettingsResponse>() {

                    @Override
                    public LocationSettingsResponse convertResult(com.huawei.hms.location.LocationSettingsResponse locationSettingsResponse) {
                        return new LocationSettingsResponseHMS(locationSettingsResponse);
                    }
                });
    }
}
