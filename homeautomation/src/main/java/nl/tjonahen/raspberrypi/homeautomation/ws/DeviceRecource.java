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

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nl.tjonahen.raspberrypi.homeautomation.access.GpioAccessFactory;
import nl.tjonahen.raspberrypi.homeautomation.access.IGpioDevice;
import nl.tjonahen.raspberrypi.homeautomation.access.gpio.GpioAccess;
import nl.tjonahen.raspberrypi.homeautomation.ws.model.Action;
import nl.tjonahen.raspberrypi.homeautomation.ws.model.Attributes;

/**
 * REST Web Service. Gets the device information of a named device
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
@Path("/{name}")
public class DeviceRecource {

    @Context
    private UriInfo context;
    
    private final GpioAccess gpioAccess;

    /**
     * Creates a new instance of DeviceRecource
     */
    public DeviceRecource() {
        gpioAccess = GpioAccessFactory.create();
    }

    public DeviceRecource(GpioAccess gpioAccess) {
        this.gpioAccess = gpioAccess;
    }

    /**
     * Retrieves representation of an instance of nl.tjonahen.homeautomation.DeviceRecource
     *
     * @return a device
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Attributes getDevice(@PathParam("name") final String name) {
        System.out.println("Handling device status" + name);
        IGpioDevice pinDevice = gpioAccess.getDevice(name);
        if (pinDevice != null) {
            final Attributes status = new Attributes();
            status.setType(pinDevice.getType());
            status.setValue(pinDevice.getValue());

            return status;
        }
        return null;
    }

    /**
     * Performs an action on a device
     *
     * @param name -
     * @param action -
     * @return -
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response postDevice(@PathParam("name") final String name, final Action action) {

        System.out.println("handling post " + name + ":" + action.getAction());
        gpioAccess.doAction(name, action.getAction());

        return Response.status(Response.Status.OK).build();
    }
}
