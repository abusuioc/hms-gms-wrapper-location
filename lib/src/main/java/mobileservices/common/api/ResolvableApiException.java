package mobileservices.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;

public class ResolvableApiException extends ApiException {

    ResolvableApiException(com.google.android.gms.common.api.ResolvableApiException gmsResolvableApiException, com.huawei.hms.common.ResolvableApiException hmsResolvableApiException) {
        super(gmsResolvableApiException, hmsResolvableApiException);
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws IntentSender.SendIntentException {
        if (gmsApiException != null) {
            ((com.google.android.gms.common.api.ResolvableApiException) gmsApiException).startResolutionForResult(activity, requestCode);
        } else if (hmsApiException != null) {
            ((com.huawei.hms.common.ResolvableApiException) hmsApiException).startResolutionForResult(activity, requestCode);
        } else {
            throw new UnsupportedOperationException("Missing underlying GMS/HMS ResolvableApiException.");
        }
    }

    public PendingIntent getResolution() {
        if (gmsApiException != null) {
            return ((com.google.android.gms.common.api.ResolvableApiException) gmsApiException).getResolution();
        }
        if (hmsApiException != null) {
            return ((com.huawei.hms.common.ResolvableApiException) hmsApiException).getResolution();
        }
        throw new UnsupportedOperationException("Missing underlying GMS/HMS ResolvableApiException.");
    }

}
