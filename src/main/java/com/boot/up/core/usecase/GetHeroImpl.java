package com.boot.up.core.usecase;

import com.boot.up.core.domain.hero.GetHero;
import com.boot.up.core.domain.hero.GetHeroInput;
import com.boot.up.core.domain.hero.GetHeroOutput;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetHeroImpl implements GetHero {
    @Override
    public GetHeroOutput handle(GetHeroInput getHeroInput) {
       log.info("GetHeroImpl ...");
        GetHeroOutput getHeroOutput=  new GetHeroOutput("hero");;
       log.info("GetHeroImpl Done");
        return getHeroOutput;
    }
}
