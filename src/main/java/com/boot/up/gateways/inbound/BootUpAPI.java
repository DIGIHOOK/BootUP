package com.boot.up.gateways.inbound;


import com.boot.up.core.domain.boot.BootUP;
import com.boot.up.core.domain.boot.BootUPOutput;
import com.boot.up.core.domain.hello.GetHello;
import com.boot.up.core.domain.hello.HelloInput;
import com.boot.up.core.domain.hello.HelloOutput;
import com.boot.up.core.domain.hero.GetHero;
import com.boot.up.core.domain.hero.GetHeroInput;
import com.boot.up.core.domain.hero.GetHeroOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BootUpAPI extends GetHello , GetHero , BootUP {


    @GetMapping(value = "/hello")
    HelloOutput handle(HelloInput helloInput);

    @GetMapping(value = "/hero")
    GetHeroOutput handle(GetHeroInput getHeroInput);

    BootUPOutput handle(BootUPOutput bootUPOutput);



}
