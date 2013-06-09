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
package nl.tjonahen.raspberrypi.homeautomation.access;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class PiConfig {

    private static PiConfig _instance = null;

    public static synchronized PiConfig getInstance() {
        if (_instance == null) {
            _instance = new PiConfig();
        }
        return _instance;
    }
    private final Map<String, IGpioDevice> devices;

    private PiConfig() {

        final GpioController gpio = GpioFactory.getInstance();
        this.devices = new HashMap<String, IGpioDevice>();


        final GpioPinDigitalOutput leds[] = {
            gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, // PIN NUMBER
                                            "PINK", // PIN FRIENDLY NAME (optional)
                                            PinState.LOW),// PIN STARTUP STATE (optional) 
            gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, // PIN NUMBER
                                            "CL_YELLOW", // PIN FRIENDLY NAME (optional)
                                            PinState.LOW),// PIN STARTUP STATE (optional) 
            gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, // PIN NUMBER
                                            "WHITE", // PIN FRIENDLY NAME (optional)
                                            PinState.LOW),// PIN STARTUP STATE (optional) 

            gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, // PIN NUMBER
                                            "ROOD", // PIN FRIENDLY NAME (optional)
                                            PinState.LOW),// PIN STARTUP STATE (optional) 
            gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, // PIN NUMBER
                                            "ORANJE", // PIN FRIENDLY NAME (optional)
                                            PinState.LOW),// PIN STARTUP STATE (optional) 
            gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, // PIN NUMBER
                                            "GROEN1", // PIN FRIENDLY NAME (optional)
                                            PinState.LOW),// PIN STARTUP STATE (optional) 
            gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, // PIN NUMBER
                                            "GROEN2", // PIN FRIENDLY NAME (optional)
                                            PinState.LOW),// PIN STARTUP STATE (optional) 
            gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, // PIN NUMBER
                                            "GROEN3", // PIN FRIENDLY NAME (optional)
                                            PinState.LOW),// PIN STARTUP STATE (optional) 
        };
        
        for (final GpioPinDigitalOutput led: leds ) {
            this.devices.put(led.getName(), new OutputDevice(led));
        }
    }

    public Map<String, IGpioDevice> getDevices() {
        return devices;
    }
}
