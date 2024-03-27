package org.acme.sao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class GreetingServiceTest {

    private GreetingService service;

    @BeforeEach
    public void init() {
        service = new GreetingService();
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testGreeting(final String name) {
        Assertions.assertEquals("hello " + name, service.greeting(name));
    }
}
