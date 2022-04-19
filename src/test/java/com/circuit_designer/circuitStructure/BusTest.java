package com.circuit_designer.circuitStructure;

import org.junit.jupiter.api.Test;

import com.circuit_designer.circuitStructure.busStructure.Bus;

import org.junit.jupiter.api.Assertions;

public class BusTest {

    @Test
    public void signalPropagation() {
        Bus b = new Bus();
        Assertions.assertEquals(Signal.UNKNOWN, b.getSignal());

        b.setSignal(Signal.HIGH);
        Assertions.assertEquals(Signal.HIGH, b.getSignal());

        b.setSignal(Signal.LOW);
        Assertions.assertEquals(Signal.LOW, b.getSignal());
    }

    @Test
    public void busAvailability() {
        Bus b = new Bus();
        Assertions.assertEquals(true, b.isAvailableInput());

        b.lockInputConnection();
        Assertions.assertEquals(false, b.isAvailableInput());

        b.unlockInputConnection();
        Assertions.assertEquals(true, b.isAvailableInput());
    }
    
}
