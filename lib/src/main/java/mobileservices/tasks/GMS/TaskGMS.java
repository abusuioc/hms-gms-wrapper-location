package mobileservices.tasks.GMS;


import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.concurrent.Executor;

import mobileservices.tasks.Continuation;
import mobileservices.tasks.OnCanceledListener;
import mobileservices.tasks.OnCompleteListener;
import mobileservices.tasks.OnFailureListener;
import mobileservices.tasks.OnSuccessListener;
import mobileservices.tasks.SuccessContinuation;
import mobileservices.tasks.Task;

public class TaskGMS<TResult> implements Task<TResult> {
    private final com.google.android.gms.tasks.Task<TResult> task;

    public TaskGMS(com.google.android.gms.tasks.Task<TResult> task) {
        this.task = task;
    }

    @Override
    public boolean isCanceled() {
        return task.isCanceled();
    }

    @Override
    public boolean isComplete() {
        return task.isComplete();
    }

    @Override
    public boolean isSuccessful() {
        return task.isSuccessful();
    }

    @Override
    public TResult getResult() {
        return task.getResult();
    }

    @Override
    public <X extends Throwable> TResult getResult(Class<X> exceptionType) throws X {
        return task.getResult(exceptionType);
    }

    @Override
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, final SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return new TaskGMS<>(task.onSuccessTask(executor, new com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult>() {
            @NonNull
            @Override
            public com.google.android.gms.tasks.Task<TContinuationResult> then(@Nullable TResult tResult) throws Exception {
                return ((TaskGMS<TContinuationResult>) successContinuation.then(tResult)).task;
            }
        }));
    }

    @Override
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(final SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return new TaskGMS<>(task.onSuccessTask(new com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult>() {
            @NonNull
            @Override
            public com.google.android.gms.tasks.Task<TContinuationResult> then(@Nullable TResult tResult) throws Exception {
                return ((TaskGMS<TContinuationResult>) successContinuation.then(tResult)).task;
            }
        }));
    }

    @Override
    public Task<TResult> addOnCanceledListener(final OnCanceledListener listener) {
        return new TaskGMS<>(task.addOnCanceledListener(new com.google.android.gms.tasks.OnCanceledListener() {
            @Override
            public void onCanceled() {
                listener.onCanceled();
            }
        }));
    }

    @Override
    public Task<TResult> addOnCanceledListener(Executor executor, final OnCanceledListener listener) {
        return new TaskGMS<>(task.addOnCanceledListener(executor, new com.google.android.gms.tasks.OnCanceledListener() {
            @Override
            public void onCanceled() {
                listener.onCanceled();
            }
        }));
    }

    @Override
    public Task<TResult> addOnCanceledListener(Activity activity, final OnCanceledListener listener) {
        return new TaskGMS<>(task.addOnCanceledListener(activity, new com.google.android.gms.tasks.OnCanceledListener() {
            @Override
            public void onCanceled() {
                listener.onCanceled();
            }
        }));
    }

    @Override
    public Task<TResult> addOnCompleteListener(final OnCompleteListener<TResult> listener) {
        return new TaskGMS<>(task.addOnCompleteListener(new com.google.android.gms.tasks.OnCompleteListener<TResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<TResult> task) {
                listener.onComplete(new TaskGMS<>(task));
            }
        }));
    }

    @Override
    public Task<TResult> addOnCompleteListener(Activity activity, final OnCompleteListener<TResult> listener) {
        return new TaskGMS<>(task.addOnCompleteListener(activity, new com.google.android.gms.tasks.OnCompleteListener<TResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<TResult> task) {
                listener.onComplete(new TaskGMS<>(task));
            }
        }));
    }

    @Override
    public Task<TResult> addOnCompleteListener(Executor executor, final OnCompleteListener<TResult> listener) {
        return new TaskGMS<>(task.addOnCompleteListener(executor, new com.google.android.gms.tasks.OnCompleteListener<TResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<TResult> task) {
                listener.onComplete(new TaskGMS<>(task));
            }
        }));
    }

    @Override
    public Task<TResult> addOnFailureListener(Activity activity, final OnFailureListener listener) {
        return new TaskGMS<>(task.addOnFailureListener(activity, new com.google.android.gms.tasks.OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onFailure(e);
            }
        }));
    }

    @Override
    public Task<TResult> addOnFailureListener(final OnFailureListener listener) {
        return new TaskGMS<>(task.addOnFailureListener(new com.google.android.gms.tasks.OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onFailure(e);
            }
        }));
    }

    @Override
    public Task<TResult> addOnFailureListener(Executor executor, final OnFailureListener listener) {
        return new TaskGMS<>(task.addOnFailureListener(executor, new com.google.android.gms.tasks.OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onFailure(e);
            }
        }));
    }

    @Override
    public Task<TResult> addOnSuccessListener(Executor executor, final OnSuccessListener<? super TResult> listener) {
        return new TaskGMS<>(task.addOnSuccessListener(executor, new com.google.android.gms.tasks.OnSuccessListener<TResult>() {
            @Override
            public void onSuccess(TResult tResult) {
                listener.onSuccess(tResult);
            }
        }));
    }

    @Override
    public Task<TResult> addOnSuccessListener(final OnSuccessListener<? super TResult> listener) {
        return new TaskGMS<>(task.addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener<TResult>() {
            @Override
            public void onSuccess(TResult tResult) {
                listener.onSuccess(tResult);
            }
        }));
    }

    @Override
    public Task<TResult> addOnSuccessListener(Activity activity, final OnSuccessListener<? super TResult> listener) {
        return new TaskGMS<>(task.addOnSuccessListener(activity, new com.google.android.gms.tasks.OnSuccessListener<TResult>() {
            @Override
            public void onSuccess(TResult tResult) {
                listener.onSuccess(tResult);
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.tasks.Task<TContinuationResult> continueWith(final Continuation<TResult, TContinuationResult> continuation) {
        return new TaskGMS<>(task.continueWith(new com.google.android.gms.tasks.Continuation<TResult, TContinuationResult>() {
            @Override
            public TContinuationResult then(@NonNull com.google.android.gms.tasks.Task<TResult> task) throws Exception {
                return continuation.then(new TaskGMS<>(task));
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.tasks.Task<TContinuationResult> continueWith(Executor executor, final Continuation<TResult, TContinuationResult> continuation) {
        return new TaskGMS<>(task.continueWith(executor, new com.google.android.gms.tasks.Continuation<TResult, TContinuationResult>() {
            @Override
            public TContinuationResult then(@NonNull com.google.android.gms.tasks.Task<TResult> task) throws Exception {
                return continuation.then(new TaskGMS<>(task));
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.tasks.Task<TContinuationResult> continueWithTask(final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return new TaskGMS<>(task.continueWithTask(new com.google.android.gms.tasks.Continuation<TResult, com.google.android.gms.tasks.Task<TContinuationResult>>() {
            @Override
            public com.google.android.gms.tasks.Task<TContinuationResult> then(@NonNull com.google.android.gms.tasks.Task<TResult> task) throws Exception {
                return ((TaskGMS<TContinuationResult>) continuation.then(new TaskGMS<>(task))).task;
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.tasks.Task<TContinuationResult> continueWithTask(Executor executor, final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return new TaskGMS<>(task.continueWithTask(executor, new com.google.android.gms.tasks.Continuation<TResult, com.google.android.gms.tasks.Task<TContinuationResult>>() {
            @Override
            public com.google.android.gms.tasks.Task<TContinuationResult> then(@NonNull com.google.android.gms.tasks.Task<TResult> task) throws Exception {
                return ((TaskGMS<TContinuationResult>) continuation.then(new TaskGMS<>(task))).task;
            }
        }));
    }

    @Override
    public Exception getException() {
        return task.getException();
    }
}
