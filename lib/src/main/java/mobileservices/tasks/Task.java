package mobileservices.tasks;

import android.app.Activity;

import java.util.concurrent.Executor;

public interface Task<TResult> {

    Task<TResult> addOnCanceledListener(OnCanceledListener listener);

    Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener listener);

    Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener listener);

    Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> listener);

    Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> listener);

    Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> listener);

    Task<TResult> addOnFailureListener(Activity activity, OnFailureListener listener);

    Task<TResult> addOnFailureListener(OnFailureListener listener);

    Task<TResult> addOnFailureListener(Executor executor, OnFailureListener listener);

    Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> listener);

    Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> listener);

    Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<? super TResult> listener);

    <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation);

    <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation);

    <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation);

    <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation);

    Exception getException();

    TResult getResult();

    <X extends Throwable> TResult getResult(Class<X> exceptionType) throws X;

    boolean isCanceled();

    boolean isComplete();

    boolean isSuccessful();

    <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation);

    <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation);
}
