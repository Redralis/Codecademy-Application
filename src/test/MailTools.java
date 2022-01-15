package test;

public class MailTools {
    
    /**
     * @desc Validates if emailAddress is valid. It should be in the form of:
     *       <at least 1 character>@<at least 1 character>.<at least 1 character>
     * 
     * @subcontract no mailbox part {
     *   @requires !emailAddress.contains("@") ||
     *             emailAddress.split("@")[0].length < 1;
     *   @ensures \result = false;
     * }
     * 
     * @subcontract subdomain-tld delimiter {
     *   @requires !emailAddress.contains("@") ||
     *             emailAddress.split("@")[1].split(".").length > 2;
     *   @ensures \result = false;
     * }
     * 
     * @subcontract no subdomain part {
     *   @requires !emailAddress.contains("@") ||
     *             emailAddress.split("@")[1].split(".")[0].length < 1;
     *   @ensures \result = false;
     * }
     * 
     * @subcontract no tld part {
     *   @requires !emailAddress.contains("@") ||
     *             emailAddress.split("@")[1].split(".")[1].length < 1;
     *   @ensures \result = false;
     * }
     * 
     * @subcontract valid email {
     *   @requires no other precondition
     *   @ensures \result = true;
     * }
     * 
     */
    public static String validateMailAddress(String emailAddress) {
        if (!emailAddress.contains("@") || emailAddress.split("@")[0].length() < 1) {
            return "false";
        } else if (!emailAddress.contains("@") || emailAddress.split("@")[1].split("\\.").length > 2) {
            return "false";
        } else if (!emailAddress.contains("@") || emailAddress.split("@")[1].split("\\.")[0].length() < 1) {
            return "false";
        } else if (!emailAddress.contains("@") || emailAddress.split("@")[1].split("\\.").length < 2) {
            return "false";
        }
        return "true";
    }
}
