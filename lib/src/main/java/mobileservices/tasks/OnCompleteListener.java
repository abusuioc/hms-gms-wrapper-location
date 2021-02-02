package mobileservices.tasks;

import android.support.annotation.NonNull;

public interface OnCompleteListener<TResult> {
    void onComplete(@NonNull Task<TResult> var1);
}