package com.boot.up.gateways.config.controller.proxy.handlers.supported;

import com.boot.up.core.domain.OperationName;
import com.boot.up.core.domain.commons.UseCase;
import com.boot.up.gateways.config.controller.proxy.handlers.Operation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HandlerOperation implements Operation {
    @Override
    public OperationName getNameOperation() {
        return OperationName.handle;
    }

    @Override
    public Object invoke(UseCase useCase, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        return method.invoke(useCase,args);
    }
}
