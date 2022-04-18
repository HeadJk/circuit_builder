package com.circuit_designer.circuitStructure;

import org.junit.jupiter.api.Test;

import com.circuit_designer.cirucitFactory.*;

import org.junit.jupiter.api.Assertions;

public class DeviceTest {

    @Test
    public void busConnection() {
        DeviceFactory df = new AndFactory();
        DeviceI andGate = df.makeComponent();

        Bus a = new Bus();
        Bus b = new Bus();
        Bus c = new Bus();

        andGate.connectInputBus(0, a);
        Assertions.assertEquals(andGate.getInputBus(0), a);
        Assertions.assertEquals(andGate.getInputBus(1), null);
        Assertions.assertEquals(andGate.getOutputBus(0), null);

        andGate.connectInputBus(1, b);
        Assertions.assertEquals(andGate.getInputBus(0), a);
        Assertions.assertEquals(andGate.getInputBus(1), b);
        Assertions.assertEquals(andGate.getOutputBus(0), null);

        andGate.connectOutputBus(0, c);
        Assertions.assertEquals(andGate.getInputBus(0), a);
        Assertions.assertEquals(andGate.getInputBus(1), b);
        Assertions.assertEquals(andGate.getOutputBus(0), c);
        
        andGate.disconnectInputBus(1);
        Assertions.assertEquals(andGate.getInputBus(0), a);
        Assertions.assertEquals(andGate.getInputBus(1), null);
        Assertions.assertEquals(andGate.getOutputBus(0), c);

        andGate.connectInputBus(1, a);
        Assertions.assertEquals(andGate.getInputBus(0), a);
        Assertions.assertEquals(andGate.getInputBus(1), a);
        Assertions.assertEquals(andGate.getOutputBus(0), c);

        andGate.disconnectOutputBus(0);
        Assertions.assertEquals(andGate.getInputBus(0), a);
        Assertions.assertEquals(andGate.getInputBus(1), a);
        Assertions.assertEquals(andGate.getOutputBus(0), null);

        andGate.connectOutputBus(0, b);
        Assertions.assertEquals(andGate.getInputBus(0), a);
        Assertions.assertEquals(andGate.getInputBus(1), a);
        Assertions.assertEquals(andGate.getOutputBus(0), b);

        andGate.disconnectAllPorts();
        Assertions.assertEquals(andGate.getInputBus(0), null);
        Assertions.assertEquals(andGate.getInputBus(1), null);
        Assertions.assertEquals(andGate.getOutputBus(0), null);

        andGate.disconnectAllPorts();
        Assertions.assertEquals(andGate.getInputBus(0), null);
        Assertions.assertEquals(andGate.getInputBus(1), null);
        Assertions.assertEquals(andGate.getOutputBus(0), null);

    }

    @Test
    public void signalTransmission() {
        DeviceFactory andF = new AndFactory();
        DeviceFactory groundF = new GroundFactory();
        DeviceFactory sourceF = new SourceFactory();

        DeviceI andGate = andF.makeComponentWithOutputs();
        DeviceI ground = groundF.makeComponentWithOutputs();
        DeviceI source = sourceF.makeComponentWithOutputs();

        Assertions.assertEquals(andGate.getOutputBus(0).getSignal(), Signal.UNKNOWN);
        Assertions.assertEquals(ground.getOutputBus(0).getSignal(), Signal.LOW);
        Assertions.assertEquals(source.getOutputBus(0).getSignal(), Signal.HIGH);

        andGate.connectInputBus(0, ground.getOutputBus(0));
        Assertions.assertEquals(andGate.getOutputBus(0).getSignal(), Signal.LOW);

        andGate.disconnectInputBus(0);
        Assertions.assertEquals(andGate.getOutputBus(0).getSignal(), Signal.UNKNOWN);

        andGate.connectInputBus(0, source.getOutputBus(0));
        Assertions.assertEquals(andGate.getOutputBus(0).getSignal(), Signal.UNKNOWN);

        andGate.connectInputBus(1, source.getOutputBus(0));
        Assertions.assertEquals(andGate.getOutputBus(0).getSignal(), Signal.HIGH);
        
    }
    
}
