/** * JSXM CONFIDENTIAL*
*  __________________
Unpublished Copyright*
* © 2009-2013 Dimitris Dranidis, 
* All Rights Reserved.
*
* NOTICE:  All information contained herein is, and remains the property of Dimitris Dranidis .
*
* The intellectual and technical concepts contained herein are proprietary to the owner
* Dimitris Dranidis and may be covered by U.S and Foreign Patents, patents in process,
* and are protected by trade secret or copyright law. Dissemination of this information or
* reproduction of this material is strictly forbidden unless prior written permission is
* obtained from Dimitris Dranidis. Access to the source code contained herein is hereby
* forbidden to anyone except the owner.Confidentiality and Non-disclosure agreements 
* explicitly covering such access.


*The copyright notice above does not evidence any actual or intended publication 
* or disclosure  of  this source code, which includes information that is confidential 
* and/or proprietary, and is a trade secret, of  Dimitris Dranidis. ANY REPRODUCTION, 
* MODIFICATION, DISTRIBUTION, PUBLIC  PERFORMANCE, OR PUBLIC DISPLAY OF OR THROUGH USE  OF 
* THIS  SOURCE CODE  WITHOUT  THE EXPRESS WRITTEN CONSENT OF COMPANY IS STRICTLY PROHIBITED, 
* AND IN VIOLATION OF APPLICABLE LAWS AND INTERNATIONAL TREATIES.  THE RECEIPT OR POSSESSION OF 
* THIS SOURCE CODE AND/OR RELATED INFORMATION DOES NOT CONVEY OR IMPLY ANY RIGHTS  
* TO REPRODUCE, DISCLOSE OR DISTRIBUTE ITS CONTENTS, OR TO MANUFACTURE, USE, OR SELL 
* ANYTHING THAT IT  MAY DESCRIBE, IN WHOLE OR IN PART.
* 
*/
package org.jsxm.jsxmcore.types;

import org.jsxm.jsxmcore.core.*;
import org.jsxm.jsxmcore.types.*;
import org.jsxm.jsxmcore.exceptions.*;

public abstract class PhoneCallSXM_base extends SXM{
    // this file was generated with the following specification
    public String getSpecification() {
       return "C:\\Tools\\Proiect MFIS\\jsxm\\PhoneCall\\src\\spec\\org\\jsxm\\examples\\Phone\\PhoneCall\\specification\\PhoneCall.xml";
    }

    // create the associated Sxm object
    {
        Sxm sxm = new Sxm(this);
    }
    
    
    // STATES
    State openedPhone = new State("openedPhone");
    { states.add(openedPhone); }
    State closedPhone = new State("closedPhone");
    { states.add(closedPhone); }
    State activeCall = new State("activeCall");
    { states.add(activeCall); }
    State onHoldCall = new State("onHoldCall");
    { states.add(onHoldCall); }
    {
        setInitialState(closedPhone);
    }
    //   
    //  PROCESSING FUNCTIONS (ABSTRACT CLASSES) 
    //   
    
