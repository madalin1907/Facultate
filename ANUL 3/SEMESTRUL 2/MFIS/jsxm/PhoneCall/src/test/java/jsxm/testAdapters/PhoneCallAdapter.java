package jsxm.testAdapters;

import org.jsxm.examples.Phone.PhoneCall;

public class PhoneCallAdapter {

    PhoneCall phoneCall = new PhoneCall();

    public String openPhone() {
        try {
            phoneCall.openPhone();
            return "openPhoneOut";
        } catch (Exception e) {
            return "openPhone_Error";
        }
    }
    
    public String closePhone() {
        try {
            phoneCall.closePhone();
            return "closePhoneOut";
        } catch (Exception e) {
            return "closePhone_Error";
        }
    }
    
    public String startCall() {
        try {
            phoneCall.startCall();
            return "startCallOut";
        } catch (Exception e) {
            return "startCall_Error";
        }
    }

    public String endCall() {
        try {
            phoneCall.endCall();
            return "endCallOut";
        } catch (Exception e) {
            return "endCall_Error";
        }
    }

    public String holdCall() {
        try {
            phoneCall.holdCall();
            return "holdCallOut";
        } catch (Exception e) {
            return "holdCall_Error";
        }
    }

    public String resumeCall() {
        try {
            phoneCall.resumeCall();
            return "resumeCallOut";
        } catch (Exception e) {
            return "resumeCall_Error";
        }
    }
}
