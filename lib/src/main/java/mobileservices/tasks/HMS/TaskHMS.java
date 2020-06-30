package mobileservices.tasks.HMS;


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

public class TaskHMS<TResult> implements Task<TResult> {
    private final com.huawei.hmf.tasks.Task<TResult> task;

    public TaskHMS(com.huawei.hmf.tasks.Task<TResult> task) {
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
        return task.getResultThrowException(exceptionType);
    }

    @Override
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, final SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return new TaskHMS<>(task.onSuccessTask(executor, new com.huawei.hmf.tasks.SuccessContinuation<TResult, TContinuationResult>() {
            @NonNull
            @Override
            public com.huawei.hmf.tasks.Task<TContinuationResult> then(@Nullable TResult tResult) throws Exception {
                return ((TaskHMS<TContinuationResult>) successContinuation.then(tResult)).task;
            }
        }));
    }

    @Override
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(final SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return new TaskHMS<>(task.onSuccessTask(new com.huawei.hmf.tasks.SuccessContinuation<TResult, TContinuationResult>() {
            @NonNull
            @Override
            public com.huawei.hmf.tasks.Task<TContinuationResult> then(@Nullable TResult tResult) throws Exception {
                return ((TaskHMS<TContinuationResult>) successContinuation.then(tResult)).task;
            }
        }));
    }

    @Override
    public Task<TResult> addOnCanceledListener(final OnCanceledListener listener) {
        return new TaskHMS<>(task.addOnCanceledListener(new com.huawei.hmf.tasks.OnCanceledListener() {
            @Override
            public void onCanceled() {
                listener.onCanceled();
            }
        }));
    }

    @Override
    public Task<TResult> addOnCanceledListener(Executor executor, final OnCanceledListener listener) {
        return new TaskHMS<>(task.addOnCanceledListener(executor, new com.huawei.hmf.tasks.OnCanceledListener() {
            @Override
            public void onCanceled() {
                listener.onCanceled();
            }
        }));
    }

    @Override
    public Task<TResult> addOnCanceledListener(Activity activity, final OnCanceledListener listener) {
        return new TaskHMS<>(task.addOnCanceledListener(activity, new com.huawei.hmf.tasks.OnCanceledListener() {
            @Override
            public void onCanceled() {
                listener.onCanceled();
            }
        }));
    }

    @Override
    public Task<TResult> addOnCompleteListener(final OnCompleteListener<TResult> listener) {
        return new TaskHMS<>(task.addOnCompleteListener(new com.huawei.hmf.tasks.OnCompleteListener<TResult>() {
            @Override
            public void onComplete(@NonNull com.huawei.hmf.tasks.Task<TResult> task) {
                listener.onComplete(new TaskHMS<>(task));
            }
        }));
    }

    @Override
    public Task<TResult> addOnCompleteListener(Activity activity, final OnCompleteListener<TResult> listener) {
        return new TaskHMS<>(task.addOnCompleteListener(activity, new com.huawei.hmf.tasks.OnCompleteListener<TResult>() {
            @Override
            public void onComplete(@NonNull com.huawei.hmf.tasks.Task<TResult> task) {
                listener.onComplete(new TaskHMS<>(task));
            }
        }));
    }

    @Override
    public Task<TResult> addOnCompleteListener(Executor executor, final OnCompleteListener<TResult> listener) {
        return new TaskHMS<>(task.addOnCompleteListener(executor, new com.huawei.hmf.tasks.OnCompleteListener<TResult>() {
            @Override
            public void onComplete(@NonNull com.huawei.hmf.tasks.Task<TResult> task) {
                listener.onComplete(new TaskHMS<>(task));
            }
        }));
    }

    @Override
    public Task<TResult> addOnFailureListener(Activity activity, final OnFailureListener listener) {
        return new TaskHMS<>(task.addOnFailureListener(activity, new com.huawei.hmf.tasks.OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onFailure(e);
            }
        }));
    }

    @Override
    public Task<TResult> addOnFailureListener(final OnFailureListener listener) {
        return new TaskHMS<>(task.addOnFailureListener(new com.huawei.hmf.tasks.OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onFailure(e);
            }
        }));
    }

    @Override
    public Task<TResult> addOnFailureListener(Executor executor, final OnFailureListener listener) {
        return new TaskHMS<>(task.addOnFailureListener(executor, new com.huawei.hmf.tasks.OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onFailure(e);
            }
        }));
    }

    @Override
    public Task<TResult> addOnSuccessListener(Executor executor, final OnSuccessListener<? super TResult> listener) {
        return new TaskHMS<>(task.addOnSuccessListener(executor, new com.huawei.hmf.tasks.OnSuccessListener<TResult>() {
            @Override
            public void onSuccess(TResult tResult) {
                listener.onSuccess(tResult);
            }
        }));
    }

    @Override
    public Task<TResult> addOnSuccessListener(final OnSuccessListener<? super TResult> listener) {
        return new TaskHMS<>(task.addOnSuccessListener(new com.huawei.hmf.tasks.OnSuccessListener<TResult>() {
            @Override
            public void onSuccess(TResult tResult) {
                listener.onSuccess(tResult);
            }
        }));
    }

    @Override
    public Task<TResult> addOnSuccessListener(Activity activity, final OnSuccessListener<? super TResult> listener) {
        return new TaskHMS<>(task.addOnSuccessListener(activity, new com.huawei.hmf.tasks.OnSuccessListener<TResult>() {
            @Override
            public void onSuccess(TResult tResult) {
                listener.onSuccess(tResult);
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.tasks.Task<TContinuationResult> continueWith(final Continuation<TResult, TContinuationResult> continuation) {
        return new TaskHMS<>(task.continueWith(new com.huawei.hmf.tasks.Continuation<TResult, TContinuationResult>() {
            @Override
            public TContinuationResult then(@NonNull com.huawei.hmf.tasks.Task<TResult> task) throws Exception {
                return continuation.then(new TaskHMS<>(task));
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.tasks.Task<TContinuationResult> continueWith(Executor executor, final Continuation<TResult, TContinuationResult> continuation) {
        return new TaskHMS<>(task.continueWith(executor, new com.huawei.hmf.tasks.Continuation<TResult, TContinuationResult>() {
            @Override
            public TContinuationResult then(@NonNull com.huawei.hmf.tasks.Task<TResult> task) throws Exception {
                return continuation.then(new TaskHMS<>(task));
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.tasks.Task<TContinuationResult> continueWithTask(final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return new TaskHMS<>(task.continueWithTask(new com.huawei.hmf.tasks.Continuation<TResult, com.huawei.hmf.tasks.Task<TContinuationResult>>() {
            @Override
            public com.huawei.hmf.tasks.Task<TContinuationResult> then(@NonNull com.huawei.hmf.tasks.Task<TResult> task) throws Exception {
                return ((TaskHMS<TContinuationResult>) continuation.then(new TaskHMS<>(task))).task;
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.tasks.Task<TContinuationResult> continueWithTask(Executor executor, final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return new TaskHMS<>(task.continueWithTask(executor, new com.huawei.hmf.tasks.Continuation<TResult, com.huawei.hmf.tasks.Task<TContinuationResult>>() {
            @Override
            public com.huawei.hmf.tasks.Task<TContinuationResult> then(@NonNull com.huawei.hmf.tasks.Task<TResult> task) throws Exception {
                return ((TaskHMS<TContinuationResult>) continuation.then(new TaskHMS<>(task))).task;
            }
        }));
    }

    @Override
    public Exception getException() {
        return task.getException();
    }
}