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

public abstract class AccountSXM_base extends SXM{
    // this file was generated with the following specification
    public String getSpecification() {
       return "C:\\Tools\\Proiect MFIS\\jsxm\\Account\\src\\spec\\org\\jsxm\\examples\\Bank\\Account\\specification\\Account.xml";
    }

    // create the associated Sxm object
    {
        Sxm sxm = new Sxm(this);
    }
    
    
    // STATES
    State initial = new State("initial");
    { states.add(initial); }
    State opened = new State("opened");
    { states.add(opened); }
    State closed = new State("closed");
    { states.add(closed); }
    State normal = new State("normal");
    { states.add(normal); }
    {
        setInitialState(initial);
    }
    //   
    //  PROCESSING FUNCTIONS (ABSTRACT CLASSES) 
    //   
    
    protected abstract class Function_open extends Function {
        public Function_open() {
            super("open", new Input("open", new Type[]{}, new String[]{}));
        }
        
    
        protected Output_openOut openOut = new Output_openOut();
        public Output getResponse() { 
            return openOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { initial };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == initial) return opened;
            else throw new RuntimeException("Function 'open'. No applicable postState!!");
        }
    }
    
    protected abstract class Function_close extends Function {
        public Function_close() {
            super("close", new Input("close", new Type[]{}, new String[]{}));
        }
        
    
        protected Output_closeOut closeOut = new Output_closeOut();
        public Output getResponse() { 
            return closeOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { opened };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == opened) return closed;
            else throw new RuntimeException("Function 'close'. No applicable postState!!");
        }
    }
    
    protected abstract class Function_deposit_amount extends Function {
        public Function_deposit_amount() {
            super("deposit", new Input("deposit", new Type[]{new Int()}, new String[]{"amount"}));
        }
    
        protected Input_deposit deposit = new Input_deposit(this);

        public void evaluateArguments() {
            deposit.amount = ((Int) getArg(0)).getValue();
        }
    
    
        protected Output_depositOut depositOut = new Output_depositOut();
        public Output getResponse() { 
            return depositOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { opened, normal };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == opened) return normal;
            else if (preState == normal) return normal;
            else throw new RuntimeException("Function 'deposit'. No applicable postState!!");
        }
    }
    
    protected abstract class Function_withdrawN_amount extends Function {
        public Function_withdrawN_amount() {
            super("withdrawN", new Input("withdraw", new Type[]{new Int()}, new String[]{"amount"}));
        }
    
        protected Input_withdraw withdraw = new Input_withdraw(this);

        public void evaluateArguments() {
            withdraw.amount = ((Int) getArg(0)).getValue();
        }
    
    
        protected Output_withdrawOut withdrawOut = new Output_withdrawOut();
        public Output getResponse() { 
            return withdrawOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { normal };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == normal) return normal;
            else throw new RuntimeException("Function 'withdrawN'. No applicable postState!!");
        }
    }
    
    protected abstract class Function_withdraw0_amount extends Function {
        public Function_withdraw0_amount() {
            super("withdraw0", new Input("withdraw", new Type[]{new Int()}, new String[]{"amount"}));
        }
    
        protected Input_withdraw withdraw = new Input_withdraw(this);

        public void evaluateArguments() {
            withdraw.amount = ((Int) getArg(0)).getValue();
        }
    
    
        protected Output_withdrawOut withdrawOut = new Output_withdrawOut();
        public Output getResponse() { 
            return withdrawOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { normal };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == normal) return opened;
            else throw new RuntimeException("Function 'withdraw0'. No applicable postState!!");
        }
    }
    
    protected abstract class Function_readbalance extends Function {
        public Function_readbalance() {
            super("readbalance", new Input("getBalance", new Type[]{}, new String[]{}));
        }
        
    
        protected Output_getBalanceOut getBalanceOut = new Output_getBalanceOut();
        public Output getResponse() { 
            return getBalanceOut.createOutput();
        }
    
        public State[] preStates() {
            State[] p = { opened, normal };
            return p;
        }
    
        public State postState(State preState) {
            if (preState == opened) return opened;
            else if (preState == normal) return normal;
            else throw new RuntimeException("Function 'readbalance'. No applicable postState!!");
        }
    }
    //   
    //  PUBLIC METHODS for Interaction 
    //   
    
    public Output_getBalanceOut getBalance() {
        Input input = new Input("getBalance", new Type[]{}, new String[]{});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input getBalance() failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_getBalanceOut(output);
    }
    
    public Output_depositOut deposit(java.lang.Integer amount) {
        Input input = new Input("deposit", new Type[]{new Int(amount)}, new String[]{"amount"});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input deposit("+amount+") failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_depositOut(output);
    }
    
    public Output_closeOut close() {
        Input input = new Input("close", new Type[]{}, new String[]{});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input close() failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_closeOut(output);
    }
    
    public Output_openOut open() {
        Input input = new Input("open", new Type[]{}, new String[]{});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input open() failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_openOut(output);
    }
    
    public Output_withdrawOut withdraw(java.lang.Integer amount) {
        Input input = new Input("withdraw", new Type[]{new Int(amount)}, new String[]{"amount"});
        Output output = null;
        try {
            output = animateStep(input, SXM.CONTINUE_ON_ERROR);
        } catch (Exception e) {
            System.err.println("animation of input withdraw("+amount+") failed!");
            e.printStackTrace();
            System.exit(-1);
        }
        if (output instanceof Fault)
        throw new RuntimeException("\n*** Fault:" + output + " on input: " + input +
        		"\n*** Probably an error in the specification.  \n"+
        		"*** Either the precondition or the effect of a function\n"+
        		"*** produced a Fault instead of an Output during an interaction.");
        return new Output_withdrawOut(output);
    }
    //   
    //  INNER CLASSES FOR INPUTS 
    //   
    protected class Input_getBalance{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_getBalance(Function f) {
            function = f;
        }
    }
    protected class Input_deposit{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_deposit(Function f) {
            function = f;
        }
        private java.lang.Integer amount;

        public void set_amount(java.lang.Integer arg) throws DefinitionNotFoundException {
        //    the following assignment is not necessary
        //    since evaluatearguments is called at the end
        //    of setArg which causes input attributes to be set.
        //    this.amount = arg;
              function.setArgValue(0, new Int(arg));
              this.amount = arg;
        }
    
        public java.lang.Integer get_amount() {
             return amount;
        }
    }
    protected class Input_close{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_close(Function f) {
            function = f;
        }
    }
    protected class Input_open{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_open(Function f) {
            function = f;
        }
    }
    protected class Input_withdraw{
    
    // inputs have private access to their atributes 
    // set_ and get_ methods are used for access.
    
        protected Function function;
        public Input_withdraw(Function f) {
            function = f;
        }
        private java.lang.Integer amount;

        public void set_amount(java.lang.Integer arg) throws DefinitionNotFoundException {
        //    the following assignment is not necessary
        //    since evaluatearguments is called at the end
        //    of setArg which causes input attributes to be set.
        //    this.amount = arg;
              function.setArgValue(0, new Int(arg));
              this.amount = arg;
        }
    
        public java.lang.Integer get_amount() {
             return amount;
        }
    }
    //   
    //  INNER CLASSES FOR OUTPUTS 
    //   
    protected class Output_openOut{
        protected Output_openOut() {}
        protected Output_openOut(Output output) {
        }
        protected Output createOutput() {
            return new Output("openOut", 
                new Type[]{}, 
                new String[]{});
            }
    }
    protected class Output_depositOut{
        protected java.lang.Integer amount;
        protected Output_depositOut() {}
        protected Output_depositOut(Output output) {
            amount=((Int) output.getValue("amount")).getValue();
        }
        protected Output createOutput() {
            return new Output("depositOut", 
                new Type[]{new Int(amount)}, 
                new String[]{"amount"});
            }
    }
    protected class Output_closeOut{
        protected Output_closeOut() {}
        protected Output_closeOut(Output output) {
        }
        protected Output createOutput() {
            return new Output("closeOut", 
                new Type[]{}, 
                new String[]{});
            }
    }
    protected class Output_withdrawOut{
        protected java.lang.Integer amount;
        protected Output_withdrawOut() {}
        protected Output_withdrawOut(Output output) {
            amount=((Int) output.getValue("amount")).getValue();
        }
        protected Output createOutput() {
            return new Output("withdrawOut", 
                new Type[]{new Int(amount)}, 
                new String[]{"amount"});
            }
    }
    protected class Output_getBalanceOut{
        protected java.lang.Integer amount;
        protected Output_getBalanceOut() {}
        protected Output_getBalanceOut(Output output) {
            amount=((Int) output.getValue("amount")).getValue();
        }
        protected Output createOutput() {
            return new Output("getBalanceOut", 
                new Type[]{new Int(amount)}, 
                new String[]{"amount"});
            }
    }
}

