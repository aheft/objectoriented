package rogue;

public class NoSuchItemException extends Exception {
    /**
     * Exception for catching non-existent items.
     * @param errormessage
     */
    public NoSuchItemException(String errormessage) {
        super(errormessage);
    }
}
