package stock.exceptions;

public class ExceedsQuantity extends Exception{
    public ExceedsQuantity(String message) {
        super(message);
    }
}