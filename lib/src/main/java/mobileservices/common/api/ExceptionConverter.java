package mobileservices.common.api;

public class ExceptionConverter {
    public static Exception convertException(Exception originalException) {
        if (originalException == null) {
            return null;
        } else if (originalException instanceof com.google.android.gms.common.api.ResolvableApiException) {
            return new ResolvableApiException((com.google.android.gms.common.api.ResolvableApiException) originalException, null);
        } else if (originalException instanceof com.huawei.hms.common.ResolvableApiException) {
            return new ResolvableApiException(null, (com.huawei.hms.common.ResolvableApiException) originalException);
        } else if (originalException instanceof com.google.android.gms.common.api.ApiException) {
            return new ApiException((com.google.android.gms.common.api.ApiException) originalException, null);
        } else if (originalException instanceof com.huawei.hms.common.ApiException) {
            return new ApiException(null, (com.huawei.hms.common.ApiException) originalException);
        } else if (originalException instanceof com.google.android.gms.common.api.UnsupportedApiCallException) {
            return new UnsupportedApiCallException((com.google.android.gms.common.api.UnsupportedApiCallException) originalException, null);
        } else if (originalException instanceof com.huawei.hms.common.api.UnsupportedApiCallException) {
            return new UnsupportedApiCallException(null, (com.huawei.hms.common.api.UnsupportedApiCallException) originalException);
        }
        return null;
    }
}