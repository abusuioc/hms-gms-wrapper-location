package mobileservices.location;

public class LocationSettingsResponseHMS implements LocationSettingsResponse {
    private final com.huawei.hms.location.LocationSettingsResponse locationSettingsResponse;

    public LocationSettingsResponseHMS(com.huawei.hms.location.LocationSettingsResponse locationSettingsResponse) {
        this.locationSettingsResponse = locationSettingsResponse;
    }

    @Override
    public LocationSettingsStates getLocationSettingsStates() {
        return new LocationSettingsStates(null, locationSettingsResponse.getLocationSettingsStates());
    }
}
