package test;

import static org.junit.Assert.*;
import org.junit.Test;

public class MailToolsTest {
    
    /**
     * @desc Validates if mailAddress is valid. It should be in the form of:
     *       <at least 1 character>@<at least 1 character>.<at least 1 character>
     * 
     * @subcontract no mailbox part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[0].length < 1;
     *   @ensures \result = false;
     */
    @Test
    public void testMailToolsRequiresNoMailboxPartEnsuresFalse(){
        //arrange 
        String emailAddress = "@mail.com";

        //act
        String result = MailTools.validateMailAddress(emailAddress);

        //assert
        assertEquals("false", result);
        }

    /** }
     *
     * @subcontract subdomain-tld delimiter {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".").length > 2;
     *   @ensures \result = false;
     * }
     */
    @Test
    public void testMailToolsRequiresSubdomainEnsuresFalse() {
        //arrange
        String emailAddress = "jg@gmail.co.ca";

        //act
        String result = MailTools.validateMailAddress(emailAddress);

        //assert
        assertEquals("false", result);
    }

     /**
     
     * 
     * @subcontract no subdomain part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".")[0].length < 1;
     *   @ensures \result = false;
     * }
     */
    @Test
    public void testMailToolsRequiresNoSubdomainPartEnsuresFalse() {
        //arrange
        String emailAddress = "jg@.com";

        //act
        String result = MailTools.validateMailAddress(emailAddress);

        //assert
        assertEquals("false", result);
    }

    /**
     
     * 
     * @subcontract no tld part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".")[1].length < 1;
     *   @ensures \result = false;
     * }
     */
    @Test
    public void testMailToolsRequiresNoTLDPartEnsuresFalse() {
        //arrange
        String emailAddress = "jg@gmail.";

        //act
        String result = MailTools.validateMailAddress(emailAddress);

        //assert
        assertEquals("false", result);
    }

    /**
     * 
     * @subcontract valid email {
     *   @requires no other precondition
     *   @ensures \result = true;
     * }
     */
    @Test
    public void testMailToolsRequiresValidEmailEnsuresTrue() {
        //arrange
        String emailAddress = "jog@gmail.com";

        //act
        String result = MailTools.validateMailAddress(emailAddress);

        //assert
        assertEquals("true", result);
    }

}