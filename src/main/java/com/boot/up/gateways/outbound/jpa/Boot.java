package com.boot.up.gateways.outbound.jpa;

import com.boot.up.core.domain.boot.BootUPInput;
import com.boot.up.core.domain.boot.BootUPOutput;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "boot")
@Data
public class Boot {
    @EmbeddedId
    String id;
    String message;

    Boot from(BootUPInput bootUPInput){
        Boot boot = new Boot();
        boot.setId(UUID.randomUUID().toString());
        boot.setMessage(message);
        return boot;

    }

    BootUPOutput toDomain(){
        BootUPOutput bootUPOutput = new BootUPOutput();
        bootUPOutput.setMessage(message);
        return bootUPOutput;
    }

}
