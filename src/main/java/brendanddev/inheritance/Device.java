package brendanddev.inheritance;

/**
 * The Device interface defines the basic operations for a device.
 * It defines the contract that classes can implement, and specifies methods
 * that implementing classes must provide. The interface does not contain any 
 * implementation itself.
 */
public interface Device {

    /**
     * Turns the device on.
     * Implementing class will provide the actual functionality.
     */
    public void turnOn();

    /**
     * Turns the device off.
     * Implementing class will provide the actual functionality.
     */
    public void turnOff();
    
}
