package brendanddev.inheritance;


/**
 * The abstract class SmartDevice partially implements the Device interface.
 * It provides a base for smart devices, defining common properties and methods.
 * 
 * Abstract classes cannot be instantiated directly, and are meant to be extended by concrete
 * subclasses.
 * 
 * This class holds common state and behavor shared by all smart devices, such as device name and os,
 * and basic network connectivity methods.
 * 
 * It declares an abstract method runDiagnostics, which forces subclasses to provide their own
 * specific implementation for running diagnostics.
 */
public abstract class SmartDevice implements Device {

    /**
     * The name of the device.
     * Declared protected so subclasses can access it directly.
     */
    protected String deviceName;

    /**
     * The operating system of the device.
     */
    protected String os;

    /**
     * Constructor to initialize the device name and operating system.
     * 
     * @param deviceName The name of the device.
     * @param os The operating system of the device.
     */
    public SmartDevice(String deviceName, String os) {
        this.deviceName = deviceName;
        this.os = os;
    }

    public void connectToNetwork(String networkName) {
        System.out.println(deviceName + " is connecting to " + networkName);
    }

    public void disconnectFromNetwork() {
        System.out.println(deviceName + " is disconnecting from the network");
    }

    public abstract void runDiagnostics();
    
}
