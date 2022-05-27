package com.boot.up.gateways.config.controller.proxy.handlers.supported;

import com.boot.up.core.domain.OperationName;
import com.boot.up.core.domain.commons.UseCase;
import com.boot.up.gateways.config.controller.proxy.handlers.Operation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

public class ToStringOperation implements Operation {

    private final UUID id = UUID.randomUUID();

    @Override
    public OperationName getNameOperation() {
        return OperationName.toString;
    }

    @Override
    public Object invoke(UseCase useCase, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        return id.toString();
    }
}
