package com.boot.up.core.usecase;

import com.boot.up.core.domain.hello.GetHello;
import com.boot.up.core.domain.hello.HelloInput;
import com.boot.up.core.domain.hello.HelloOutput;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Slf4j
public class GetHelloImpl implements GetHello {
    @Override
    public HelloOutput handle(HelloInput helloInput) {
       log.info("GetHelloImpl ...");
        HelloOutput helloOutput = new HelloOutput("boot up me !!");
        log.info("GetHelloImpl Done");
        return helloOutput;
    }
}
