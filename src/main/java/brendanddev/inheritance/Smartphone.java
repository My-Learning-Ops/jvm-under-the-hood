package brendanddev.inheritance;

/**
 * Concrete class representing a Smartphone.
 * 
 * This class extends the abstract SmartDevice class,
 * so it inherits the protected variables 'deviceName' and 'os'.
 * 
 * Because these variables are declared as protectedt in SmartDevice,
 * Smartphone can directly access them in its methods.
 * 
 * The methods turnOn, turnOff, and runDiagnostics are abstract/interface methods
 * that must be overriden to provide concrete implementations specific to the Smartphone.
 */
public class Smartphone extends SmartDevice {

    /**
     * Constuctor calls the parent constructor to initialize the deviceName and os.
     * 
     * @param deviceName
     * @param os
     */
    public Smartphone(String deviceName, String os) {
        super(deviceName, os);
    }

    /**
     * Provides the implementation for turning on the smartphone.
     * Accesses the inherited protected variables 'deviceName' and 'os'
     */
    @Override
    public void turnOn() {
        System.out.println(deviceName + " is powering on with " + os);
    }

    /**
     * Provides the implementation for turning off the smartphone.
     * Accesses the inherited protected variable 'deviceName' and uses it in the output.
     */
    @Override
    public void turnOff() {
        System.out.println(deviceName + " is powering off");
    }

    /**
     * Provides the implementation for running diagnostics on the smartphone.
     * Accesses the inherited protected variable 'deviceName' and uses it in the output.
     */
    @Override
    public void runDiagnostics() {
        System.out.println("Running diagnostics on " + deviceName);
    }




    
}
