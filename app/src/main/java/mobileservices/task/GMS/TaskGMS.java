package mobileservices.task.GMS;


import androidx.annotation.NonNull;

import java.util.concurrent.Executor;

import mobileservices.task.Continuation;
import mobileservices.task.Task;

public class TaskGMS<TResult> implements Task<TResult> {
    private final com.google.android.gms.tasks.Task<TResult> task;

    public TaskGMS(com.google.android.gms.tasks.Task<TResult> task) {
        this.task = task;
    }

    @Override
    public TResult getResult() {
        return task.getResult();
    }

    @Override
    public <TContinuationResult> mobileservices.task.Task<TContinuationResult> continueWith(final Continuation<TResult, TContinuationResult> continuation) {
        return new TaskGMS<>(task.continueWith(new com.google.android.gms.tasks.Continuation<TResult, TContinuationResult>() {
            @Override
            public TContinuationResult then(@NonNull com.google.android.gms.tasks.Task<TResult> task) throws Exception {
                return continuation.then(new TaskGMS<>(task));
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.task.Task<TContinuationResult> continueWith(Executor executor, final Continuation<TResult, TContinuationResult> continuation) {
        return new TaskGMS<>(task.continueWith(executor, new com.google.android.gms.tasks.Continuation<TResult, TContinuationResult>() {
            @Override
            public TContinuationResult then(@NonNull com.google.android.gms.tasks.Task<TResult> task) throws Exception {
                return continuation.then(new TaskGMS<>(task));
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.task.Task<TContinuationResult> continueWithTask(final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return new TaskGMS<>(task.continueWithTask(new com.google.android.gms.tasks.Continuation<TResult, com.google.android.gms.tasks.Task<TContinuationResult>>() {
            @Override
            public com.google.android.gms.tasks.Task<TContinuationResult> then(@NonNull com.google.android.gms.tasks.Task<TResult> task) throws Exception {
                return ((TaskGMS<TContinuationResult>) continuation.then(new TaskGMS<>(task))).task;
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.task.Task<TContinuationResult> continueWithTask(Executor executor, final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return new TaskGMS<>(task.continueWithTask(executor, new com.google.android.gms.tasks.Continuation<TResult, com.google.android.gms.tasks.Task<TContinuationResult>>() {
            @Override
            public com.google.android.gms.tasks.Task<TContinuationResult> then(@NonNull com.google.android.gms.tasks.Task<TResult> task) throws Exception {
                return ((TaskGMS<TContinuationResult>) continuation.then(new TaskGMS<>(task))).task;
            }
        }));
    }
}
