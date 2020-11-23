package rogue;

public class ImpossiblePositionException extends Exception {
    /**
    * Exception for an impossible position of an item, object or player.
    * @param errorMessage
    */
    public ImpossiblePositionException(String errorMessage) {
        super(errorMessage);
    }
}