    protected abstract class Function_openPhone extends Function {
        public Function_openPhone() {
            super("openPhone", new Input("openPhone", new Type[]{}, new String[]{}));
        }
        
    
        protected Output_openPhoneOut openPhoneOut = new Output_openPhoneOut();
        public Output getResponse() { 
            return openPhoneOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { closedPhone };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == closedPhone) return openedPhone;
            else throw new RuntimeException("Function 'openPhone'. No applicable postState!!");
        }
    }
    
    protected abstract class Function_closePhone extends Function {
        public Function_closePhone() {
            super("closePhone", new Input("closePhone", new Type[]{}, new String[]{}));
        }
        
    
        protected Output_closePhoneOut closePhoneOut = new Output_closePhoneOut();
        public Output getResponse() { 
            return closePhoneOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { openedPhone };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == openedPhone) return closedPhone;
            else throw new RuntimeException("Function 'closePhone'. No applicable postState!!");
        }
    }
    
    protected abstract class Function_startCall extends Function {
        public Function_startCall() {
            super("startCall", new Input("startCall", new Type[]{}, new String[]{}));
        }
        
    
        protected Output_startCallOut startCallOut = new Output_startCallOut();
        public Output getResponse() { 
            return startCallOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { openedPhone };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == openedPhone) return activeCall;
            else throw new RuntimeException("Function 'startCall'. No applicable postState!!");
        }
    }
    
    protected abstract class Function_holdCall extends Function {
        public Function_holdCall() {
            super("holdCall", new Input("holdCall", new Type[]{}, new String[]{}));
        }
        
    
        protected Output_holdCallOut holdCallOut = new Output_holdCallOut();
        public Output getResponse() { 
            return holdCallOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { activeCall };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == activeCall) return onHoldCall;
            else throw new RuntimeException("Function 'holdCall'. No applicable postState!!");
        }
    }
    
    protected abstract class Function_resumeCall extends Function {
        public Function_resumeCall() {
            super("resumeCall", new Input("resumeCall", new Type[]{}, new String[]{}));
        }
        
    
        protected Output_resumeCallOut resumeCallOut = new Output_resumeCallOut();
        public Output getResponse() { 
            return resumeCallOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { onHoldCall };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == onHoldCall) return activeCall;
            else throw new RuntimeException("Function 'resumeCall'. No applicable postState!!");
        }
    }
    
    protected abstract class Function_endCall extends Function {
        public Function_endCall() {
            super("endCall", new Input("endCall", new Type[]{}, new String[]{}));
        }
        
    
        protected Output_endCallOut endCallOut = new Output_endCallOut();
        public Output getResponse() { 
            return endCallOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { activeCall, onHoldCall };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == activeCall) return openedPhone;
            else if (preState == onHoldCall) return openedPhone;
            else throw new RuntimeException("Function 'endCall'. No applicable postState!!");
        }
    }
    //   
    //  PUBLIC METHODS for Interaction 
    //   
    
    public Output_closePhoneOut closePhone() {
        Input input = new Input("closePhone", new Type[]{}, new String[]{});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input closePhone() failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_closePhoneOut(output);
    }
    
    public Output_endCallOut endCall() {
        Input input = new Input("endCall", new Type[]{}, new String[]{});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input endCall() failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_endCallOut(output);
    }
    
    public Output_openPhoneOut openPhone() {
        Input input = new Input("openPhone", new Type[]{}, new String[]{});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input openPhone() failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_openPhoneOut(output);
    }
    
    public Output_holdCallOut holdCall() {
        Input input = new Input("holdCall", new Type[]{}, new String[]{});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input holdCall() failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_holdCallOut(output);
    }
    
    public Output_resumeCallOut resumeCall() {
        Input input = new Input("resumeCall", new Type[]{}, new String[]{});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input resumeCall() failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_resumeCallOut(output);
    }
    
    public Output_startCallOut startCall() {
        Input input = new Input("startCall", new Type[]{}, new String[]{});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input startCall() failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_startCallOut(output);
    }
    //   
    //  INNER CLASSES FOR INPUTS 
    //   
    protected class Input_closePhone{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_closePhone(Function f) {
            function = f;
        }
    }
    protected class Input_endCall{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_endCall(Function f) {
            function = f;
        }
    }
    protected class Input_openPhone{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_openPhone(Function f) {
            function = f;
        }
    }
    protected class Input_holdCall{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_holdCall(Function f) {
            function = f;
        }
    }
    protected class Input_resumeCall{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_resumeCall(Function f) {
            function = f;
        }
    }
    protected class Input_startCall{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_startCall(Function f) {
            function = f;
        }
    }
    //   
    //  INNER CLASSES FOR OUTPUTS 
    //   
    protected class Output_startCallOut{
        protected Output_startCallOut() {}
        protected Output_startCallOut(Output output) {
        }
        protected Output createOutput() {
            return new Output("startCallOut", 
                new Type[]{}, 
                new String[]{});
            }
    }
    protected class Output_holdCallOut{
        protected Output_holdCallOut() {}
        protected Output_holdCallOut(Output output) {
        }
        protected Output createOutput() {
            return new Output("holdCallOut", 
                new Type[]{}, 
                new String[]{});
            }
    }
    protected class Output_resumeCallOut{
        protected Output_resumeCallOut() {}
        protected Output_resumeCallOut(Output output) {
        }
        protected Output createOutput() {
            return new Output("resumeCallOut", 
                new Type[]{}, 
                new String[]{});
            }
    }
    protected class Output_endCallOut{
        protected Output_endCallOut() {}
        protected Output_endCallOut(Output output) {
        }
        protected Output createOutput() {
            return new Output("endCallOut", 
                new Type[]{}, 
                new String[]{});
            }
    }
    protected class Output_openPhoneOut{
        protected Output_openPhoneOut() {}
        protected Output_openPhoneOut(Output output) {
        }
        protected Output createOutput() {
            return new Output("openPhoneOut", 
                new Type[]{}, 
                new String[]{});
            }
    }
    protected class Output_closePhoneOut{
        protected Output_closePhoneOut() {}
        protected Output_closePhoneOut(Output output) {
        }
        protected Output createOutput() {
            return new Output("closePhoneOut", 
                new Type[]{}, 
                new String[]{});
            }
    }
}

