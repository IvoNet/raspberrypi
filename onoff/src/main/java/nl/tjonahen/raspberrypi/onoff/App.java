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
package nl.tjonahen.raspberrypi.onoff;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Hello world!
 *
 */
public class App {
    public static final int PAUSE = 50;

    public static void main(final String[] args) throws InterruptedException {

        final App app = new App();
        app.sound();

    }
    private final GpioController gpio;
    private final GpioPinDigitalOutput led;

    private App() {
        gpio = GpioFactory.getInstance();

        led = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, // PIN NUMBER
                "My LED", // PIN FRIENDLY NAME (optional)
                PinState.LOW);      // PIN STARTUP STATE (optional) 

    }

    private void sound() throws InterruptedException {
        long start = System.currentTimeMillis();
        long stop = System.currentTimeMillis();
        
        while ((stop - start) < 1000) {
            led.setState(PinState.HIGH);
            Thread.sleep(PAUSE);
            led.setState(PinState.LOW);
            Thread.sleep(PAUSE);
        } 
        
    }

}
