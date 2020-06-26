package mobileservices.location;

import android.content.Intent;

/**
 * Wrapped LocationSettingsStates.
 * Parcelable is not implemented.
 *
 * @see com.google.android.gms.location.LocationSettingsStates
 * @see com.huawei.hms.location.LocationSettingsStates
 */
public class LocationSettingsStates {
    final com.google.android.gms.location.LocationSettingsStates gmsLocationSettingsStates;
    final com.huawei.hms.location.LocationSettingsStates hmsLocationSettingsStates;

    LocationSettingsStates(
            com.google.android.gms.location.LocationSettingsStates gmsLocationSettingsStates,
            com.huawei.hms.location.LocationSettingsStates hmsLocationSettingsStates
    ) {
        this.gmsLocationSettingsStates = gmsLocationSettingsStates;
        this.hmsLocationSettingsStates = hmsLocationSettingsStates;
    }

    public final boolean isGpsUsable() {
        if (gmsLocationSettingsStates != null) return gmsLocationSettingsStates.isGpsUsable();
        if (hmsLocationSettingsStates != null) return hmsLocationSettingsStates.isGpsUsable();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationSettingsStates.");
    }

    public final boolean isGpsPresent() {
        if (gmsLocationSettingsStates != null) return gmsLocationSettingsStates.isGpsPresent();
        if (hmsLocationSettingsStates != null) return hmsLocationSettingsStates.isGpsPresent();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationSettingsStates.");
    }

    public final boolean isNetworkLocationUsable() {
        if (gmsLocationSettingsStates != null)
            return gmsLocationSettingsStates.isNetworkLocationUsable();
        if (hmsLocationSettingsStates != null)
            return hmsLocationSettingsStates.isNetworkLocationUsable();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationSettingsStates.");
    }

    public final boolean isNetworkLocationPresent() {
        if (gmsLocationSettingsStates != null)
            return gmsLocationSettingsStates.isNetworkLocationPresent();
        if (hmsLocationSettingsStates != null)
            return hmsLocationSettingsStates.isNetworkLocationPresent();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationSettingsStates.");
    }

    public final boolean isLocationUsable() {
        if (gmsLocationSettingsStates != null) return gmsLocationSettingsStates.isLocationUsable();
        if (hmsLocationSettingsStates != null) return hmsLocationSettingsStates.isLocationUsable();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationSettingsStates.");
    }

    public final boolean isLocationPresent() {
        if (gmsLocationSettingsStates != null) return gmsLocationSettingsStates.isLocationPresent();
        if (hmsLocationSettingsStates != null) return hmsLocationSettingsStates.isLocationPresent();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationSettingsStates.");
    }

    public final boolean isBleUsable() {
        if (gmsLocationSettingsStates != null) return gmsLocationSettingsStates.isBleUsable();
        if (hmsLocationSettingsStates != null) return hmsLocationSettingsStates.isBleUsable();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationSettingsStates.");
    }

    public final boolean isBlePresent() {
        if (gmsLocationSettingsStates != null) return gmsLocationSettingsStates.isBlePresent();
        if (hmsLocationSettingsStates != null) return hmsLocationSettingsStates.isBlePresent();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS LocationSettingsStates.");
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        return new LocationSettingsStates(
                com.google.android.gms.location.LocationSettingsStates.fromIntent(intent),
                com.huawei.hms.location.LocationSettingsStates.fromIntent(intent)
        );
    }
}