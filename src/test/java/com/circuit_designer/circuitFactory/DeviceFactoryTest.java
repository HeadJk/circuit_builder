package com.circuit_designer.circuitFactory;

import org.junit.jupiter.api.Test;

import com.circuit_designer.circuitStructure.DeviceI;
import com.circuit_designer.cirucitFactory.AndFactory;
import com.circuit_designer.cirucitFactory.DeviceFactory;

import org.junit.jupiter.api.Assertions;

public class DeviceFactoryTest {
    
    @Test
    public void createDevice() {
        DeviceFactory d = new AndFactory();
        DeviceI andGate = d.makeComponent();
        DeviceI andGateWithOutputs = d.makeComponentWithOutputs();

        Assertions.assertEquals(andGate.getOutputBus(0), null);

        Assertions.assertNotEquals(andGateWithOutputs.getOutputBus(0), null);
    }

}
