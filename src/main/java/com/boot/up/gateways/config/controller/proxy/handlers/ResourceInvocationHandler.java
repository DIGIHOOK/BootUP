package com.boot.up.gateways.config.controller.proxy.handlers;

import com.boot.up.core.domain.OperationName;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;


@AllArgsConstructor
@Slf4j
public class ResourceInvocationHandler  implements InvocationHandler {


    private Map<OperationName, Operation> operationsHandler;

    private HandlersMap handlersMap;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log.info("{} ResourceInvocationHandler ...",method.getName());
        Object returnObject=null;
        try {
            HandlerInvoker handlerInvoker  = getHandlerInvoker(method);
            if(handlerInvoker != null){
                returnObject=operationsHandler.get(OperationName.valueOf(method.getName()))
                        .invoke(handlerInvoker.getUseCaseObject(),handlerInvoker.getMethod(),args);
            }else{
                returnObject=operationsHandler.get(OperationName.valueOf(method.getName()))
                        .invoke(null,method,args);
            }
        }catch (IllegalArgumentException e){
            log.warn(" {} :method not supported",method.getName());
        }
        log.info("{} ResourceInvocationHandler ...",method.getName());

        return returnObject;
    }

    private HandlerInvoker getHandlerInvoker(Method method){

        HandlerInvoker handlerInvoker = null;
       if(method.getParameterTypes().length > 0) {
           handlerInvoker = handlersMap.getHandlersMap().get(method.getParameterTypes()[0]);
       }

        return handlerInvoker;
    }


}
