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
package nl.tjonahen.raspberrypi.dac;

import com.pi4j.wiringpi.Gertboard;
import java.io.IOException;

/**
 * Test DAC on gertboard
 *
 */
public class App {


    public static void main(String[] args) throws IOException {
        int fd = Gertboard.gertboardSPISetup();
        if (fd <= -1) {
            System.out.println(" ==>> Gertboard SPI SETUP FAILED");
            return;
        }
        Gertboard.gertboardAnalogWrite(0, 0);
        System.out.println("Your meter should read 0V");
        System.out.println("Hit enter to continue");
        System.in.read();
        
        Gertboard.gertboardAnalogWrite(0, 64);
        System.out.println("Your meter should read 0.5V");
        System.out.println("Hit enter to continue");
        System.in.read();
        
        Gertboard.gertboardAnalogWrite(0, 127);
        System.out.println("Your meter should read 1.02V");
        System.out.println("Hit enter to continue");
        System.in.read();
        
        Gertboard.gertboardAnalogWrite(0, 170);
        System.out.println("Your meter should read 1.36V");
        System.out.println("Hit enter to continue");
        System.in.read();

        Gertboard.gertboardAnalogWrite(0, 255);
        System.out.println("Your meter should read 2.04V");
        System.out.println("Hit enter to continue");
        System.in.read();
        
    }

    
}
