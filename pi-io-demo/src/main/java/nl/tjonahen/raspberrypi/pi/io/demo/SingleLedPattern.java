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
package nl.tjonahen.raspberrypi.pi.io.demo;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class SingleLedPattern extends LedPattern {

    private final int ledNumber;

    public SingleLedPattern(final GpioPinDigitalOutput[] led, final int ledNumber) {
        super(led);
        this.ledNumber = ledNumber;
    }

    @Override
    void execute() {
        try {
            led[ledNumber].setState(PinState.HIGH);
            Thread.sleep(200);
            led[ledNumber].setState(PinState.LOW);
        } catch (InterruptedException ex) {
            ;
        }
    }
}
