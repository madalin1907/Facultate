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

public class PhoneCallSXM extends PhoneCallSXM_base {

//************ INLINE CODE from <memory><declaration> ************
    ;
//************ END OF INLINE CODE ********************************


    public String memoryString() {
        String memory ="";
        return memory;
    }

    // Initial state and initial memory
    public void reset() {
        setCurrentState(getInitialState());
//************ INLINE CODE from <memory><initial> ****************
        ;
//************ END OF INLINE CODE ********************************

    }


//************   INLINE CODE from <methods>           ************
    ;
//************ END OF INLINE CODE ********************************


    // Processing Functions

    Function openPhone = new Function_openPhone() {

        public boolean preCondition() {
            return true;        }

        public void effect() {
//*** INLINE CODE from <function name="openPhone" ... ><effect> ***
            ;
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
//*** INLINE CODE from <inputgenerator function="openPhone">***
            ;
//*** END OF INLINE CODE  ***
        }
    };
    {
        functions.add(openPhone);
    }


    // Processing Functions

    Function closePhone = new Function_closePhone() {

        public boolean preCondition() {
            return true;        }

        public void effect() {
//*** INLINE CODE from <function name="closePhone" ... ><effect> ***
            ;
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
//*** INLINE CODE from <inputgenerator function="closePhone">***
            ;
//*** END OF INLINE CODE  ***
        }
    };
    {
        functions.add(closePhone);
    }


    // Processing Functions

    Function startCall = new Function_startCall() {

        public boolean preCondition() {
            return true;        }

        public void effect() {
//*** INLINE CODE from <function name="startCall" ... ><effect> ***
            ;
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
//*** INLINE CODE from <inputgenerator function="startCall">***
            ;
//*** END OF INLINE CODE  ***
        }
    };
    {
        functions.add(startCall);
    }


    // Processing Functions

    Function holdCall = new Function_holdCall() {

        public boolean preCondition() {
            return true;        }

        public void effect() {
//*** INLINE CODE from <function name="holdCall" ... ><effect> ***
            ;
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
//*** INLINE CODE from <inputgenerator function="holdCall">***
            ;
//*** END OF INLINE CODE  ***
        }
    };
    {
        functions.add(holdCall);
    }


    // Processing Functions

    Function resumeCall = new Function_resumeCall() {

        public boolean preCondition() {
            return true;        }

        public void effect() {
//*** INLINE CODE from <function name="resumeCall" ... ><effect> ***
            ;
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
//*** INLINE CODE from <inputgenerator function="resumeCall">***
            ;
//*** END OF INLINE CODE  ***
        }
    };
    {
        functions.add(resumeCall);
    }


    // Processing Functions

    Function endCall = new Function_endCall() {

        public boolean preCondition() {
            return true;        }

        public void effect() {
//*** INLINE CODE from <function name="endCall" ... ><effect> ***
            ;
//*** END OF INLINE CODE  ***
        }

        @Override
        public void findArgsForPrecondition() throws DefinitionNotFoundException  {
//*** INLINE CODE from <inputgenerator function="endCall">***
            ;
//*** END OF INLINE CODE  ***
        }
    };
    {
        functions.add(endCall);
    }
}
