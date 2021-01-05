package com.acmebank.accountmanager.lifecycle;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class OnStart {


    @EventListener(ApplicationReadyEvent.class)
    private void initDbScript() {

    }
}
