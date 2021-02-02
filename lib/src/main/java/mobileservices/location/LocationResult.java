package mobileservices.location;

import android.content.Intent;
import android.location.Location;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Wrapped LocationResult.
 * Parcelable is not implemented.
 */
public class LocationResult {

    final com.google.android.gms.location.LocationResult gmsLocationResult;
    final com.huawei.hms.location.LocationResult hmsLocationResult;

    // Building a LocationResult from List<HWLocation> is not supported.
    public static LocationResult create(List<Location> locations) {
        return new LocationResult(com.google.android.gms.location.LocationResult.create(locations), null);
    }

    LocationResult(com.google.android.gms.location.LocationResult gmsLocationResult,
                   com.huawei.hms.location.LocationResult hmsLocationResult) {
        this.gmsLocationResult = gmsLocationResult;
        this.hmsLocationResult = hmsLocationResult;
    }

    private LocationResult(Intent intent) {
        gmsLocationResult = com.google.android.gms.location.LocationResult.extractResult(intent);
        hmsLocationResult = com.huawei.hms.location.LocationResult.extractResult(intent);
    }

    public static LocationResult extractResult(Intent intent) {
        return new LocationResult(intent);
    }

    public Location getLastLocation() {
        if (gmsLocationResult != null) return gmsLocationResult.getLastLocation();
        if (hmsLocationResult != null) return hmsLocationResult.getLastLocation();
        return null;
    }

    public List<Location> getLocations() {
        if (gmsLocationResult != null) return gmsLocationResult.getLocations();
        if (hmsLocationResult != null) return hmsLocationResult.getLocations();
        return null;
    }

    public static boolean hasResult(Intent intent) {
        return com.google.android.gms.location.LocationResult.hasResult(intent) || com.huawei.hms.location.LocationResult.hasResult(intent);
    }

    @Override
    @NonNull
    public String toString() {
        if (gmsLocationResult == null) {
            return hmsLocationResult.toString();
        } else if (hmsLocationResult == null) {
            return gmsLocationResult.toString();
        } else {
            return String.format("GMS: %s \nHMS: %s", gmsLocationResult.toString(), hmsLocationResult.toString());
        }
    }
}