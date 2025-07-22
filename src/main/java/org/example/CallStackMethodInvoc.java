package org.example;

/**
 * Demonstrates the behavior of the Java Virtual Machine call stack through
 * mutual recursive methods calls between methodA, methodB, and methodC.
 *
 * It demonstrates how method calls add frames to the call stack, how control passes
 * from one method to another, how the stack unwinds as methods return, and how recursion
 * uses the stack to track state across calls.
 *
 * Under the hood, each time a method is called, the JVM creates a new 'stack frame' that stores
 * the methods params, local vars, and return address. These frames are pushed onto the call stack in
 * order of invocation. When a method returns, its frame is popped off the stack, and control returns
 * to the caller with the previous frame on top. This process continues until the initial method completes.
 */
public class CallStackMethodInvoc {

    public static void methodA(int n) {
        System.out.println("Enter methodA with n = " + n);
        if (n > 0) {
            methodB(n - 1);
        }
        System.out.println("Exit methodA with n = " + n);
    }

    public static void methodB(int n) {
        System.out.println("Enter methodB with n = " + n);
        if (n > 0) {
            methodC(n - 1);
        }
        System.out.println("Exit methodB with n = " + n);
    }

    public static void methodC(int n) {
        System.out.println("Enter methodC with n = " + n);
        if (n > 0) {
            methodA(n - 1);
        }
        System.out.println("Exit methodC with n = " + n);
    }









}
