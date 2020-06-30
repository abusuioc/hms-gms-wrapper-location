package mobileservices.location;

/**
 * Special @link {@link mobileservices.tasks.Continuation} that leaves the result unchanged but does convert the eventual Exception.
 * @param <TResult>
 */
public class ContinuationIdentity<TResult> extends ContinuationWithConversion<TResult, TResult> {
    @Override
    public TResult convertResult(TResult result) {
        return result;
    }
}