package com.boot.up.core.domain.hero;

import com.boot.up.core.domain.commons.Query;

public interface GetHero extends Query {

    GetHeroOutput handle(GetHeroInput getHeroInput);
}
