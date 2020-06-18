package mobileservices.location;

import android.content.Intent;

import androidx.annotation.NonNull;

import java.util.Objects;

/**
 * Wrapped LocationAvailability.
 * Parcelable is not implemented.
 *
 * @see com.google.android.gms.location.LocationAvailability
 * @see com.huawei.hms.location.LocationAvailability
 */
public class LocationAvailability {

    private final com.google.android.gms.location.LocationAvailability gmsLocationAvailability;
    private final com.huawei.hms.location.LocationAvailability hmsLocationAvailability;

    LocationAvailability(com.google.android.gms.location.LocationAvailability gmsLocationAvailability, com.huawei.hms.location.LocationAvailability hmsLocationAvailability) {
        this.gmsLocationAvailability = gmsLocationAvailability;
        this.hmsLocationAvailability = hmsLocationAvailability;
    }

    public static LocationAvailability extractLocationAvailability(Intent intent) {
        return new LocationAvailability(
                com.google.android.gms.location.LocationAvailability.extractLocationAvailability(intent),
                com.huawei.hms.location.LocationAvailability.extractLocationAvailability(intent)
        );
    }

    public static boolean hasLocationAvailability(Intent intent) {
        return com.google.android.gms.location.LocationAvailability.hasLocationAvailability(intent) ||
                com.huawei.hms.location.LocationAvailability.hasLocationAvailability(intent);
    }

    public boolean isLocationAvailable() {
        if (gmsLocationAvailability != null) return gmsLocationAvailability.isLocationAvailable();
        if (hmsLocationAvailability != null) return hmsLocationAvailability.isLocationAvailable();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationAvailability.");
    }

    public int getCellStatus() {
        if (hmsLocationAvailability != null) return hmsLocationAvailability.getCellStatus();
        if (gmsLocationAvailability != null) return -1;
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationAvailability.");
    }

    public int getWifiStatus() {
        if (hmsLocationAvailability != null) return hmsLocationAvailability.getWifiStatus();
        if (gmsLocationAvailability != null) return -1;
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationAvailability.");
    }

    public long getElapsedRealtimeNs() {
        if (hmsLocationAvailability != null) return hmsLocationAvailability.getElapsedRealtimeNs();
        if (gmsLocationAvailability != null) return -1;
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationAvailability.");
    }

    public int getLocationStatus() {
        if (hmsLocationAvailability != null) return hmsLocationAvailability.getLocationStatus();
        if (gmsLocationAvailability != null) return -1;
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationAvailability.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationAvailability that = (LocationAvailability) o;
        return Objects.equals(gmsLocationAvailability, that.gmsLocationAvailability) &&
                Objects.equals(hmsLocationAvailability, that.hmsLocationAvailability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gmsLocationAvailability, hmsLocationAvailability);
    }

    @NonNull
    @Override
    public String toString() {
        if (gmsLocationAvailability == null) {
            if (hmsLocationAvailability == null) {
                throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationAvailability.");
            } else {
                return hmsLocationAvailability.toString();
            }
        } else {
            return gmsLocationAvailability.toString();
        }
    }
}