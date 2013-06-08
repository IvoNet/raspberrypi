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
package nl.tjonahen.homeautomation.ws;

import nl.tjonahen.homeautomation.access.gpio.GpioAccess;
import nl.tjonahen.homeautomation.access.my.MyPiConfig;
import nl.tjonahen.homeautomation.ws.model.DeviceCollection;
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
public class DeviceCollectionRecourceTest {
    public DeviceCollectionRecourceTest() {
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
     * Test of getDevices method, of class DeviceCollectionRecource.
     */
    @Test
    public void testGetDevices() {
        System.out.println("getDevices");
        
        DeviceCollectionRecource instance = new DeviceCollectionRecource(new GpioAccess(MyPiConfig.getInstance().getDevices()));
        DeviceCollection  result = instance.getDevices();
        assertEquals(4, result.getDevices().size());
        assertEquals("Green-LED", result.getDevices().get(0).getName());
    }
}