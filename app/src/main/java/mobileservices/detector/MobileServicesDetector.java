package mobileservices.detector;

import android.content.Context;

import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;

public class MobileServicesDetector {

    /**
     * Checks for Google Play Services availability.
     */
    static public boolean isGmsAvailable(Context context) {
        return GoogleApiAvailability.getInstance()
                .isGooglePlayServicesAvailable(context) == com.google.android.gms.common.ConnectionResult.SUCCESS;
    }

    /**
     * Checks for Huawei Mobile Services availability.
     */
    static public boolean isHmsAvailable(Context context) {
        return HuaweiApiAvailability.getInstance()
                .isHuaweiMobileServicesAvailable(context) == com.huawei.hms.api.ConnectionResult.SUCCESS;
    }

    /**
     * Detect if there is at least one mobile service available.
     * Checks for Google Play Services and Huawei Mobile Services availability.
     */
    static public boolean areMobileServicesAvailable(Context context) {
        return isGmsAvailable(context) || isHmsAvailable(context);
    }
}