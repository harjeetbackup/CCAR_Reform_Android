package com.reformluach.services;

public abstract class ServiceStatus {
    public abstract void onSuccess(Object o);

    public abstract void onFailed(Object o);
}
