package com.boot.up.core.domain.hello;

import com.boot.up.core.domain.commons.Query;

public interface GetHello  extends Query {

    HelloOutput handle(HelloInput helloInput);
}
