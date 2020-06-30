package mobileservices.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface SuccessContinuation<TResult, TContinuationResult> {
    @NonNull
    Task<TContinuationResult> then(@Nullable TResult var1) throws Exception;
}
