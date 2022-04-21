package com.circuit_designer.circuitStructure;

import org.junit.jupiter.api.Test;

import com.circuit_designer.circuitStructure.deviceStructure.DeviceConnector;
import com.circuit_designer.circuitStructure.deviceStructure.DeviceConnectorI;
import com.circuit_designer.cirucitFactory.AndFactory;
import com.circuit_designer.cirucitFactory.DeviceFactoryI;
import com.circuit_designer.cirucitFactory.SourceFactory;

import org.junit.jupiter.api.Assertions;

public class DeviceConnectorTest {
    @Test
    public void connectDevices() {
        DeviceFactoryI andFactory = new AndFactory();
        DeviceFactoryI sourceFactory = new SourceFactory();
        DeviceI andGate = andFactory.makeComponentWithOutputs();
        DeviceI source1 = sourceFactory.makeComponent();
        DeviceI source2 = sourceFactory.makeComponent();

        DeviceConnectorI deviceConnector = new DeviceConnector();

        deviceConnector.connectComponents(source1, andGate);
        Assertions.assertEquals(Signal.UNKNOWN, andGate.getOutputSignal(0));

        deviceConnector.connectComponents(source2, andGate);
        Assertions.assertEquals(Signal.HIGH, andGate.getOutputSignal(0));
    }
}
