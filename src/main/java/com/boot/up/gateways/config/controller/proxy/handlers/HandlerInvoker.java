package com.boot.up.gateways.config.controller.proxy.handlers;

import com.boot.up.core.domain.commons.UseCase;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

@Data
@AllArgsConstructor
public class HandlerInvoker {

    Method method;
    UseCase useCaseObject;
}
