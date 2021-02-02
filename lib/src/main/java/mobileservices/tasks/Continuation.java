package mobileservices.tasks;

import android.support.annotation.NonNull;

public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(@NonNull Task<TResult> var1) throws Exception;
}