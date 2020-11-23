package rogue;

public class InvalidMoveException extends Exception {
    /**
    * Exception for an invalid move.
    * @param errorMessage
    */
    public InvalidMoveException(String errorMessage) {
        super(errorMessage);
    }
}
