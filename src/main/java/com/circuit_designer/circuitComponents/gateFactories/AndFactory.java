package com.circuit_designer.circuitComponents.gateFactories;

import com.circuit_designer.circuitComponents.gates.And2;
import com.circuit_designer.circuitComponents.gates.TwoInputGate;

public class AndFactory extends GateFactory {

    @Override
    public TwoInputGate makeGate() {
        return new And2();
    }
    
}
