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
package nl.tjonahen.homeautomation.access.my;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.util.HashMap;
import java.util.Map;
import nl.tjonahen.homeautomation.access.IGpioDevice;
import nl.tjonahen.homeautomation.access.InputDevice;
import nl.tjonahen.homeautomation.access.OutputDevice;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class MyPiConfig {
    private static MyPiConfig _instance = null;
    
    public static synchronized MyPiConfig getInstance() {
        if (_instance == null) {
            _instance = new MyPiConfig();
        }
        return _instance;
    }

    private final Map<String, IGpioDevice> devices;

    private MyPiConfig() {

        final GpioController gpio = new MyGpioController();
        
        this.devices = new HashMap<String, IGpioDevice>();


        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, // PIN NUMBER
                "Red-LED", // PIN FRIENDLY NAME (optional)
                PinState.HIGH);// PIN STARTUP STATE (optional) 
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, // PIN NUMBER
                "Orange-LED", // PIN FRIENDLY NAME (optional)
                PinState.LOW);// PIN STARTUP STATE (optional) 
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, // PIN NUMBER
                "Green-LED", // PIN FRIENDLY NAME (optional)
                PinState.LOW);// PIN STARTUP STATE (optional) 
        final GpioPinDigitalInput pin4 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00, "Input");

        this.devices.put(pin.getName(), new OutputDevice(pin));
        this.devices.put(pin2.getName(), new OutputDevice(pin2));
        this.devices.put(pin3.getName(), new OutputDevice(pin3));
        this.devices.put(pin4.getName(), new InputDevice(pin4));
    }

    public Map<String, IGpioDevice> getDevices() {
        return devices;
    }
}
