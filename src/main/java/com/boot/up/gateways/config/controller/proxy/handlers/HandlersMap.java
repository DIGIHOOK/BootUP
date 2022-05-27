package com.boot.up.gateways.config.controller.proxy.handlers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HandlersMap {

    private Map<Class<?>, HandlerInvoker> HandlersMap;
}
