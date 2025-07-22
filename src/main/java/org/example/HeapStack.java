package org.example;

import java.lang.ref.Cleaner;

/**
 * This class demonstrates Heap vs Stack memory and how the Cleaner API works to clean up
 * objects after they have become unreachable and eligible for garbage collection
 */
public class HeapStack {

    // Creates a shared instance of Cleaner
    private static final Cleaner cleaner = Cleaner.create();

    /**
     * Represents an object whose cleanup logic will run when it becomes unreachable.
     * This class registers itself with the Cleaner so that it can cleanup resources
     * after being garbage collected.
     */
    public static class MyObject {
        int value;

        // Cleanable holds the registered cleanup task for this object
        private final Cleaner.Cleanable cleanable;

        /**
         * Constructs an instance of MyObject
         * Initializes the value and registers the object for cleanup
         *
         * @param v The value assigned to the Object
         */
        MyObject(int v) {
            value = v;
            System.out.println("Object created with value: " + value);
            // Register this object with the Cleaner to run CleanupTask after its GC'd
            cleanable = cleaner.register(this, new CleanupTask(value));
        }

        /**
         * Manually triggers the cleanup - JVM normally handles this but shows that cleanup
         * can be done manually
         */
        public void destroy() {
            cleanable.clean();
        }
    }


    /**
     * A task that will run after the associated object is garbage collected.
     * It must implement Runnable so the Cleaner can execute it.
     */
    public static class CleanupTask implements Runnable {
        private final int value;

        CleanupTask(int val) {
            value = val;
        }

        @Override
        public void run() {
            // This will be called asynchronously after the object is GC'd
            System.out.println("MyObject with value: " + value + " is being cleaned by Cleaner");
        }
    }

    /**
     * This method creates a local object, whose reference is only available within this method.
     * The reference is on the stack, and the object itself is on the heap.
     * Once the method returns, the object becomes eligible for GC.
     */
    public static void method() {
        // obj reference lives on the stack
        // Local reference (stack), actual object (heap)
        MyObject obj = new MyObject(23);
        System.out.println("Inside method: Object value = " + obj.value);
        // obj goes out of scope after this method
    }

    /**
     * Calls the method, forces GC, and shows when the object is cleaned.
     * @param args unused.
     */
    public static void main(String[] args) {
        try {
            // After this call, obj is unreachable and eligible for GC
            method();

            // Suggest JVM to run GC (not guaranteed)
            System.out.println("Requesting garbage collection...");
            System.gc();

            // Allow time for Cleaner to run in background
            Thread.sleep(1000);
            System.out.println("End of Main method");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


}
