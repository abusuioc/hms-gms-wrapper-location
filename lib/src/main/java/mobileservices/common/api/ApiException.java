package mobileservices.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ApiException extends Exception {

    protected final com.google.android.gms.common.api.ApiException gmsApiException;
    protected final com.huawei.hms.common.ApiException hmsApiException;

    protected ApiException(com.google.android.gms.common.api.ApiException gmsApiException, com.huawei.hms.common.ApiException hmsApiException) {
        this.gmsApiException = gmsApiException;
        this.hmsApiException = hmsApiException;
    }

    public int getStatusCode() {
        if (gmsApiException != null) return gmsApiException.getStatusCode();
        if (hmsApiException != null) return hmsApiException.getStatusCode();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS ApiException.");
    }

    @Nullable
    @Override
    public String getMessage() {
        if (gmsApiException != null) return gmsApiException.getMessage();
        if (hmsApiException != null) return hmsApiException.getMessage();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS ApiException.");
    }

    @Nullable
    @Override
    public String getLocalizedMessage() {
        if (gmsApiException != null) return gmsApiException.getLocalizedMessage();
        if (hmsApiException != null) return hmsApiException.getLocalizedMessage();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS ApiException.");
    }

    @NonNull
    @Override
    public StackTraceElement[] getStackTrace() {
        if (gmsApiException != null) return gmsApiException.getStackTrace();
        if (hmsApiException != null) return hmsApiException.getStackTrace();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS ApiException.");
    }

    @Nullable
    @Override
    public synchronized Throwable getCause() {
        if (gmsApiException != null) return gmsApiException.getCause();
        if (hmsApiException != null) return hmsApiException.getCause();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS ApiException.");
    }
}