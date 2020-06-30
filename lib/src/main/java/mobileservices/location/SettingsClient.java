package mobileservices.location;

import mobileservices.tasks.Task;

public interface SettingsClient {
    Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest request);
}
