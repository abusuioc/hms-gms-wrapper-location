package mobileservices.location;

import androidx.annotation.NonNull;

import java.util.Objects;

/**
 * Wrapped LocationRequest.
 * Parcelable is not implemented.
 */
public class LocationRequest {

    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    public static final int PRIORITY_HD_ACCURACY = 200;

    final com.google.android.gms.location.LocationRequest gmsLocationRequest;
    final com.huawei.hms.location.LocationRequest hmsLocationRequest;

    public static LocationRequest create() {
        return new LocationRequest();
    }

    public LocationRequest() {
        gmsLocationRequest = new com.google.android.gms.location.LocationRequest();
        hmsLocationRequest = new com.huawei.hms.location.LocationRequest();
    }

    LocationRequest(com.google.android.gms.location.LocationRequest gmsLocationRequest, com.huawei.hms.location.LocationRequest hmsLocationRequest) {
        this.gmsLocationRequest = gmsLocationRequest;
        this.hmsLocationRequest = hmsLocationRequest;
    }

    public LocationRequest setExpirationDuration(long millis) {
        if (gmsLocationRequest != null) gmsLocationRequest.setExpirationDuration(millis);
        if (hmsLocationRequest != null) hmsLocationRequest.setExpirationDuration(millis);
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        if (gmsLocationRequest != null) gmsLocationRequest.setExpirationTime(millis);
        if (hmsLocationRequest != null) hmsLocationRequest.setExpirationTime(millis);
        return this;
    }

    public long getExpirationTime() {
        if (gmsLocationRequest != null) return gmsLocationRequest.getExpirationTime();
        if (hmsLocationRequest != null) return hmsLocationRequest.getExpirationTime();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationRequest.");
    }

    public LocationRequest setFastestInterval(long millis) {
        if (gmsLocationRequest != null) gmsLocationRequest.setFastestInterval(millis);
        if (hmsLocationRequest != null) hmsLocationRequest.setFastestInterval(millis);
        return this;
    }

    public long getFastestInterval() {
        if (gmsLocationRequest != null) return gmsLocationRequest.getFastestInterval();
        if (hmsLocationRequest != null) return hmsLocationRequest.getFastestInterval();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationRequest.");
    }

    public LocationRequest setInterval(long millis) {
        if (gmsLocationRequest != null) gmsLocationRequest.setInterval(millis);
        if (hmsLocationRequest != null) hmsLocationRequest.setInterval(millis);
        return this;
    }

    public long getInterval() {
        if (gmsLocationRequest != null) return gmsLocationRequest.getInterval();
        if (hmsLocationRequest != null) return hmsLocationRequest.getInterval();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationRequest.");
    }

    public LocationRequest setMaxWaitTime(long millis) {
        if (gmsLocationRequest != null) gmsLocationRequest.setMaxWaitTime(millis);
        if (hmsLocationRequest != null) hmsLocationRequest.setMaxWaitTime(millis);
        return this;
    }

    public long getMaxWaitTime() {
        if (gmsLocationRequest != null) return gmsLocationRequest.getMaxWaitTime();
        if (hmsLocationRequest != null) return hmsLocationRequest.getMaxWaitTime();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationRequest.");
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (gmsLocationRequest != null) gmsLocationRequest.setNumUpdates(numUpdates);
        if (hmsLocationRequest != null) hmsLocationRequest.setNumUpdates(numUpdates);
        return this;
    }

    public int getNumUpdates() {
        if (gmsLocationRequest != null) return gmsLocationRequest.getNumUpdates();
        if (hmsLocationRequest != null) return hmsLocationRequest.getNumUpdates();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationRequest.");
    }

