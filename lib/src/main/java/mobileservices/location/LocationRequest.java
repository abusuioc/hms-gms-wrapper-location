package mobileservices.location;

import androidx.annotation.NonNull;

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

    public LocationRequest setExpirationDuration(long millis) {
        gmsLocationRequest.setExpirationDuration(millis);
        hmsLocationRequest.setExpirationDuration(millis);
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        gmsLocationRequest.setExpirationTime(millis);
        hmsLocationRequest.setExpirationTime(millis);
        return this;
    }

    public long getExpirationTime() {
        return gmsLocationRequest.getExpirationTime();
    }

    public LocationRequest setFastestInterval(long millis) {
        gmsLocationRequest.setFastestInterval(millis);
        hmsLocationRequest.setFastestInterval(millis);
        return this;
    }

    public long getFastestInterval() {
        return gmsLocationRequest.getFastestInterval();
    }

    public LocationRequest setInterval(long millis) {
        gmsLocationRequest.setInterval(millis);
        hmsLocationRequest.setInterval(millis);
        return this;
    }

    public long getInterval() {
        return gmsLocationRequest.getInterval();
    }

    public LocationRequest setMaxWaitTime(long millis) {
        gmsLocationRequest.setMaxWaitTime(millis);
        hmsLocationRequest.setMaxWaitTime(millis);
        return this;
    }

    public long getMaxWaitTime() {
        return gmsLocationRequest.getMaxWaitTime();
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        gmsLocationRequest.setNumUpdates(numUpdates);
        hmsLocationRequest.setNumUpdates(numUpdates);
        return this;
    }

    public int getNumUpdates() {
        return gmsLocationRequest.getNumUpdates();
    }

    public LocationRequest setPriority(int priority) {
        switch (priority) {
            case PRIORITY_HIGH_ACCURACY:
                gmsLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY);
                hmsLocationRequest.setPriority(com.huawei.hms.location.LocationRequest.PRIORITY_HIGH_ACCURACY);
                break;
            case PRIORITY_BALANCED_POWER_ACCURACY:
                gmsLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                hmsLocationRequest.setPriority(com.huawei.hms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                break;
            case PRIORITY_LOW_POWER:
                gmsLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_LOW_POWER);
                hmsLocationRequest.setPriority(com.huawei.hms.location.LocationRequest.PRIORITY_LOW_POWER);
                break;
            case PRIORITY_NO_POWER:
                gmsLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_NO_POWER);
                hmsLocationRequest.setPriority(com.huawei.hms.location.LocationRequest.PRIORITY_NO_POWER);
                break;
            case PRIORITY_HD_ACCURACY:
                gmsLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY);
                hmsLocationRequest.setPriority(com.huawei.hms.location.LocationRequest.PRIORITY_HD_ACCURACY);
                break;
            default:
                throw new IllegalArgumentException(String.format("Priority %d is not a known constant", priority));
        }
        return this;
    }

    public int getPriority() {
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

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        gmsLocationRequest.setSmallestDisplacement(smallestDisplacementMeters);
        hmsLocationRequest.setSmallestDisplacement(smallestDisplacementMeters);
        return this;
    }

    public float getSmallestDisplacement() {
        return gmsLocationRequest.getSmallestDisplacement();
    }

    public LocationRequest putExtras(String key, String value) {
        hmsLocationRequest.putExtras(key, value);
        return this;
    }

    public LocationRequest setNeedAddress(boolean needAddress) {
        hmsLocationRequest.setNeedAddress(needAddress);
        return this;
    }

    public LocationRequest setLanguage(String language) {
        hmsLocationRequest.setLanguage(language);
        return this;
    }

    public LocationRequest setCountryCode(String countryCode) {
        hmsLocationRequest.setCountryCode(countryCode);
        return this;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("GMS: %s \nHMS: %s", gmsLocationRequest.toString(), hmsLocationRequest.toString());
    }
}