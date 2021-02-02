package mobileservices.tasks;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface SuccessContinuation<TResult, TContinuationResult> {
    @NonNull
    Task<TContinuationResult> then(@Nullable TResult var1) throws Exception;
}
