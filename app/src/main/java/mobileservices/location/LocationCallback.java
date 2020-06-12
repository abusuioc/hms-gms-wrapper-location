package mobileservices.location;

public interface LocationCallback {

    void onLocationAvailability(LocationAvailability locationAvailability);

    void onLocationResult(LocationResult result);
}
