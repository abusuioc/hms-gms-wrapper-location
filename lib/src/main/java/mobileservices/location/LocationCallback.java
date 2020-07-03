package mobileservices.location;

public class LocationCallback {

    com.google.android.gms.location.LocationCallback gmsLocationCallback;
    com.huawei.hms.location.LocationCallback hmsLocationCallback;

    public LocationCallback() {
    }

    @SuppressWarnings("EmptyMethod")
    public void onLocationAvailability(LocationAvailability locationAvailability) {
    }

    @SuppressWarnings("EmptyMethod")
    public void onLocationResult(LocationResult result) {
    }
}
