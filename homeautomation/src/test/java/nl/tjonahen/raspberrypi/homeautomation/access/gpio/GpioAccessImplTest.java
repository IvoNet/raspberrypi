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
package nl.tjonahen.raspberrypi.homeautomation.access.gpio;

import java.util.Collection;
import nl.tjonahen.raspberrypi.homeautomation.access.IGpioDevice;
import nl.tjonahen.raspberrypi.homeautomation.access.my.MyGpioController;
import nl.tjonahen.raspberrypi.homeautomation.access.my.MyPiConfig;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
@Ignore
public class GpioAccessImplTest {

    /**
     * Test of getDevices method, of class GpioAccess.
     */
    @Test
    public void testGetDevices() {
        MyGpioController gpio = new MyGpioController();
        GpioAccess instance = new GpioAccess(MyPiConfig.getInstance().getDevices());
        Collection<IGpioDevice> result = instance.getDevices();
        assertEquals(4, result.size());
    }

    /**
     * Test of getDevice method, of class GpioAccess.
     */
    @Test
    public void testGetDevice() {
        String name = "Red-LED";
        MyGpioController gpio = new MyGpioController();
        GpioAccess instance = new GpioAccess(MyPiConfig.getInstance().getDevices());

        IGpioDevice result = instance.getDevice(name);
        assertEquals("Red-LED", result.getName());
        assertEquals("switch", result.getType());
        assertEquals("on", result.getValue());
    }

    /**
     * Test of doAction method, of class GpioAccess.
     */
    @Test
    public void testDoAction() {
        String name = "Red-LED";
        MyGpioController gpio = new MyGpioController();
        GpioAccess instance = new GpioAccess(MyPiConfig.getInstance().getDevices());
        IGpioDevice result = instance.getDevice(name);
        assertEquals("Red-LED", result.getName());
        assertEquals("switch", result.getType());
        assertEquals("on", result.getValue());

        instance.doAction(name, "toggle");
        
        result = instance.getDevice(name);
        assertEquals("Red-LED", result.getName());
        assertEquals("switch", result.getType());
        assertEquals("off", result.getValue());
        
    }
    
    
}