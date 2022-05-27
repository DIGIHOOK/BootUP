package com.boot.up.gateways.config.controller.proxy.handlers;

import com.boot.up.core.domain.OperationName;
import com.boot.up.core.domain.commons.UseCase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Operation {
    public OperationName getNameOperation();

    public Object invoke(UseCase useCase, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
}
