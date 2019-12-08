package ttps.spring.exception;

public class InvalidTokenException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
    public String getMessage() {
        return "Token invalido";
    }
}
