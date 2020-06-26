package mobileservices.location;

import mobileservices.task.Task;

public interface SettingsClient {
    Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest request);
}
