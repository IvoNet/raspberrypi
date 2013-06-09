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
import java.util.Map;
import nl.tjonahen.raspberrypi.homeautomation.access.IGpioDevice;
import nl.tjonahen.raspberrypi.homeautomation.access.OutputDevice;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class GpioAccess {
 
    private final Map<String, IGpioDevice> devices;

    public GpioAccess(final Map<String, IGpioDevice> devices) {
        this.devices = devices;
    }

    public Collection<IGpioDevice> getDevices() {
        return devices.values();
    }

    public IGpioDevice getDevice(final String name) {
        if (devices.containsKey(name)) {
            return devices.get(name);
        }
        return null;
    }

    public void doAction(final String name, final String action) {
        System.out.println("perform " + action + " on " + name);
        if (devices.containsKey(name)) {
            final IGpioDevice device = devices.get(name);
            if ("toggle".equals(action) && device instanceof OutputDevice) {
                ((OutputDevice)device).toggle();
            }
        }
    }
}
