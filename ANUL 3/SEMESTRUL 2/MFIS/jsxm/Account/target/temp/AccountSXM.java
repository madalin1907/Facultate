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
import org.jsxm.jsxmcore.exceptions.*;

;

public class AccountSXM extends AccountSXM_base {

//************ INLINE CODE from <memory><declaration> ************
    int balance;
//************ END OF INLINE CODE ********************************


    public String memoryString() {
        String memory ="";
//************ INLINE CODE from <memory><display> ********************
        memory += balance;
//************ END OF INLINE CODE ********************************
        return memory;
    }

    // Initial state and initial memory
    public void reset() {
        setCurrentState(getInitialState());
//************ INLINE CODE from <memory><initial> ****************
        balance = 0;
//************ END OF INLINE CODE ********************************

    }


//************   INLINE CODE from <methods>           ************
    ;
//************ END OF INLINE CODE ********************************


    // Processing Functions

    Function open = new Function_open() {

        public boolean preCondition() {
            return true;        }

        public void effect() {
//*** INLINE CODE from <function name="open" ... ><effect> ***
            ;
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
        }
    };
    {
        functions.add(open);
    }


    // Processing Functions

    Function close = new Function_close() {

        public boolean preCondition() {
            return true;        }

        public void effect() {
//*** INLINE CODE from <function name="close" ... ><effect> ***
            ;
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
        }
    };
    {
        functions.add(close);
    }


    // Processing Functions

    Function deposit = new Function_deposit_amount() {
    // use amount  for access to the arguments

        public boolean preCondition() {
            return
//*** INLINE CODE from <function name="deposit" ... ><precondition> ***
            deposit.get_amount() > 0;
//*** END OF INLINE CODE  ***
        }

        public void effect() {
//*** INLINE CODE from <function name="deposit" ... ><effect> ***
            balance = balance + deposit.get_amount(); depositOut.amount =
				deposit.get_amount();
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
//*** INLINE CODE from <inputgenerator function="deposit">***
            deposit.set_amount(5);
//*** END OF INLINE CODE  ***
        }
    };
    {
        functions.add(deposit);
    }


    // Processing Functions

    Function withdrawN = new Function_withdrawN_amount() {
    // use amount  for access to the arguments

        public boolean preCondition() {
            return
//*** INLINE CODE from <function name="withdrawN" ... ><precondition> ***
            withdraw.get_amount() > 0 && balance > withdraw.get_amount();
//*** END OF INLINE CODE  ***
        }

        public void effect() {
//*** INLINE CODE from <function name="withdrawN" ... ><effect> ***
            balance = balance - withdraw.get_amount(); withdrawOut.amount =
				withdraw.get_amount();
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
//*** INLINE CODE from <inputgenerator function="withdrawN">***
            if (balance != 1) withdraw.set_amount(1);
//*** END OF INLINE CODE  ***
        }
    };
    {
        functions.add(withdrawN);
    }


    // Processing Functions

    Function withdraw0 = new Function_withdraw0_amount() {
    // use amount  for access to the arguments

        public boolean preCondition() {
            return
//*** INLINE CODE from <function name="withdraw0" ... ><precondition> ***
            withdraw.get_amount() > 0 && balance == withdraw.get_amount();
//*** END OF INLINE CODE  ***
        }

        public void effect() {
//*** INLINE CODE from <function name="withdraw0" ... ><effect> ***
            balance = balance - withdraw.get_amount(); withdrawOut.amount =
				withdraw.get_amount();
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
//*** INLINE CODE from <inputgenerator function="withdraw0">***
            withdraw.set_amount(balance);
//*** END OF INLINE CODE  ***
        }
    };
    {
        functions.add(withdraw0);
    }


    // Processing Functions

    Function readbalance = new Function_readbalance() {

        public boolean preCondition() {
            return true;        }

        public void effect() {
//*** INLINE CODE from <function name="readbalance" ... ><effect> ***
            getBalanceOut.amount = balance;
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
        }
    };
    {
        functions.add(readbalance);
    }
}
