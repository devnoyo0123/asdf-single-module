package com.yobs.singlemodulespringboot.messaging.inner;

import com.yobs.singlemodulespringboot.event.SignedUpEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class SignedUpEventListener {

    @TransactionalEventListener
    public void receive (SignedUpEvent event){
        log.info("event: {}",event);
    }
}
