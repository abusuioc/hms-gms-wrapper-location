package mobileservices.detector;

import android.content.Context;

import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;

public class MobileServicesDetector {

    static public boolean isGmsAvailable(Context context) {
        return GoogleApiAvailability.getInstance()
                .isGooglePlayServicesAvailable(context) == com.google.android.gms.common.ConnectionResult.SUCCESS;
    }

    static public boolean isHmsAvailable(Context context) {
        return HuaweiApiAvailability.getInstance()
                .isHuaweiMobileServicesAvailable(context) == com.huawei.hms.api.ConnectionResult.SUCCESS;
    }

    /**
     * Choose GMS first, then HMS, but if none is available then rollback to GMS as this is anyway the default behavior on GMS implementations.
     * @param context
     * @return go the GMS way.
     */
    static public boolean hasToChooseGms(Context context) {
        if(isGmsAvailable(context)) return true;
        return !isHmsAvailable(context);
    }
}