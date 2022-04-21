package com.circuit_designer.circuitDevices.display;

import org.junit.jupiter.api.Test;

import com.circuit_designer.circuitStructure.DeviceI;
import com.circuit_designer.circuitStructure.deviceStructure.DeviceConnector;
import com.circuit_designer.circuitStructure.deviceStructure.DeviceConnectorI;
import com.circuit_designer.cirucitFactory.AndFactory;
import com.circuit_designer.cirucitFactory.DeviceFactoryI;
import com.circuit_designer.cirucitFactory.DisplayDeviceFactoryI;
import com.circuit_designer.cirucitFactory.LoggerDisplayFactory;
import com.circuit_designer.cirucitFactory.SourceFactory;

public class LoggerDisplayTest {
    
    @Test
    public void displayTest() {
        DeviceFactoryI andFactory = new AndFactory();
        DeviceFactoryI sourceFactory = new SourceFactory();
        DisplayDeviceFactoryI loggerFactory = new LoggerDisplayFactory();

        DeviceI logger = loggerFactory.makeComponent("Output1");
        DeviceI andGate = andFactory.makeComponent();
        DeviceI source1 = sourceFactory.makeComponent();
        DeviceI source2 = sourceFactory.makeComponent();

        DeviceConnectorI deviceConnector = new DeviceConnector();

        try {
            deviceConnector.connectComponents(andGate, logger);
            deviceConnector.connectComponents(source1, andGate);
            deviceConnector.connectComponents(source2, andGate);
        } catch (Exception e) {}
    }

}
