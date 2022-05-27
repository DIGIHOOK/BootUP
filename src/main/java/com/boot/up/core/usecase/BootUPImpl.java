package com.boot.up.core.usecase;

import com.boot.up.core.domain.boot.BootUP;
import com.boot.up.core.domain.boot.BootUPOutput;

public class BootUPImpl implements BootUP {
    @Override
    public BootUPOutput handle(BootUPOutput bootUPOutput) {
        return new BootUPOutput("boot up");
    }
}
