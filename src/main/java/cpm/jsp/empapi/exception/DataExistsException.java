package cpm.jsp.empapi.exception;

public class DataExistsException extends RuntimeException {

    public DataExistsException(String message) {
        super(message);
    }
}
