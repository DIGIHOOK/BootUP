package com.boot.up.gateways.config.controller.proxy;

import com.boot.up.core.domain.OperationName;
import com.boot.up.core.domain.commons.UseCase;
import com.boot.up.gateways.BootUpAppBeansFactory;
import com.boot.up.gateways.config.controller.proxy.handlers.*;
import com.boot.up.gateways.config.controller.proxy.handlers.supported.*;
import com.boot.up.gateways.inbound.BootUpAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@Slf4j
public class ProxyControllerConfig {


    @Bean
    public HandlerOperation handlerOperation(){
        return new HandlerOperation();
    }

    @Bean
    public HashCodeOperation hashCodeOperation(){
        return new HashCodeOperation();
    }

    @Bean
    public ToStringOperation toStringOperation(){
        return new ToStringOperation();
    }

    @Bean
    public EqualsOperation equalsOperation(){
        return new EqualsOperation();
    }

    @Bean
    public SupportOperation supportOperation(){
        return new SupportOperation();
    }



    @Bean
    public HandlersMap handlersMap(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BootUpAppBeansFactory.class);

        Map<String, UseCase> beans =context.getBeansOfType(UseCase.class);



        Map<Class<?>, HandlerInvoker> useCases = beans.values().stream()
                .collect(Collectors.
                        toMap(useCaseBean -> getHandlerInvokerIdentifier( useCaseBean ),
                                useCaseBean -> getHandlerInvoker( useCaseBean )));
        return new HandlersMap(useCases);
    }

    private   Class<?> getHandlerInvokerIdentifier( UseCase useCaseBean ){
        log.info("getHandlerInvokerIdentifier for {} ...",useCaseBean.getClass());
        Class handlerIdentifier = Arrays.asList(useCaseBean.getClass().getMethods()).stream().filter(method ->
                method.getName().equals(OperationName.handle.name())
        ).findFirst().get().getParameterTypes()[0];
        log.info("getHandlerInvokerIdentifier for {} ...",useCaseBean.getClass());
        return  handlerIdentifier;
    }

    private HandlerInvoker getHandlerInvoker( UseCase useCaseBean ){
        log.info("getHandlerInvoker for {} ...",useCaseBean.getClass());
        Method handlerInvokerMethod =  Arrays.asList(useCaseBean.getClass().getMethods()).stream().filter(method ->
                method.getName().equals(OperationName.handle.name())
        ).findFirst().get();
        HandlerInvoker handlerInvoker = new HandlerInvoker(handlerInvokerMethod,useCaseBean);
        log.info("getHandlerInvoker for {} ...",useCaseBean.getClass());

        return handlerInvoker;
    }


    @Bean
    public ResourceInvocationHandler resourceInvocationHandler(List<Operation> operationsHandlerList, HandlersMap handlersMap){

        Map<OperationName, Operation> operationsHandlerMap = operationsHandlerList.stream().collect(Collectors.toMap(
                Operation::getNameOperation, Function.identity()
        ));

        return new ResourceInvocationHandler(operationsHandlerMap,handlersMap);
    }


    @Bean
    public BootUpAPI controllerProxy(ResourceInvocationHandler resourceInvocationHandler){
        return (BootUpAPI) Proxy.newProxyInstance(ProxyControllerConfig.class.getClassLoader(),new Class[] {BootUpAPI.class},resourceInvocationHandler);
    }


}
