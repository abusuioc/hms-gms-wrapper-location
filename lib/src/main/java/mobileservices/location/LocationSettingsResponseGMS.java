package mobileservices.location;

public class LocationSettingsResponseGMS implements LocationSettingsResponse {
    private final com.google.android.gms.location.LocationSettingsResponse locationSettingsResponse;

    public LocationSettingsResponseGMS(com.google.android.gms.location.LocationSettingsResponse locationSettingsResponse) {
        this.locationSettingsResponse = locationSettingsResponse;
    }

    @Override
    public LocationSettingsStates getLocationSettingsStates() {
        return new LocationSettingsStates(locationSettingsResponse.getLocationSettingsStates(), null);
    }
}