package mobileservices.location.GMS;

import android.content.Intent;
import android.os.Parcel;

import androidx.annotation.NonNull;

import mobileservices.location.LocationAvailability;

public class LocationAvailabilityGMS implements LocationAvailability {

    private final com.google.android.gms.location.LocationAvailability locationAvailability;

    private LocationAvailabilityGMS(Parcel in) {
        locationAvailability = com.google.android.gms.location.LocationAvailability.CREATOR.createFromParcel(in);
    }

    LocationAvailabilityGMS(@NonNull com.google.android.gms.location.LocationAvailability locationAvailability) {
        this.locationAvailability = locationAvailability;
    }

    @Override
    public LocationAvailability extractLocationAvailability(Intent intent) {
        return new LocationAvailabilityGMS(com.google.android.gms.location.LocationAvailability.extractLocationAvailability(intent));
    }

    @Override
    public boolean hasLocationAvailability(Intent intent) {
        return com.google.android.gms.location.LocationAvailability.hasLocationAvailability(intent);
    }

    @Override
    public boolean isLocationAvailable() {
        return locationAvailability.isLocationAvailable();
    }

    @Override
    public int getCellStatus() {
        throw new UnsupportedOperationException("GMS doesn't support HMS functionality: LocationAvailability.getCellStatus()");
    }

    @Override
    public int getWifiStatus() {
        throw new UnsupportedOperationException("GMS doesn't support HMS functionality: LocationAvailability.getWifiStatus()");
    }

    @Override
    public long getElapsedRealtimeNs() {
        throw new UnsupportedOperationException("GMS doesn't support HMS functionality: LocationAvailability.getElapsedRealtimeNs()");
    }

    @Override
    public int getLocationStatus() {
        throw new UnsupportedOperationException("GMS doesn't support HMS functionality: LocationAvailability.getLocationStatus()");
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
        LocationAvailabilityGMS that = (LocationAvailabilityGMS) o;
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

    public static final Creator<LocationAvailabilityGMS> CREATOR = new Creator<LocationAvailabilityGMS>() {
        @Override
        public LocationAvailabilityGMS createFromParcel(Parcel in) {
            return new LocationAvailabilityGMS(in);
        }

        @Override
        public LocationAvailabilityGMS[] newArray(int size) {
            return new LocationAvailabilityGMS[size];
        }
    };
}
