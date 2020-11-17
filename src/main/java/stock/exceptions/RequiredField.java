package stock.exceptions;

public class RequiredField extends Exception {
    public RequiredField(String field) {
        super("Required field: " + field);
    }
}