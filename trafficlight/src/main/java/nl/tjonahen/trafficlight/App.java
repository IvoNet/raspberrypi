package nl.tjonahen.trafficlight;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        App app = new App();
        
        for (int i = 0; i < 10; i++) 
            app.cycle();
    }
    final GpioController gpio;
    final GpioPinDigitalOutput red;
    final GpioPinDigitalOutput orange;
    final GpioPinDigitalOutput green;

    private App() {
        gpio = GpioFactory.getInstance();

        red = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, // PIN NUMBER
                "RED-LED", // PIN FRIENDLY NAME (optional)
                PinState.HIGH);      // PIN STARTUP STATE (optional) 
        orange = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, // PIN NUMBER
                "ORANGE-LED", // PIN FRIENDLY NAME (optional)
                PinState.LOW);      // PIN STARTUP STATE (optional) 
        green = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, // PIN NUMBER
                "GREEN-LED", // PIN FRIENDLY NAME (optional)
                PinState.LOW);      // PIN STARTUP STATE (optional) 

    }
    
    public void cycle() throws InterruptedException {
        
        red.setState(PinState.LOW);
        green.setState(PinState.HIGH);
        
        Thread.sleep(500);
        
        green.setState(PinState.LOW);
        orange.setState(PinState.HIGH);
        
        Thread.sleep(100);
        
        orange.setState(PinState.LOW);
        red.setState(PinState.HIGH);
        
        Thread.sleep(500);
    }
    
    
}
