package nl.tjonahen.raspberrypi.pi.io.demo;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Pi io demo application using pi4j and wiring pi.
 *
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        final App app = new App();
        app.start();
    }
    
    private final GpioController gpio;
    private final GpioPinDigitalOutput led[];
    private final GpioPinDigitalInput button;
    private final BlockingQueue<LedPattern> ledQueue;

    private App() {
        
        gpio = GpioFactory.getInstance();
        
        led = new GpioPinDigitalOutput[11];
        ledQueue = new LinkedBlockingQueue<LedPattern>();
        
        int number = 0;

        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);
        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW);
        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW);
        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);
        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.LOW);
        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, PinState.LOW);

        
        button = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07,
                PinPullResistance.PULL_UP);
        
        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, PinState.LOW);
        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, PinState.LOW);
        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, PinState.LOW);
        led[number++] = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20, PinState.LOW);

    }

    public void start() throws InterruptedException {

        final LedPatternWorkerThread ledPatternWorkerThread = new LedPatternWorkerThread(ledQueue);
        new Thread(ledPatternWorkerThread).start();
        final List<LedPattern> ledPattern = new LinkedList<LedPattern>();

        ledPattern.add(new CyclonLedPattern(led));
        ledPattern.add(new CountLedPattern(led));
        ledPattern.add(new ProgressLedPattern(led));
        
        for (int i = 0; i < led.length; i++) {
            ledPattern.add(new SingleLedPattern(led, i));
        }
        
        button.addListener(new GpioPinListenerDigital() {
            private int count = 0;
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if (PinState.HIGH == event.getState()) {
                    ledQueue.add(ledPattern.get(count++));
                    if (count > ledPattern.size()-1) {
                        count = 0;
                    }
                }
            }
        });

        // loop for-ever (break with ctrl-c)
        for (;;) {
            Thread.sleep(500);
        }
    }
}
