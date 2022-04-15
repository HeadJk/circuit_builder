package com.circuit_designer;

import com.circuit_designer.circuitComponents.gateFactories.AndFactory;
import com.circuit_designer.circuitComponents.gateFactories.GateFactory;
import com.circuit_designer.circuitComponents.gates.TwoInputGate;
import com.circuit_designer.circuitStructure.Bit;
import com.circuit_designer.circuitStructure.Bus;
import com.circuit_designer.circuitStructure.BusInterface;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class GateTest {
    
    @Test
    public void gateTest() {
        GateFactory andFactory = new AndFactory();
        TwoInputGate andGate = andFactory.makeGate();
        BusInterface in1 = new Bus();
        BusInterface in2 = new Bus();
        BusInterface output = new Bus();
        andGate.connectInputBus(0, in1);
        andGate.connectInputBus(1, in2);
        andGate.connectOutputBus(0, output);

        Assertions.assertEquals(output.getSignal(), Bit.UNKNOWN);

        in1.setSignal(Bit.HIGH);
        Assertions.assertEquals(output.getSignal(), Bit.UNKNOWN);

        in2.setSignal(Bit.HIGH);
        Assertions.assertEquals(output.getSignal(), Bit.HIGH);

        in1.setSignal(Bit.LOW);
        Assertions.assertEquals(output.getSignal(), Bit.LOW);

        in2.setSignal(Bit.UNKNOWN);
        Assertions.assertEquals(output.getSignal(), Bit.LOW);
        
    }

}
