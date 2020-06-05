package mobileservices.location.HMS;

import android.content.Intent;
import android.os.Parcel;

import androidx.annotation.NonNull;

import mobileservices.location.LocationAvailability;

public class LocationAvailabilityHMS implements LocationAvailability {

    private final com.huawei.hms.location.LocationAvailability locationAvailability;

    private LocationAvailabilityHMS(Parcel in) {
        locationAvailability = com.huawei.hms.location.LocationAvailability.CREATOR.createFromParcel(in);
    }

    LocationAvailabilityHMS(@NonNull com.huawei.hms.location.LocationAvailability locationAvailability) {
        this.locationAvailability = locationAvailability;
    }

    @Override
    public mobileservices.location.LocationAvailability extractLocationAvailability(Intent intent) {
        return new LocationAvailabilityHMS(com.huawei.hms.location.LocationAvailability.extractLocationAvailability(intent));
    }

    @Override
    public boolean hasLocationAvailability(Intent intent) {
        return com.huawei.hms.location.LocationAvailability.hasLocationAvailability(intent);
    }

    @Override
    public boolean isLocationAvailable() {
        return locationAvailability.isLocationAvailable();
    }

    @Override
    public int getCellStatus() {
        return locationAvailability.getCellStatus();
    }

    @Override
    public int getWifiStatus() {
        return locationAvailability.getWifiStatus();
    }

    @Override
    public long getElapsedRealtimeNs() {
        return locationAvailability.getElapsedRealtimeNs();
    }

    @Override
    public int getLocationStatus() {
        return locationAvailability.getLocationStatus();
    }

    @Override
    @NonNull
    public String toString() {
        return locationAvailability.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationAvailabilityHMS that = (LocationAvailabilityHMS) o;
        return locationAvailability.equals(that.locationAvailability);
    }

    @Override
    public int hashCode() {
        return locationAvailability.hashCode();
    }

// PARCELABLE

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        locationAvailability.writeToParcel(dest, flags);
    }

    public static final Creator<LocationAvailabilityHMS> CREATOR = new Creator<LocationAvailabilityHMS>() {
        @Override
        public LocationAvailabilityHMS createFromParcel(Parcel in) {
            return new LocationAvailabilityHMS(in);
        }

        @Override
        public LocationAvailabilityHMS[] newArray(int size) {
            return new LocationAvailabilityHMS[size];
        }
    };
}
