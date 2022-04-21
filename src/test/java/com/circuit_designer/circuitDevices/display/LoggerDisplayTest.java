package com.circuit_designer.circuitDevices.display;

import org.junit.jupiter.api.Test;

import com.circuit_designer.circuitStructure.DeviceI;
import com.circuit_designer.circuitStructure.Signal;
import com.circuit_designer.circuitStructure.deviceStructure.DeviceConnector;
import com.circuit_designer.circuitStructure.deviceStructure.DeviceConnectorI;
import com.circuit_designer.cirucitFactory.AndFactory;
import com.circuit_designer.cirucitFactory.DeviceFactoryI;
import com.circuit_designer.cirucitFactory.LoggerDisplayFactory;
import com.circuit_designer.cirucitFactory.SourceFactory;

import org.junit.jupiter.api.Assertions;

public class LoggerDisplayTest {
    
    @Test
    public void displayTest() {
        DeviceFactoryI andFactory = new AndFactory();
        DeviceFactoryI sourceFactory = new SourceFactory();
        DeviceFactoryI loggerFactory = new LoggerDisplayFactory();
        DeviceI logger = loggerFactory.makeComponent();
        DeviceI andGate = andFactory.makeComponent();
        DeviceI source1 = sourceFactory.makeComponent();
        DeviceI source2 = sourceFactory.makeComponent();

        DeviceConnectorI deviceConnector = new DeviceConnector();

        deviceConnector.connectComponents(andGate, logger);
        deviceConnector.connectComponents(source1, andGate);
        deviceConnector.connectComponents(source2, andGate);
    }

}