    public LocationRequest setPriority(int priority) {
        switch (priority) {
            case PRIORITY_HIGH_ACCURACY:
                if (gmsLocationRequest != null)
                    gmsLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY);
                if (hmsLocationRequest != null)
                    hmsLocationRequest.setPriority(com.huawei.hms.location.LocationRequest.PRIORITY_HIGH_ACCURACY);
                break;
            case PRIORITY_BALANCED_POWER_ACCURACY:
                if (gmsLocationRequest != null)
                    gmsLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                if (hmsLocationRequest != null)
                    hmsLocationRequest.setPriority(com.huawei.hms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                break;
            case PRIORITY_LOW_POWER:
                if (gmsLocationRequest != null)
                    gmsLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_LOW_POWER);
                if (hmsLocationRequest != null)
                    hmsLocationRequest.setPriority(com.huawei.hms.location.LocationRequest.PRIORITY_LOW_POWER);
                break;
            case PRIORITY_NO_POWER:
                if (gmsLocationRequest != null)
                    gmsLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_NO_POWER);
                if (hmsLocationRequest != null)
                    hmsLocationRequest.setPriority(com.huawei.hms.location.LocationRequest.PRIORITY_NO_POWER);
                break;
            case PRIORITY_HD_ACCURACY:
                if (gmsLocationRequest != null)
                    gmsLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY);
                if (hmsLocationRequest != null)
                    hmsLocationRequest.setPriority(com.huawei.hms.location.LocationRequest.PRIORITY_HD_ACCURACY);
                break;
            default:
                throw new IllegalArgumentException(String.format("Priority %d is not a known constant", priority));
        }
        return this;
    }

    public int getPriority() {
        if (gmsLocationRequest != null) {
            int gmsPriority = gmsLocationRequest.getPriority();
            switch (gmsPriority) {
                case com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY:
                    return PRIORITY_HIGH_ACCURACY;
                case com.google.android.gms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY:
                    return PRIORITY_BALANCED_POWER_ACCURACY;
                case com.google.android.gms.location.LocationRequest.PRIORITY_LOW_POWER:
                    return PRIORITY_LOW_POWER;
                case com.google.android.gms.location.LocationRequest.PRIORITY_NO_POWER:
                    return PRIORITY_NO_POWER;
                default:
                    return gmsPriority;
            }
        }
        if (hmsLocationRequest != null) {
            int hmsPriority = hmsLocationRequest.getPriority();
            switch (hmsPriority) {
                case com.huawei.hms.location.LocationRequest.PRIORITY_HIGH_ACCURACY:
                    return PRIORITY_HIGH_ACCURACY;
                case com.huawei.hms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY:
                    return PRIORITY_BALANCED_POWER_ACCURACY;
                case com.huawei.hms.location.LocationRequest.PRIORITY_LOW_POWER:
                    return PRIORITY_LOW_POWER;
                case com.huawei.hms.location.LocationRequest.PRIORITY_NO_POWER:
                    return PRIORITY_NO_POWER;
                case com.huawei.hms.location.LocationRequest.PRIORITY_HD_ACCURACY:
                    return PRIORITY_HD_ACCURACY;
                default:
                    return hmsPriority;
            }
        }
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationRequest.");
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        if (gmsLocationRequest != null)
            gmsLocationRequest.setSmallestDisplacement(smallestDisplacementMeters);
        if (hmsLocationRequest != null)
            hmsLocationRequest.setSmallestDisplacement(smallestDisplacementMeters);
        return this;
    }

    public float getSmallestDisplacement() {
        if (gmsLocationRequest != null) return gmsLocationRequest.getSmallestDisplacement();
        if (hmsLocationRequest != null) return hmsLocationRequest.getSmallestDisplacement();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationRequest.");
    }

    public LocationRequest putExtras(String key, String value) {
        if (hmsLocationRequest != null) hmsLocationRequest.putExtras(key, value);
        return this;
    }

    public LocationRequest setNeedAddress(boolean needAddress) {
        if (hmsLocationRequest != null) hmsLocationRequest.setNeedAddress(needAddress);
        return this;
    }

    public LocationRequest setLanguage(String language) {
        if (hmsLocationRequest != null) hmsLocationRequest.setLanguage(language);
        return this;
    }

    public LocationRequest setCountryCode(String countryCode) {
        if (hmsLocationRequest != null) hmsLocationRequest.setCountryCode(countryCode);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationRequest that = (LocationRequest) o;
        return Objects.equals(gmsLocationRequest, that.gmsLocationRequest) &&
                Objects.equals(hmsLocationRequest, that.hmsLocationRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gmsLocationRequest, hmsLocationRequest);
    }

    @NonNull
    @Override
    public String toString() {
        if (gmsLocationRequest == null) {
            return hmsLocationRequest.toString();
        } else if (hmsLocationRequest == null) {
            return gmsLocationRequest.toString();
        } else {
            return String.format("GMS: %s \nHMS: %s", gmsLocationRequest.toString(), hmsLocationRequest.toString());
        }
    }
}