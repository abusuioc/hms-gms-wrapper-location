package mobileservices.location;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

import mobileservices.common.api.ExceptionConverter;
import mobileservices.task.Continuation;
import mobileservices.task.Task;

/**
 * Special @link {@link Continuation} that converts the result in case of success and the Exception in case of failure.
 */
abstract class ContinuationWithConversion<TResult, TContinuationResult> implements Continuation<TResult, TContinuationResult> {

    @Override
    @CallSuper
    public TContinuationResult then(@NonNull Task<TResult> task) throws Exception {
        final Exception exception = task.getException();
        if (exception != null) {
            throw convertException(exception);
        }
        return convertResult(task.getResult());
    }

    public abstract TContinuationResult convertResult(TResult result);

    @CallSuper
    protected Exception convertException(Exception original) {
        return ExceptionConverter.convertException(original);
    }
}
