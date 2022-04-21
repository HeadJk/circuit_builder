package com.circuit_designer.circuitStructure;

import org.junit.jupiter.api.Test;

import com.circuit_designer.circuitStructure.deviceStructure.DeviceConnector;
import com.circuit_designer.circuitStructure.deviceStructure.DeviceConnectorI;
import com.circuit_designer.cirucitFactory.AndFactory;
import com.circuit_designer.cirucitFactory.DeviceFactoryI;
import com.circuit_designer.cirucitFactory.GroundFactory;
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

        try {
            deviceConnector.connectComponents(source1, andGate);
            Assertions.assertEquals(Signal.UNKNOWN, andGate.getOutputSignal(0));
    
            deviceConnector.connectComponents(source2, andGate);
            Assertions.assertEquals(Signal.HIGH, andGate.getOutputSignal(0));
        } catch (Exception e) {}
    }

    @Test void connectMultipleDevices() {
        DeviceFactoryI andFactory = new AndFactory();
        DeviceFactoryI sourceFactory = new SourceFactory();
        DeviceFactoryI groundFactory = new GroundFactory();
        DeviceI andGate1 = andFactory.makeComponent();
        DeviceI andGate2 = andFactory.makeComponentWithOutputs();
        DeviceI ground1 = groundFactory.makeComponent();
        DeviceI source1 = sourceFactory.makeComponent();
        DeviceI source2 = sourceFactory.makeComponent();

        DeviceConnectorI deviceConnector = new DeviceConnector();


        try {
            deviceConnector.connectComponents(andGate1, andGate2);
            Assertions.assertEquals(Signal.UNKNOWN, andGate1.getOutputSignal(0));
            Assertions.assertEquals(Signal.UNKNOWN, andGate2.getOutputSignal(0));
    
            deviceConnector.connectComponents(source1, andGate1);
            Assertions.assertEquals(Signal.UNKNOWN, andGate1.getOutputSignal(0));
            Assertions.assertEquals(Signal.UNKNOWN, andGate2.getOutputSignal(0));
    
            deviceConnector.connectComponents(source2, andGate1);
            Assertions.assertEquals(Signal.HIGH, andGate1.getOutputSignal(0));
            Assertions.assertEquals(Signal.UNKNOWN, andGate2.getOutputSignal(0));
    
            deviceConnector.connectComponents(ground1, andGate2);
            Assertions.assertEquals(Signal.HIGH, andGate1.getOutputSignal(0));
            Assertions.assertEquals(Signal.LOW, andGate2.getOutputSignal(0));
    
            boolean enteredCatch = false;
            try {
                // Fails because and gates input is already occupied
                deviceConnector.connectComponents(ground1, andGate1);
            } catch(Exception e) {
                enteredCatch = true;
            }
            Assertions.assertEquals(Signal.HIGH, andGate1.getOutputSignal(0));
            Assertions.assertEquals(Signal.LOW, andGate2.getOutputSignal(0));
            Assertions.assertTrue(enteredCatch);
    
            enteredCatch = false;
            try {
                // Fails because and gates input is already occupied
                deviceConnector.connectComponents(ground1, 0, andGate1, 1);
            } catch (Exception e) {
                enteredCatch = true;
            }
            Assertions.assertEquals(Signal.HIGH, andGate1.getOutputSignal(0));
            Assertions.assertEquals(Signal.LOW, andGate2.getOutputSignal(0));
            Assertions.assertTrue(enteredCatch);
            
            andGate1.disconnectInputBus(1);
            deviceConnector.connectComponents(ground1, andGate1);
            Assertions.assertEquals(Signal.LOW, andGate1.getOutputSignal(0));
            Assertions.assertEquals(Signal.LOW, andGate2.getOutputSignal(0));
        } catch (Exception e) {}

    }
}
