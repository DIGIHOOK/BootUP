package com.boot.up.gateways.inbound;

import com.boot.up.core.domain.hello.GetHello;
import com.boot.up.core.domain.hello.HelloInput;
import com.boot.up.core.domain.hello.HelloOutput;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

@AllArgsConstructor
@Slf4j
public class HelloAPIImpl /*implements BootUpAPI*/ {


    private GetHello Hello;

    //@Override
    public HelloOutput handle(HelloInput helloInput) {
        log.info("HelloAPIImpl ...");
        HelloOutput helloOutput = Hello.handle(helloInput);
        log.info("HelloAPIImpl DONE");
        return helloOutput;
    }
}
