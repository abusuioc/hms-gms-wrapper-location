package mobileservices.task.HMS;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;

import mobileservices.task.Continuation;
import mobileservices.task.Task;

public class TaskHMS<TResult> implements Task<TResult> {
    private final com.huawei.hmf.tasks.Task<TResult> task;

    public TaskHMS(com.huawei.hmf.tasks.Task<TResult> task) {
        this.task = task;
    }

    @Override
    public TResult getResult() {
        return task.getResult();
    }

    @Override
    public <TContinuationResult> mobileservices.task.Task<TContinuationResult> continueWith(final Continuation<TResult, TContinuationResult> continuation) {
        return new TaskHMS<>(task.continueWith(new com.huawei.hmf.tasks.Continuation<TResult, TContinuationResult>() {
            @Override
            public TContinuationResult then(@NonNull com.huawei.hmf.tasks.Task<TResult> task) throws Exception {
                return continuation.then(new TaskHMS<>(task));
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.task.Task<TContinuationResult> continueWith(Executor executor, final Continuation<TResult, TContinuationResult> continuation) {
        return new TaskHMS<>(task.continueWith(executor, new com.huawei.hmf.tasks.Continuation<TResult, TContinuationResult>() {
            @Override
            public TContinuationResult then(@NonNull com.huawei.hmf.tasks.Task<TResult> task) throws Exception {
                return continuation.then(new TaskHMS<>(task));
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.task.Task<TContinuationResult> continueWithTask(final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return new TaskHMS<>(task.continueWithTask(new com.huawei.hmf.tasks.Continuation<TResult, com.huawei.hmf.tasks.Task<TContinuationResult>>() {
            @Override
            public com.huawei.hmf.tasks.Task<TContinuationResult> then(@NonNull com.huawei.hmf.tasks.Task<TResult> task) throws Exception {
                return ((TaskHMS<TContinuationResult>) continuation.then(new TaskHMS<>(task))).task;
            }
        }));
    }

    @Override
    public <TContinuationResult> mobileservices.task.Task<TContinuationResult> continueWithTask(Executor executor, final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return new TaskHMS<>(task.continueWithTask(executor, new com.huawei.hmf.tasks.Continuation<TResult, com.huawei.hmf.tasks.Task<TContinuationResult>>() {
            @Override
            public com.huawei.hmf.tasks.Task<TContinuationResult> then(@NonNull com.huawei.hmf.tasks.Task<TResult> task) throws Exception {
                return ((TaskHMS<TContinuationResult>) continuation.then(new TaskHMS<>(task))).task;
            }
        }));
    }
}