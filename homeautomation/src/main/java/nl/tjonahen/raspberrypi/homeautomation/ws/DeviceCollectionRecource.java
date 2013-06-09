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

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nl.tjonahen.raspberrypi.homeautomation.access.GpioAccessFactory;
import nl.tjonahen.raspberrypi.homeautomation.access.IGpioDevice;
import nl.tjonahen.raspberrypi.homeautomation.access.gpio.GpioAccess;
import nl.tjonahen.raspberrypi.homeautomation.ws.model.Device;
import nl.tjonahen.raspberrypi.homeautomation.ws.model.DeviceCollection;

/**
 * REST Web Service
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
@Path("/")
public class DeviceCollectionRecource {

    @Context
    private UriInfo context;

    private final GpioAccess gpioAccess;
    
    /**
     * Creates a new instance of DeviceCollectionRecource
     * 
     */
    public DeviceCollectionRecource() {
        this.gpioAccess = GpioAccessFactory.create();
    }

    /**
     * This should be autowired
     * @param gpioAccess  
     */
    public DeviceCollectionRecource(GpioAccess gpioAccess) {
        this.gpioAccess = gpioAccess;
    }
    
    /**
     * 
     * @return collection of all devices that are current present
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public DeviceCollection getDevices() {
        System.out.println("handling device request");
        final List<Device> deviceNames = new ArrayList<Device>();
        for (final IGpioDevice gpioDevice : gpioAccess.getDevices()) {
            final Device device = new Device();
            device.setName(gpioDevice.getName());
            device.setType(gpioDevice.getType());
            device.setValue(gpioDevice.getValue());
            
            deviceNames.add(device);
        }
        return new DeviceCollection(deviceNames);
    }

}
