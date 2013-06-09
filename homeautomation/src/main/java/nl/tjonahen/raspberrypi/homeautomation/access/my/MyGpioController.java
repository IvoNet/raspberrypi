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
package nl.tjonahen.raspberrypi.homeautomation.access.my;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinAnalog;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.GpioPinAnalogOutput;
import com.pi4j.io.gpio.GpioPinDigital;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalMultipurpose;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinInput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.GpioPinShutdown;
import com.pi4j.io.gpio.GpioProvider;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.trigger.GpioTrigger;
import java.util.Collection;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class MyGpioController implements GpioController {

    @Override
    public void export(PinMode pm, GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isExported(GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unexport(GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unexportAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMode(PinMode pm, GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PinMode getMode(GpioPin gp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isMode(PinMode pm, GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPullResistance(PinPullResistance ppr, GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PinPullResistance getPullResistance(GpioPin gp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPullResistance(PinPullResistance ppr, GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void high(GpioPinDigitalOutput... gpdos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isHigh(GpioPinDigital... gpds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void low(GpioPinDigitalOutput... gpdos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLow(GpioPinDigital... gpds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(PinState ps, GpioPinDigitalOutput... gpdos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(boolean bln, GpioPinDigitalOutput... gpdos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isState(PinState ps, GpioPinDigital... gpds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PinState getState(GpioPinDigital gpd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void toggle(GpioPinDigitalOutput... gpdos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pulse(long l, GpioPinDigitalOutput... gpdos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValue(double d, GpioPinAnalogOutput... gpaos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getValue(GpioPinAnalog gpa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addListener(GpioPinListener gl, GpioPinInput... gpis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addListener(GpioPinListener[] gls, GpioPinInput... gpis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(GpioPinListener gl, GpioPinInput... gpis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(GpioPinListener[] gls, GpioPinInput... gpis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAllListeners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTrigger(GpioTrigger gt, GpioPinInput... gpis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTrigger(GpioTrigger[] gts, GpioPinInput... gpis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTrigger(GpioTrigger gt, GpioPinInput... gpis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTrigger(GpioTrigger[] gts, GpioPinInput... gpis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAllTriggers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(GpioProvider gp, Pin pin, String string, PinMode pm, PinPullResistance ppr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(GpioProvider gp, Pin pin, PinMode pm, PinPullResistance ppr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(GpioProvider gp, Pin pin, String string, PinMode pm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(GpioProvider gp, Pin pin, PinMode pm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(Pin pin, String string, PinMode pm, PinPullResistance ppr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(Pin pin, PinMode pm, PinPullResistance ppr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(Pin pin, String string, PinMode pm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(Pin pin, PinMode pm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalInput provisionDigitalInputPin(GpioProvider gp, Pin pin, String string, PinPullResistance ppr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalInput provisionDigitalInputPin(GpioProvider gp, Pin pin, PinPullResistance ppr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalInput provisionDigitalInputPin(GpioProvider gp, Pin pin, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalInput provisionDigitalInputPin(GpioProvider gp, Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalInput provisionDigitalInputPin(Pin pin, String string, PinPullResistance ppr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalInput provisionDigitalInputPin(Pin pin, PinPullResistance ppr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalInput provisionDigitalInputPin(Pin pin, String string) {
        return new MyGpioPinDigitalInput(pin, string);
    }

    @Override
    public GpioPinDigitalInput provisionDigitalInputPin(Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalOutput provisionDigitalOutputPin(GpioProvider gp, Pin pin, String string, PinState ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalOutput provisionDigitalOutputPin(GpioProvider gp, Pin pin, PinState ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalOutput provisionDigitalOutputPin(GpioProvider gp, Pin pin, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalOutput provisionDigitalOutputPin(GpioProvider gp, Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalOutput provisionDigitalOutputPin(Pin pin, String string, PinState ps) {
        return new MyGpioPinDigitalOutput(pin, string, ps);
    }

    @Override
    public GpioPinDigitalOutput provisionDigitalOutputPin(Pin pin, PinState ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalOutput provisionDigitalOutputPin(Pin pin, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinDigitalOutput provisionDigitalOutputPin(Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogInput provisionAnalogInputPin(GpioProvider gp, Pin pin, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogInput provisionAnalogInputPin(GpioProvider gp, Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogInput provisionAnalogInputPin(Pin pin, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogInput provisionAnalogInputPin(Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogOutput provisionAnalogOutputPin(GpioProvider gp, Pin pin, String string, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogOutput provisionAnalogOutputPin(GpioProvider gp, Pin pin, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogOutput provisionAnalogOutputPin(GpioProvider gp, Pin pin, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogOutput provisionAnalogOutputPin(GpioProvider gp, Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogOutput provisionAnalogOutputPin(Pin pin, String string, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogOutput provisionAnalogOutputPin(Pin pin, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogOutput provisionAnalogOutputPin(Pin pin, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinAnalogOutput provisionAnalogOutputPin(Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinPwmOutput provisionPwmOutputPin(GpioProvider gp, Pin pin, String string, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinPwmOutput provisionPwmOutputPin(GpioProvider gp, Pin pin, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinPwmOutput provisionPwmOutputPin(GpioProvider gp, Pin pin, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinPwmOutput provisionPwmOutputPin(GpioProvider gp, Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinPwmOutput provisionPwmOutputPin(Pin pin, String string, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinPwmOutput provisionPwmOutputPin(Pin pin, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinPwmOutput provisionPwmOutputPin(Pin pin, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPinPwmOutput provisionPwmOutputPin(Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPin provisionPin(GpioProvider gp, Pin pin, String string, PinMode pm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPin provisionPin(GpioProvider gp, Pin pin, PinMode pm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPin provisionPin(Pin pin, String string, PinMode pm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GpioPin provisionPin(Pin pin, PinMode pm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setShutdownOptions(GpioPinShutdown gps, GpioPin... gps1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setShutdownOptions(Boolean bln, GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setShutdownOptions(Boolean bln, PinState ps, GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setShutdownOptions(Boolean bln, PinState ps, PinPullResistance ppr, GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setShutdownOptions(Boolean bln, PinState ps, PinPullResistance ppr, PinMode pm, GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<GpioPin> getProvisionedPins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unprovisionPin(GpioPin... gps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isShutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
