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
package nl.tjonahen.pi.io.demo;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class CountLedPattern extends LedPattern {

    public CountLedPattern(final GpioPinDigitalOutput[] led) {
        super(led);
    }

    @Override
    void execute() {
        try {
            setStates(false, false, true);
            Thread.sleep(200);
            setStates(false, true, false);
            Thread.sleep(200);
            setStates(false, true, true);
            Thread.sleep(200);
            setStates(true, false, false);
            Thread.sleep(200);
            setStates(true, false, true);
            Thread.sleep(200);
            setStates(true, true, false);
            Thread.sleep(200);
            setStates(true, true, true);
            Thread.sleep(200);
            setStates(false, false, false);
        } catch (InterruptedException e) {
            ;
        }
    }

    private void setStates(final boolean bit3, final boolean bit2, final boolean bit1) {
        led[2].setState(bit3);
        led[1].setState(bit2);
        led[0].setState(bit1);
    }
}
