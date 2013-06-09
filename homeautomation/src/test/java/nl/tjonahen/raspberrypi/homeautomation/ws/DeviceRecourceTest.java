/*
 * Copyright (C) 2013 Philippe Tjon-A-Hen philippe@tjonahen.nl
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.tjonahen.raspberrypi.homeautomation.ws;

import nl.tjonahen.raspberrypi.homeautomation.access.gpio.GpioAccess;
import nl.tjonahen.raspberrypi.homeautomation.access.my.MyPiConfig;
import nl.tjonahen.raspberrypi.homeautomation.ws.model.Attributes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class DeviceRecourceTest {
    
    public DeviceRecourceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDevice method, of class DeviceRecource.
     */
    @Test
    public void testGetDevice() {
        String name = "Red-LED";
        
        DeviceRecource instance = new DeviceRecource(new GpioAccess(MyPiConfig.getInstance().getDevices()));

        Attributes result = instance.getDevice(name);
        assertEquals("switch", result.getType());
        assertEquals("on", result.getValue());
    }
    @Test public void 
    test_GetUnknown_Device() {
        String name = "unknown";
        DeviceRecource instance = new DeviceRecource(new GpioAccess(MyPiConfig.getInstance().getDevices()));

        assertNull(instance.getDevice(name));
    }

//    /**
//     * Test of postDevice method, of class DeviceRecource.
//     */
//    @Test
//    public void testPostDevice() {
//        String name = "led01";
//        Action action = new Action();
//        action.setAction("toggle");
//        DeviceRecource instance = new DeviceRecource();
//        assertNotNull(instance.postDevice(name, action));
//        Attributes result = instance.getDevice(name);
//        assertEquals("on", result.getValue());
//        
//    }
}