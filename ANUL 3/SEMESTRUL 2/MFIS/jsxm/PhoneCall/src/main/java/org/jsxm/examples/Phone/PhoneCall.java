package org.jsxm.examples.Phone;

public class PhoneCall {

    private boolean isActive = false; 
    private boolean isOnHold = false; 

    public void startCall() {
        if (!isActive) {
            isActive = true;
        } else {
            throw new IllegalStateException("Call is already active.");
        }
    }

    public void endCall() {
        if (isActive) {
            isActive = false;
            isOnHold = false;
        } else {
            throw new IllegalStateException("Cannot end call: no active call.");
        }
    }

    public void holdCall() {
        if (isActive && !isOnHold) {
            isOnHold = true;
        } else {
            throw new IllegalStateException("Cannot put call on hold: call is not active or already on hold.");
        }
    }

    public void resumeCall() {
        if (isOnHold) {
            isOnHold = false;
        } else {
            throw new IllegalStateException("Cannot resume call: call is not on hold.");
        }
    }
}
