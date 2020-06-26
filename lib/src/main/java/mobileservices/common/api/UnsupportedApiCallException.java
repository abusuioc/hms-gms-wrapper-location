package mobileservices.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class UnsupportedApiCallException extends UnsupportedOperationException {
    protected final com.google.android.gms.common.api.UnsupportedApiCallException gmsUnsupportedApiCallException;
    protected final com.huawei.hms.common.api.UnsupportedApiCallException hmsUnsupportedApiCallException;

    protected UnsupportedApiCallException(com.google.android.gms.common.api.UnsupportedApiCallException gmsUnsupportedApiCallException, com.huawei.hms.common.api.UnsupportedApiCallException hmsUnsupportedApiCallException) {
        this.gmsUnsupportedApiCallException = gmsUnsupportedApiCallException;
        this.hmsUnsupportedApiCallException = hmsUnsupportedApiCallException;
    }

    @Nullable
    @Override
    public String getMessage() {
        if (gmsUnsupportedApiCallException != null)
            return gmsUnsupportedApiCallException.getMessage();
        if (hmsUnsupportedApiCallException != null)
            return hmsUnsupportedApiCallException.getMessage();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS UnsupportedApiCallException.");
    }

    @Nullable
    @Override
    public String getLocalizedMessage() {
        if (gmsUnsupportedApiCallException != null)
            return gmsUnsupportedApiCallException.getLocalizedMessage();
        if (hmsUnsupportedApiCallException != null)
            return hmsUnsupportedApiCallException.getLocalizedMessage();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS UnsupportedApiCallException.");
    }

    @NonNull
    @Override
    public StackTraceElement[] getStackTrace() {
        if (gmsUnsupportedApiCallException != null)
            return gmsUnsupportedApiCallException.getStackTrace();
        if (hmsUnsupportedApiCallException != null)
            return hmsUnsupportedApiCallException.getStackTrace();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS UnsupportedApiCallException.");
    }

    @Nullable
    @Override
    public synchronized Throwable getCause() {
        if (gmsUnsupportedApiCallException != null)
            return gmsUnsupportedApiCallException.getCause();
        if (hmsUnsupportedApiCallException != null)
            return hmsUnsupportedApiCallException.getCause();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS UnsupportedApiCallException.");
    }
}