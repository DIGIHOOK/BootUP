package com.boot.up.gateways;

import com.boot.up.core.domain.hello.GetHello;
import com.boot.up.core.domain.hero.GetHero;
import com.boot.up.core.usecase.GetHelloImpl;
import com.boot.up.core.usecase.GetHeroImpl;
import com.boot.up.gateways.inbound.HelloAPIImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootUpAppBeansFactory {

    @Bean
    public GetHello getHello(){
        return new GetHelloImpl();
    }

    @Bean
    public GetHero getHero(){
        return new GetHeroImpl();
    }


    /*
    @Bean
    public HelloAPIImpl HelloAPIImpl(GetHello hello){
        return new HelloAPIImpl(hello);
    }

     */



}
